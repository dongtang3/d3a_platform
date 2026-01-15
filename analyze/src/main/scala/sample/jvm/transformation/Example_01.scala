package sample.jvm.transformation

import akka.actor.{ActorSystem, Props}

object Example_01 extends App {
  val actorSyatem = ActorSystem("robot-system")
  val robotActor = actorSyatem.actorOf(Props(new RobotActor()), "robotActor") //创建一个机器人
  robotActor ! TurnOnLight(1) //给机器人发送一个开灯命�?
  robotActor ! BoilWater(2) //给机器人发送一个烧水命�?
  robotActor ! "who are you" //给机器人发送一个任意命�?
  actorSyatem terminate()
}
