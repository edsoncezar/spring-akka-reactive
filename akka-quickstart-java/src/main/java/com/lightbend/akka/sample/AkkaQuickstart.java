package com.lightbend.akka.sample;

import java.io.IOException;

import com.lightbend.akka.sample.Greeter.Greet;
import com.lightbend.akka.sample.Greeter.WhoToGreet;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class AkkaQuickstart {
  public static void main(String[] args) {
    final ActorSystem system = ActorSystem.create("helloakka");
    try {
    	
      for (int i = 0; i < 200000; i++) {
    	
      //#create-actors
      final ActorRef printerActor = 
        system.actorOf(Printer.props(), "printerActor" + i);
      final ActorRef howdyGreeter = 
        system.actorOf(Greeter.props("Howdy" +i, printerActor), "howdyGreeter" +i);
      final ActorRef helloGreeter = 
        system.actorOf(Greeter.props("Hello" +i, printerActor), "helloGreeter" +i);
      final ActorRef goodDayGreeter = 
        system.actorOf(Greeter.props("Good day" +i, printerActor), "goodDayGreeter" +i);
      //#create-actors

      //#main-send-messages
      howdyGreeter.tell(new WhoToGreet("Akka" +i), ActorRef.noSender());
      howdyGreeter.tell(new Greet(), ActorRef.noSender());

      howdyGreeter.tell(new WhoToGreet("Lightbend" +i), ActorRef.noSender());
      howdyGreeter.tell(new Greet(), ActorRef.noSender());

      helloGreeter.tell(new WhoToGreet("Java" +i), ActorRef.noSender());
      helloGreeter.tell(new Greet(), ActorRef.noSender());

      goodDayGreeter.tell(new WhoToGreet("Play" +i), ActorRef.noSender());
      goodDayGreeter.tell(new Greet(), ActorRef.noSender());
      //#main-send-messages
      
      }	

      System.out.println(">>> Press ENTER to exit <<<");
      System.in.read();
      
      
    } catch (IOException ioe) {
    } finally {
      system.terminate();
    }
  }
}
