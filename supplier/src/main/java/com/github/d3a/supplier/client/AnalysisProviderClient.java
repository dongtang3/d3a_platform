package com.github.d3a.supplier.client;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.OnComplete;
import akka.dispatch.OnFailure;
import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.github.d3a.supplier.client.exception.AnalyseResponseFormatException;
import com.github.d3a.supplier.client.exception.AnalysisEngineRuntimeException;
import com.github.d3a.supplier.client.exception.ProviderClientInitException;
import com.github.d3a.supplier.communication.CommunicationActor;
import com.github.d3a.supplier.feature.communication.AnalyseResponseCallback;
import com.github.d3a.supplier.feature.communication.messagePayload.AnalyseRequest;
import com.github.d3a.supplier.feature.communication.messagePayload.AnalyseResponse;
import com.github.d3a.supplier.util.PropertyHandler;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AnalysisProviderClient {

    private String hostName;
    private int hostPort;
    private ActorSystem actorSystem;
    private ActorRef localCommunicationActor;
    private ActorSelection remoteCommunicationActor;

    public AnalysisProviderClient(String hostName, int hostPort){
        this.hostName = hostName;
        this.hostPort = hostPort;
    }

    public void openSession(){
        String configStr = "akka{" +
                "actor {"+
                    "provider = cluster," +
                    "serializers {  " +
                        "kryo = \"com.twitter.chill.akka.AkkaSerializer\"," +
                        "java = \"akka.serialization.JavaSerializer\""+
                    "}," +
                    "serialization-bindings {" +
                        "\"messagePayload.communication.feature.supplier.com.github.d3a.AnalyseRequest\" = kryo,"+
                        "\"messagePayload.communication.feature.supplier.com.github.d3a.AnalyseResponse\" = kryo"+
                    "}" +
                "},"+
                "remote {" +
                    "artery {" +
                        "transport = tcp," +
                        "canonical.hostname = \""+this.hostName+"\"," +
                        "canonical.port = "+this.hostPort+
                    "}" +
                "}," +
                "loglevel=ERROR" +
                "}";
        Config config = ConfigFactory.parseString(configStr);
        actorSystem = ActorSystem.create("AnalysisClientCommunicationSystem", config);
        localCommunicationActor = actorSystem.actorOf(Props.create(CommunicationActor.class), "localCommunicationActor");

        String providerCommunicationHostName= PropertyHandler.getConfigPropertyValue("providerCommunicationHostName");
        String providerCommunicationPort= PropertyHandler.getConfigPropertyValue("providerCommunicationPort");
        String path = "akka://DOCGAnalysisProviderCommunicationSystem@"+providerCommunicationHostName+":"+providerCommunicationPort+"/user/communicationRouter";
        remoteCommunicationActor = actorSystem.actorSelection(path);
    }

    public void closeSession() throws ProviderClientInitException {
        if(actorSystem != null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            actorSystem.terminate();
        }else{
            throw new ProviderClientInitException();
        }
    }

    public void sendAnalyseRequest(AnalyseRequest analyseRequest, AnalyseResponseCallback analyseResponseCallback, int timeoutSecond) throws ProviderClientInitException, AnalysisEngineRuntimeException{
        if(remoteCommunicationActor != null){
            if(analyseRequest != null){
                analyseRequest.generateMetaInfo();
                Timeout timeout = new Timeout(Duration.create(timeoutSecond, TimeUnit.SECONDS));
                Future<Object> future = Patterns.ask(remoteCommunicationActor, analyseRequest, timeout);
                future.onComplete(new OnComplete<Object>() {
                    @Override
                    public void onComplete(Throwable throwable, Object o) throws Throwable {
                        if (throwable != null) {
                            //System.out.println("返回结果异常�? + throwable.getMessage());
                            throwable.printStackTrace();
                        } else {
                            //System.out.println("返回消息�? + o);
                            analyseResponseCallback.onResponseReceived(o);
                        }
                    }
                }, actorSystem.dispatcher());
                // 成功，执行过�?
                future.onSuccess(new OnSuccess<Object>() {
                    @Override
                    public void onSuccess(Object msg) throws Throwable {
                        //System.out.println("回复的消息：" + msg);
                        if(msg instanceof AnalyseResponse){
                            analyseResponseCallback.onSuccessResponseReceived((AnalyseResponse)msg);
                        }else{
                            analyseResponseCallback.onFailureResponseReceived(new AnalyseResponseFormatException());
                        }
                    }
                }, actorSystem.dispatcher());
                //失败，执行过�?
                future.onFailure(new OnFailure() {
                    @Override
                    public void onFailure(Throwable throwable) throws Throwable {
                        if (throwable instanceof TimeoutException) {
                            //System.out.println("服务超时");
                            throwable.printStackTrace();
                        } else {
                            //System.out.println("未知错误");
                        }
                        analyseResponseCallback.onFailureResponseReceived(throwable);
                    }
                }, actorSystem.dispatcher());
            }else{
                throw new AnalysisEngineRuntimeException();
            }
        }else{
            throw new ProviderClientInitException();
        }
    }

    public void sendAnalyseRequest(AnalyseRequest analyseRequest) throws ProviderClientInitException,AnalysisEngineRuntimeException{
        if(localCommunicationActor != null){
            if(analyseRequest != null){
                analyseRequest.generateMetaInfo();
                localCommunicationActor.tell(analyseRequest,localCommunicationActor);
            }else{
                throw new AnalysisEngineRuntimeException();
            }
        }else{
            throw new ProviderClientInitException();
        }
    }
}
