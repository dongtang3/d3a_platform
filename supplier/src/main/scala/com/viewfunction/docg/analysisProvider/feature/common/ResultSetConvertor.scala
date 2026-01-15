package com.github.d3a.supplier.feature.common

import java.sql.ResultSet

abstract class ResultSetConvertor extends Serializable{
  def convertFunction(resultSet:ResultSet):Any
}
