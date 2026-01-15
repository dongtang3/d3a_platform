package com.github.d3a.supplier.fundamental.dataMaintenance

import dataService.dataComputeUnit.dataCompute.applicationCapacity.dataCompute.com.github.d3a.DataSlicePropertyType

import java.util

case class SpatialDataInfo(spatialDataPropertiesDefinition: util.HashMap[String, DataSlicePropertyType],
                           spatialDataValue: util.ArrayList[util.HashMap[String, Any]])
