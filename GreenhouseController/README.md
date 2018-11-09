# GreenhouseController Assignment
## Project: Further Implementation and Adding Functionality

## Project Overview
This project aims to create an implementation of a basic design called controller. You are going to modify these programs to show you the various ways you can build on the basic design model using the capabilities of Java.

## Description
- Add a boolean instance variable to GreenhouseControls called "fans". Create two Event classes called FansOn and FansOff. The action() of these two classes should modify fan to true or false respectively. 
- Modify Bell Event so that it will be able to run an arbitrary number of times separated by 2000 msec each. To facilitate this requirement, you should generate the number of Bell Events specified in the rings parameter in the examples file. Please pay special attention to the possibility that other events might be run in between the various Bell events. 
- Modify Restart.action() to start the the system by reading events from a text file. Use Scanner and an appropriate regular expression. 
- Try running GreenhouseControls by: Java GreenhouseControls 4 examples1.txtu and Java GreenhouseControls 4 examples2.txt 
- The -f argument must be present. it must be either "-f" or "-d". Please see Part 4. The event information must be in the format specified in examples1.txt and examples2.txt. 
- Add functionality to simulate problems 1. Create a WindowMalfunction and PowerOut Events to simulate problems that may occur in a GreenhouseControls. The event should set the following boolean variables as appropriate in GreenhouseControls:  windowok = false; poweron = false; 
- After setting the variables, WindowMalfunction or PowerOut should throw an exception specifying the faulty condition. 
- Create a ControllerException class that extends Exception for this purpose. If an exception is thrown from WindowMalfunction or PowerOut, the Controller catches the exception, then initiates an emergency shutdown with an appropriate message. 
- Add a method to Controller called shutdown, and override this method in GreenhouseControls to accomplish the shutdown. 3. Add an instance variable in GreenhouseControls called errorcode. It indicates the nature of the problem with an error code in an int variable errorcode (1 for WindowMalfunction and 2 for PowerOut), logs the time and the reason for the shutdown in a text file in the current directory called error.log and prints it to the console. It then serializes and saves the entire GreenhouseControls object in a file dump.out in the current directory before exiting. 
- Run the following to test this part: Java GreenhouseControls -f examples3.txt and iava GreenhouseControls 4 examoles4.txt 
