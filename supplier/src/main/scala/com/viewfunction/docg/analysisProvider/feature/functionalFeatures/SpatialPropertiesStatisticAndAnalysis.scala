package com.github.d3a.supplier.feature.functionalFeatures

import com.github.d3a.supplier.feature.common.GlobalDataAccessor
import com.github.d3a.supplier.feature.communication.messagePayload.spatialAnalysis
import spatialAnalysis.messagePayload.communication.feature.analysisProvider.com.github.d3a.SpatialCommonConfig.PredicateType
import spatialAnalysis.messagePayload.communication.feature.analysisProvider.com.github.d3a.SpatialPropertiesAggregateStatisticRequest.{CalculationOperator, ObjectAggregationType}
import spatialAnalysis.messagePayload.communication.feature.analysisProvider.com.github.d3a.SpatialPropertiesAggregateStatisticRequest
import com.github.d3a.supplier.feature.techImpl.spark.spatial
import com.github.d3a.supplier.fundamental.spatial.SpatialPredicateType.SpatialPredicateType
import com.github.d3a.supplier.feature.techImpl.spark.spatial.{SpatialQueryMetaFunction, SpatialQueryParam}
import com.github.d3a.supplier.fundamental.spatial.SpatialPredicateType
import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.sql.functions.{avg, count, max, min, stddev, sum, variance}
import org.apache.spark.sql.types.{DoubleType, StructField, StructType}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object SpatialPropertiesStatisticAndAnalysis {

  val sliceGroupName = "defaultGroup"
  val spatialValuePropertyName = "CIM_GLGEOMETRYCONTENT"

  def executeSpatialPropertiesAggregateStatistic(globalDataAccessor:GlobalDataAccessor,statisticRequest:SpatialPropertiesAggregateStatisticRequest):
  messagePayload.communication.feature.analysisProvider.com.github.d3a.ResponseDataset = {
    val objectConception = statisticRequest.getObjectConception
    val subjectConception = statisticRequest.getSubjectConception
    val predicateType:PredicateType = statisticRequest.getPredicateType

    val subjectIdentityProperty = statisticRequest.getSubjectIdentityProperty
    val subjectCalculationProperty = statisticRequest.getSubjectCalculationProperty

    val objectCalculationProperty = statisticRequest.getObjectCalculationProperty
    val objectAggregationType:ObjectAggregationType = statisticRequest.getObjectAggregationType

    val subjectReturnProperties:Array[String] = statisticRequest.getSubjectReturnProperties
    val statisticResultProperty = statisticRequest.getStatisticResultProperty
    val calculationOperator:CalculationOperator = statisticRequest.getCalculationOperator

    val spatialQueryMetaFunction = new SpatialQueryMetaFunction

    //获取Subject conception(主体) 空间dataframe
    val subjectConceptionSpDFName = "subjectConceptionSpDF"
    val subjectConceptionSpatialAttributeName = "subjectConceptionGeoAttr"
    val subjectConceptionSpDF = globalDataAccessor.getDataFrameWithSpatialSupportFromDataSlice(subjectConception,sliceGroupName,spatialValuePropertyName,subjectConceptionSpDFName,subjectConceptionSpatialAttributeName)
    //subjectConceptionSpDF.printSchema()
    val subjectConception_spatialQueryParam = spatial.SpatialQueryParam(subjectConceptionSpDFName,subjectConceptionSpatialAttributeName,mutable.Buffer[String](subjectIdentityProperty))

    //获取Object conception(客体) 空间dataframe
    val objectConceptionSpDFName = "objectConceptionSpDF"
    val objectConceptionSpatialAttributeName = "objectConceptionGeoAttr"
    val objectConceptionSpDF = globalDataAccessor.getDataFrameWithSpatialSupportFromDataSlice(objectConception,sliceGroupName,spatialValuePropertyName,objectConceptionSpDFName,objectConceptionSpatialAttributeName)
    //objectConceptionSpDF.printSchema()
    val objectConception_spatialQueryParam = spatial.SpatialQueryParam(objectConceptionSpDFName,objectConceptionSpatialAttributeName,mutable.Buffer[String](objectCalculationProperty))

    //执行主体客体见的空间join计算
    val subject_objectSpJoinDFName = "subject_objectSpJoinDF"
    var spatialPredicateType:SpatialPredicateType = SpatialPredicateType.Contains
    predicateType match {
      case spatialAnalysis.SpatialCommonConfig.PredicateType.Contains =>
        spatialPredicateType = SpatialPredicateType.Contains
      case spatialAnalysis.SpatialCommonConfig.PredicateType.Intersects =>
        spatialPredicateType = SpatialPredicateType.Intersects
      case spatialAnalysis.SpatialCommonConfig.PredicateType.Crosses =>
        spatialPredicateType = SpatialPredicateType.Crosses
      case spatialAnalysis.SpatialCommonConfig.PredicateType.Within =>
        spatialPredicateType = SpatialPredicateType.Within
      case spatialAnalysis.SpatialCommonConfig.PredicateType.Equals =>
        spatialPredicateType = SpatialPredicateType.Equals
      case spatialAnalysis.SpatialCommonConfig.PredicateType.Touches =>
        spatialPredicateType = SpatialPredicateType.Touches
      case spatialAnalysis.SpatialCommonConfig.PredicateType.Overlaps =>
        spatialPredicateType = SpatialPredicateType.Overlaps
    }

    val subject_objectSpJoinDF = spatialQueryMetaFunction.spatialJoinQuery(globalDataAccessor,subjectConception_spatialQueryParam,spatialPredicateType,objectConception_spatialQueryParam,subject_objectSpJoinDFName)
    //subject_objectSpJoinDF.printSchema()

    //统计主体空间相关的客体的计算属性的聚合�?
    var subject_objectAggResultDF:DataFrame = null
    var aggregateColumnName:String = ""
    objectAggregationType match {
      case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.ObjectAggregationType.SUM =>
        subject_objectAggResultDF = subject_objectSpJoinDF.groupBy(subjectIdentityProperty).agg(sum(objectCalculationProperty))
        aggregateColumnName = "sum("+objectCalculationProperty+")"
      case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.ObjectAggregationType.AVG =>
        subject_objectAggResultDF = subject_objectSpJoinDF.groupBy(subjectIdentityProperty).agg(avg(objectCalculationProperty))
        aggregateColumnName = "avg("+objectCalculationProperty+")"
      case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.ObjectAggregationType.STDDEV =>
        subject_objectAggResultDF = subject_objectSpJoinDF.groupBy(subjectIdentityProperty).agg(stddev(objectCalculationProperty))
        aggregateColumnName = "stddev_samp("+objectCalculationProperty+")"
      case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.ObjectAggregationType.COUNT =>
        subject_objectAggResultDF = subject_objectSpJoinDF.groupBy(subjectIdentityProperty).agg(count(objectCalculationProperty))
        aggregateColumnName = "count("+objectCalculationProperty+")"
      case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.ObjectAggregationType.MAX =>
        subject_objectAggResultDF = subject_objectSpJoinDF.groupBy(subjectIdentityProperty).agg(max(objectCalculationProperty))
        aggregateColumnName = "max("+objectCalculationProperty+")"
      case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.ObjectAggregationType.MIN =>
        subject_objectAggResultDF = subject_objectSpJoinDF.groupBy(subjectIdentityProperty).agg(min(objectCalculationProperty))
        aggregateColumnName = "mix("+objectCalculationProperty+")"

      case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.ObjectAggregationType.VARIANCE =>
        subject_objectAggResultDF = subject_objectSpJoinDF.groupBy(subjectIdentityProperty).agg(variance(objectCalculationProperty))
        aggregateColumnName = "var_samp("+objectCalculationProperty+")"
    }

    //join 初始主体 df，获取相关属性信�?
    val mergedSubjectStaticResultDF = subject_objectAggResultDF.join(subjectConceptionSpDF,subjectIdentityProperty)
    //mergedSubjectStaticResultDF.printSchema()

    //过滤所需的属性信�?
    val propertiesList:ArrayBuffer[String] = ArrayBuffer[String](aggregateColumnName)
    if(subjectCalculationProperty != null){
      propertiesList += subjectCalculationProperty
    }
    if(subjectReturnProperties!=null){
      subjectReturnProperties.foreach(propItem=>{
        propertiesList += propItem
      })
    }
    val filterResDF = mergedSubjectStaticResultDF.select(subjectIdentityProperty,propertiesList:_*)
    //执行主体与客体的聚合统计值的数值计�?
    if(subjectCalculationProperty != null && calculationOperator!= null && statisticResultProperty != null){
      val calculationDF = filterResDF.select(subjectIdentityProperty,aggregateColumnName,subjectCalculationProperty)
      val calculationResultRDD = calculationDF.rdd.map(row=>{
        var calValue = 0.0
        calculationOperator match{
          case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.CalculationOperator.Add =>
            calValue = row.get(1).asInstanceOf[Double] + row.get(2).asInstanceOf[Double]
          case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.CalculationOperator.Subtract =>
            calValue = row.get(1).asInstanceOf[Double] - row.get(2).asInstanceOf[Double]
          case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.CalculationOperator.Multiply =>
            calValue = row.get(1).asInstanceOf[Double] * row.get(2).asInstanceOf[Double]
          case spatialAnalysis.SpatialPropertiesAggregateStatisticRequest.CalculationOperator.Divide =>
            calValue = row.get(1).asInstanceOf[Double] / row.get(2).asInstanceOf[Double]
        }
        Row(row.get(0),calValue)
      })
      val schema = StructType(
        Seq(
          calculationDF.schema.fields(0),//fields(0) should be subjectIdentityProperty
          StructField(statisticResultProperty,DoubleType,true)
        )
      )
      val calculationResultDF = globalDataAccessor.getSparkSession().createDataFrame(calculationResultRDD,schema)
      val finalCalculatedDF = filterResDF.join(calculationResultDF,subjectIdentityProperty)

      generateResultDataSet(finalCalculatedDF.schema,finalCalculatedDF.collect())
    }else{
      generateResultDataSet(filterResDF.schema,filterResDF.collect())
    }
  }

  def generateResultDataSet(dataStructure:StructType,dataRowArray:Array[Row]): messagePayload.communication.feature.analysisProvider.com.github.d3a.ResponseDataset = {
    val structureFields = dataStructure.fields
    val propertiesInfo = new java.util.HashMap[String,String]
    structureFields.foreach(item =>{
      propertiesInfo.put(item.name,item.dataType.typeName)
    })

    val dataList = new java.util.ArrayList[java.util.HashMap[String,Object]]
    dataRowArray.foreach(row=>{
      val currentMap = new java.util.HashMap[String,Object]
      dataList.add(currentMap)
      structureFields.foreach(fieldStructure=>{
        currentMap.put(fieldStructure.name,row.get(row.fieldIndex(fieldStructure.name)).asInstanceOf[AnyRef])
      })
    })

    new messagePayload.communication.feature.analysisProvider.com.github.d3a.ResponseDataset(propertiesInfo,dataList)
  }
}
