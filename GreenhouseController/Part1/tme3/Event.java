/**
 * TME-3
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 12/3/2017
//: innerclasses/controller/Event.java
// The common methods for any control event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
 */

package tme3;

import java.io.Serializable;

public abstract class Event implements Serializable {
  long eventTime, diff = 0;
  final long delayTime;
  public Event(long delayTime) {
    this.delayTime = delayTime;
    start();
  }
  public void start() { // Allows restarting
    eventTime = System.currentTimeMillis() + delayTime;
  }
  public boolean ready() {
    //Saves the difference in time in case we dump the object and checks if event time has reached current one
    diff = eventTime - System.currentTimeMillis(); //Step 4,5
    return System.currentTimeMillis() >= eventTime;
  }
  public abstract void action() throws ControllerException;
} ///:~
