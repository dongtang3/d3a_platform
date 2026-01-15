package com.github.d3a.supplier.fundamental.coreRealm

import payload.com.github.d3a.engine.core.EntitiesRetrieveStatistics
import term.com.github.d3a.engine.core.RelationshipEntity

abstract class RelationshipEntityHandler {
  def handleRelationshipEntity(relationshipEntity:RelationshipEntity,entitiesRetrieveStatistics:EntitiesRetrieveStatistics):Any
}
