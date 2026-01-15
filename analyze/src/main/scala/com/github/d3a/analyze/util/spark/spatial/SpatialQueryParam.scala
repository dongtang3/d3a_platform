package com.github.d3a.dataAnalyze.util.spark.spatial
import scala.collection.mutable

case class SpatialQueryParam(spatialDataFrameName:String,spatialAttributeName:String,resultAttributes:mutable.Buffer[String]) {}
