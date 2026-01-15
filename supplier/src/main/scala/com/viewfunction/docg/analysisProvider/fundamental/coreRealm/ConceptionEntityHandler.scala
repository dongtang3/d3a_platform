package com.github.d3a.supplier.fundamental.coreRealm

import payload.com.github.d3a.engine.core.EntitiesRetrieveStatistics
import term.com.github.d3a.engine.core.Entity

abstract class EntityHandler {
  def handleEntity(conceptionEntity:Entity, entitiesRetrieveStatistics:EntitiesRetrieveStatistics):Any
}
