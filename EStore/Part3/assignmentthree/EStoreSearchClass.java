/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentthree;

import java.io.File;

/**
 *
 * @author Aashin
 */
public class EStoreSearchClass {

    /**
     *
     * @param args takes in a string of arguments to run the program
     */
    public static void main(String[] args) {

        //gets fileName from commandline
        File inFile = null;
        if (0 < args.length) {
            inFile = new File(args[0]);
        } else {
            System.err.println("Filename was not specified! Format is: java assignmenttwo.ESToreSearchClass fileNameHere.txt");
            System.exit(0);
        }
        String fileName = inFile.toString(); //converts File type to string

        //creates GUI
        windowClass win = new windowClass(fileName);
        win.setVisible(true);

    }

}
