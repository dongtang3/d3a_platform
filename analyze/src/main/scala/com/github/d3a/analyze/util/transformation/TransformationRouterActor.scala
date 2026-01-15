package com.github.d3a.dataAnalyze.util.transformation

import akka.actor.Actor

class TransformationRouterActor(transformationMessageHandler:TransformationMessageHandler) extends Actor {
  def receive = {
    case msg :Any =>
      transformationMessageHandler.handleTransformationMessage(msg,self,sender)
  }
}

