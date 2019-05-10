package com.lightbend.akka.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

//#printer-messages
public class Printer extends AbstractActor {
//#printer-messages
  static public Props props() {
    return Props.create(Printer.class, () -> new Printer());
  }

  //#printer-messages
  static public class Greeting {
    public final String message;

    public Greeting(String message) {
      this.message = message;
    }
  }
  //#printer-messages

  private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

  private static long start = System.currentTimeMillis();
  
  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
  String date =  dateFormat.format(start);
  
  public Printer() {
  }

  @Override
  public Receive createReceive() { 
    return receiveBuilder()
        .match(Greeting.class, greeting -> {
            log.info(greeting.message + " "+ date);
        })
        .build();
  }
//#printer-messages
}
//#printer-messages
