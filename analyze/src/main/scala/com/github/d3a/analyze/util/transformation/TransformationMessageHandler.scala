package com.github.d3a.dataAnalyze.util.transformation

import akka.actor.ActorRef

abstract class TransformationMessageHandler {
  def handleTransformationMessage(transformationMessage:Any,transformationRouterActor:ActorRef,senderActor:ActorRef):Unit
}
