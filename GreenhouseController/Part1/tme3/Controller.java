package tme3;

/**
 * TME-3
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 12/3/2017
//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Controller implements Serializable{
  // A class from java.util to hold Event objects:
  List<Event> eventList = new ArrayList<Event>();
  public void addEvent(Event c) { eventList.add(c); }

  public void run() {
    if(eventList.size() > 0){ //Step 4,5
      //Restores events time from dumped object
      for(Event e : eventList)
        if(e.diff > 0)
          e.eventTime = System.currentTimeMillis() + e.diff;
    }
    while(eventList.size() > 0)
      // Makes a copy so we don't cause trouble if the list gets edited
      for(Event e : new ArrayList<Event>(eventList))
      //Checks if event is ready, removes it, calls for action, if exception happens takes reason to shutdown method
        if(e.ready()) {
          eventList.remove(e);
          try {
            e.action();
            System.out.println(e);
          }catch(ControllerException x){ //Step 3,2
            shutdown(x.getMessage());
          }
        }
  }

  //Method to override
  public void shutdown(String reason){ //Step 3,2
    System.out.println(reason);
    System.out.println("System is shutting down");
    System.exit(0);
  }
} ///:~
