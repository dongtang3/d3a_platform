package analysisExample

import com.github.d3a.supplier.feature.common.GlobalDataAccessor
import com.github.d3a.supplier.feature.techImpl.spark.spatial
import com.github.d3a.supplier.feature.techImpl.spark.spatial.{SpatialQueryMetaFunction, SpatialQueryParam}
import com.github.d3a.supplier.fundamental.spatial.SpatialPredicateType
import com.github.d3a.supplier.providerApplication.AnalysisProviderApplicationUtil
import org.apache.spark.sql.Row
import org.apache.spark.sql.functions.{avg, stddev, sum}
import org.apache.spark.sql.types.{DoubleType, IntegerType, StringType, StructField, StructType}

import scala.collection.mutable

object RegionalGreeningRateCalculationExample extends App{

  val sparkApplicationName = AnalysisProviderApplicationUtil.getApplicationProperty("sparkApplicationName")
  val sparkMasterLocation = AnalysisProviderApplicationUtil.getApplicationProperty("sparkMasterLocation")
  val globalDataAccessor = new GlobalDataAccessor(sparkApplicationName,sparkMasterLocation)

  val spatialQueryMetaFunction = new SpatialQueryMetaFunction
  //获取树冠地理信息 dataframe
  val treeCanopySpDF = globalDataAccessor.getDataFrameWithSpatialSupportFromDataSlice("TreeCanopy","defaultGroup","CIM_GLGEOMETRYCONTENT","TreeCanopySpDF","geo_canopyArea")
  //treeCanopySpDF.printSchema()
  //获取社区地理信息 dataframe
  val communityReportingAreaSpDF = globalDataAccessor.getDataFrameWithSpatialSupportFromDataSlice("CommunityReportingArea","defaultGroup","CIM_GLGEOMETRYCONTENT","CommunityReportingSpArea","geo_reportingArea")
  //communityReportingAreaSpDF.printSchema()
  //社区地理信息df �?树冠地理信息df空间join，获取每一个社区中包含的树�?
  val communityReportingArea_spatialQueryParam = spatial.SpatialQueryParam("CommunityReportingSpArea","geo_reportingArea",mutable.Buffer[String]("GEN_ALIAS","NEIGHDIST","DETL_NAMES","OBJECTID"))
  val treeCanopy_spatialQueryParam = spatial.SpatialQueryParam("TreeCanopySpDF","geo_canopyArea",mutable.Buffer[String]("TC_CODE","TC_CLASS","SHAPE_AREA"))
  val reportingArea_treeCanopyJoinDF = spatialQueryMetaFunction.spatialJoinQuery(globalDataAccessor,communityReportingArea_spatialQueryParam,SpatialPredicateType.Contains,treeCanopy_spatialQueryParam,"reportingArea_treeCanopyJoinDF")
  //统计每个区域中的树冠数据信息
  val areaStaticResultDF = reportingArea_treeCanopyJoinDF.groupBy("OBJECTID").agg(sum("SHAPE_AREA"),avg("SHAPE_AREA"),stddev("SHAPE_AREA"))
  //join 初始area df，获取area相关属性信�?
  val mergedAreaStaticResultDF = areaStaticResultDF.join(communityReportingAreaSpDF,"OBJECTID")
  //过滤所需的属性信�?
  val staticResultDF = mergedAreaStaticResultDF.select("OBJECTID","sum(SHAPE_AREA)","SHAPE_AREA","GEN_ALIAS","NEIGHDIST","DETL_NAMES")
  //staticResultDF.printSchema()
  //计算绿化率�?
  val mappedResult = staticResultDF.rdd.map(row =>{
    val divValue = row.get(1).asInstanceOf[Double]/row.get(2).asInstanceOf[Double]
    Row(row.get(0).asInstanceOf[Int],
      row.get(1).asInstanceOf[Double],
      row.get(2).asInstanceOf[Double],
      row.get(3).asInstanceOf[String],
      row.get(4).asInstanceOf[String],
      row.get(5).asInstanceOf[String],
      divValue
    )
  })
  //创建sehcma，生成新的df
  val schema = StructType(
    Seq(
      StructField("OBJECTID",IntegerType,true),
      StructField("SUM_TreeCanopy",DoubleType,true),
      StructField("Area",DoubleType,true),
      StructField("GEN_ALIAS",StringType,true),
      StructField("NEIGHDIST",StringType,true),
      StructField("DETL_NAMES",StringType,true),
      StructField("GreeningRate",DoubleType,true)
    )
  )
  val finalResultDF = globalDataAccessor.getSparkSession().createDataFrame(mappedResult,schema)
  //finalResultDF.printSchema()
  finalResultDF.show(60)

  //Thread.sleep(5000)
  //globalDataAccessor.close()
}
