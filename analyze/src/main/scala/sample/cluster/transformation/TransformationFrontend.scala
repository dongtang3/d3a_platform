package sample.cluster.transformation

import sample.cluster.transformation.{TransformationResult, BackendRegistration, JobFailed, TransformationJob}
import language.postfixOps
import scala.concurrent.Future
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Terminated
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import akka.pattern.pipe
import akka.pattern.ask


class TransformationFrontend extends Actor {

  var backends = IndexedSeq.empty[ActorRef] //任务后台节点列表
  var jobCounter = 0

  def receive = {
    case job: TransformationJob if backends.isEmpty =>  //目前暂无执行任务节点可用
      sender() ! JobFailed("Service unavailable, try again later", job)

    case job: TransformationJob => //执行相应任务
      jobCounter += 1
      implicit val timeout = Timeout(5 seconds)
      val backend = backends(jobCounter % backends.size) //根据相应算法选择执行任务的节�?
      println(s"the backend is ${backend} and the job is ${job}")
      val result  = (backend ? job)
        .map(x => x.asInstanceOf[TransformationResult])  // 后台节点处理得到结果
      result pipeTo sender  //向外部系统发送执行结�?

    case BackendRegistration if !backends.contains(sender()) =>  // 添加新的后台任务节点
      context watch sender() //监控相应的任务节�?
      backends = backends :+ sender()

    case Terminated(a) =>
      backends = backends.filterNot(_ == a)  // 移除已经终止运行的节�?
  }
}
