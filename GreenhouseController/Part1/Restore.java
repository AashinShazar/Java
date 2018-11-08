/**
 * TME-3
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 12/3/2017
 *
 * The Restore class that restores the system after a shutdown.
 */

import tme3.Fixable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Restore { //Step 4,5
    public Restore(String dumpfile){
        GreenhouseControls gc = getOjbect(dumpfile);
        //Gets fixable object from previous shutdown error
        Fixable fix = gc.getFixable(gc.getError());
        fix.fix();
        fix.log();
        gc.run();
    }

    private GreenhouseControls getOjbect(String dumpfile){
        try{
            //Reads the dumped object from file and return it with explicit object type
            ObjectInputStream dump = new ObjectInputStream(new FileInputStream(dumpfile));
            Object gc = dump.readObject();
            dump.close();
            return (GreenhouseControls)gc;
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Unable to restore the object");
            System.exit(0);
        }
        return null;
    }
}
