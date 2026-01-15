package com.github.d3a.supplier.providerApplication.communication

import akka.actor.Actor

class CommunicationActor(communicationMessageHandler:CommunicationMessageHandler) extends Actor {
  def receive = {
    case msg :Any =>
      communicationMessageHandler.handleMessage(msg,self,sender)
  }
}

