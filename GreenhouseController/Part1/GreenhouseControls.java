/**
 * TME-3
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 12/3/2017
//: innerclasses/GreenhouseControls.java
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
 */

import tme3.Controller;
import tme3.ControllerException;
import tme3.Event;
import tme3.Fixable;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GreenhouseControls extends Controller {
  boolean light = false;
  boolean water = false;
  boolean fans = false; //Step 2,1
  boolean windowok = true; //Step 3,1
  boolean poweron = true; //Step 3,1
  int errorcode = 0; //Step 3,3
  String thermostat = "Day";
  String eventsFile = "examples1.txt";


  public int getError(){ //Step 4,3
    return errorcode;
  }
  public Fixable getFixable(int errorcode){ //Step 4,4
    //Ternary operator for immediate condition
    return errorcode == 1 ? new FixWindow() : new PowerOn();
  }
  public class FixWindow implements Fixable{ //Step 4,1 & Step 4,2
    public void fix() {
      windowok = true;
      errorcode = 0;
    }
    public void log() {
      String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
      System.out.println(time);
      System.out.println("Window is functioning again");
      try {
        //Prints to fix.log two lines with time and reason of the fix
        PrintWriter write = new PrintWriter(new FileOutputStream(new File("fix.log")));
        write.println(time);
        write.print("The window have been fixed, now it is functioning again");
        write.close();
      }catch(IOException e){
        System.out.println("Error on making fix log");
      }
    }
  }
  public class PowerOn implements Fixable{ //Step 4,1 & Step 4,2
    public void fix() {
      poweron = true;
      errorcode = 0;
    }
    public void log() {
      String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
      System.out.println(time);
      System.out.println("Power is on again");
      try {
        //Prints to fix.log two lines with time and reason of the fix
        PrintWriter write = new PrintWriter(new FileOutputStream(new File("fix.log")));
        write.println(time);
        write.print("The power have been fixed, now it is on again");
        write.close();
      }catch(IOException e){
        System.out.println("Error on making fix log");
      }
    }
  }
  public class WindowMalfunction extends Event{ //Step 3,1
    public WindowMalfunction(long delayTime){ super(delayTime); }
    public void action() throws ControllerException{
      windowok = false;
      errorcode = 1;
      //Throws exception handled by the controller
      throw new ControllerException("Window is malfunctioning for a reason");
    }
  }
  public class PowerOut extends Event{ //Step 3,1
    public PowerOut(long delayTime){ super(delayTime); }
    public void action() throws ControllerException {
      poweron = false;
      errorcode = 2;
      //Throws exception handled by the controller
      throw new ControllerException("Power is out for a reason");
    }
  }
  public class FansOn extends Event { //Step 2,1
    public FansOn(long delayTime){ super(delayTime); }
    public void action(){
      fans = true;
    }
    public String toString() { return "Fans are on"; }
  }
  public class FansOff extends Event { //Step 2,1
    public FansOff(long delayTime){ super(delayTime); }
    public void action(){
      fans = false;
    }
    public String toString() { return "Fans are off"; }
  }
  public class LightOn extends Event {
    public LightOn(long delayTime) { super(delayTime); }
    public void action() {
      // Put hardware control code here to
      // physically turn on the light.
      light = true;
    }
    public String toString() { return "Light is on"; }
  }
  public class LightOff extends Event {
    public LightOff(long delayTime) { super(delayTime); }
    public void action() {
      // Put hardware control code here to
      // physically turn off the light.
      light = false;
    }
    public String toString() { return "Light is off"; }
  }
  public class WaterOn extends Event {
    public WaterOn(long delayTime) { super(delayTime); }
    public void action() {
      // Put hardware control code here.
      water = true;
    }
    public String toString() {
      return "Greenhouse water is on";
    }
  }
  public class WaterOff extends Event {
    public WaterOff(long delayTime) { super(delayTime); }
    public void action() {
      // Put hardware control code here.
      water = false;
    }
    public String toString() {
      return "Greenhouse water is off";
    }
  }
  public class ThermostatNight extends Event {
    public ThermostatNight(long delayTime) {
      super(delayTime);
    }
    public void action() {
      // Put hardware control code here.
      thermostat = "Night";
    }
    public String toString() {
      return "Thermostat on night state";
    }
  }
  public class ThermostatDay extends Event {
    public ThermostatDay(long delayTime) {
      super(delayTime);
    }
    public void action() {
      // Put hardware control code here.
      thermostat = "Day";
    }
    public String toString() {
      return "Thermostat on day state";
    }
  }
  // An example of an action() that inserts a
  // new one of itself into the event list:
  public class Bell extends Event {
    public Bell(long delayTime) { super(delayTime); }
    public void action() {
	// nothing to do
    }
    public String toString() { return "Bing!"; }
  }

  public class Restart extends Event {
    GreenhouseControls gc;
    public Restart(long delayTime, String filename, GreenhouseControls instance) {
      super(delayTime);
      eventsFile = filename;
      gc = instance;
    }

    public void action() { //Step 2,3
      if(!eventsFile.equals("defaultEvents")) {
        try {
          Scanner scan = new Scanner(new FileInputStream(eventsFile));
          //Reads every line looking for Event={value} and time={value}, rings in case it is a multiple bell event
          while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(",");
            String eventClass = line[0].split("=")[1];
            //System.out.println(eventClass);
            String time = line[1].split("=")[1];
            //System.out.println(time);
            if (line.length > 2) {
              int rings = Integer.parseInt(line[2].split("=")[1]);
              //System.out.println(rings);
              for (int i = 0; i < rings; i++) {
                //Adds bell events with 2000ms delay up to the rings number
                addEvent(new Bell(Long.parseLong(time) + (i * 2000)));
              }
            } else {
              //Adds new event instance using reflection with the same instance of the controller, assuming default constructor
              addEvent((Event) Class.forName("GreenhouseControls$".concat(eventClass))
                      .getConstructor(GreenhouseControls.class, Long.TYPE).newInstance(gc, Long.parseLong(time)));
            }
          }
          scan.close();
        } catch (FileNotFoundException e) {
          System.out.println("Events file is missing");
		  System.exit(0);
        } catch (NoSuchElementException | ArrayIndexOutOfBoundsException e) {
          System.out.println("Invalid events file format");
		  System.exit(0);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
          System.out.println("Invalid event name");
		  System.exit(0);
        }
      }else{
        addEvent(new ThermostatNight(0)); addEvent(new LightOn(2000)); addEvent(new WaterOff(8000)); addEvent(new ThermostatDay(10000));
        addEvent(new Bell(9000)); addEvent(new WaterOn(6000));addEvent(new LightOff(4000));addEvent(new Terminate(12000));
      }
    }

    public String toString() {
      return "Restarting system";
    }
  }

  @Override
  public void shutdown(String reason){ //Step 3,2 & Step 3,3
    String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    try {
      //Writes two lines, date and reason of shutdown, into error.log
      PrintWriter write = new PrintWriter(new FileOutputStream(new File("error.log")));
      write.println(time);
      write.print(reason);
      write.close();
      //Dumps the current object into a file we can later recover
      ObjectOutputStream dump = new ObjectOutputStream(new FileOutputStream(new File("dump.out")));
      dump.writeObject(this);
      dump.close();
    }catch(IOException e){
      System.out.println("Error on making shutdown log");
    }
    super.shutdown(reason);
  }

  public class Terminate extends Event {
    public Terminate(long delayTime) { super(delayTime); }
    public void action() { System.exit(0); }
    public String toString() { return "Terminating";  }
  }


  public static void printUsage() {
    System.out.println("Correct format: ");
    System.out.println("  java GreenhouseControls -f <filename>, or");
    System.out.println("  java GreenhouseControls -d dump.out");
  }

//---------------------------------------------------------
    public static void main(String[] args) {
	try {
	    String option = args[0];
	    String filename = args[1];

	    if ( !(option.equals("-f")) && !(option.equals("-d")) ) {
		System.out.println("Invalid option");
		printUsage();
	    }

      //In case there is a file to read or defaultEvents starts controller else restores it from dump.out
	    if (option.equals("-f"))  {
          GreenhouseControls gc = new GreenhouseControls();
          gc.addEvent(gc.new Restart(0,filename,gc));
          gc.run();
	    }else{
          new Restore(filename);
        }
	}
	catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("Invalid number of parameters");
	    printUsage();
	}
    }

} ///:~
