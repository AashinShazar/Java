/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

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

        //grabs the filename from command line arguments
        File inFile = null;
        if (0 < args.length) {
            inFile = new File(args[0]);
        } else {
            System.err.println("Filename was not specified! Format is: java assignmenttwo.ESToreSearchClass fileNameHere.txt");
            System.exit(0);
        }
        HashMap<String, ArrayList<Integer>> hmap = new HashMap<>(); //creates hashmap
        ArrayList<Integer> e = new ArrayList<>(); //creates integer arrayList
        ArrayList<productClass> productList = new ArrayList<>(); //creates product arrayList

        String fileName = inFile.toString(); //converts File type to string
        productClass.fileInput(fileName, productList); //reads in input file
        productClass.hashmapAdd(productList, hmap); //sorts and adds file values to hashmap

        Scanner scanner = new Scanner(System.in);

        OUTER: //main command loop
        while (true) {
            electronicsClass ecClass = new electronicsClass();
            bookClass bkClass = new bookClass();
            System.out.println("Would you like to (a)dd|(s)earch|(q)uit?");
            String sentence = scanner.nextLine();

            if (null != sentence) {
                OUTER_1:
                switch (sentence) {
                    case "a": //add function and its variants
                    case "A":
                    case "add":
                    case "ADD":
                        System.out.println("Are you adding a (b)ook or an (e)lectronic?");
                        String addChoice = scanner.nextLine();
                        if (null != addChoice) {
                            switch (addChoice) {

                                case "book":
                                case "b":
                                case "B":
                                case "BOOK":
                                    System.out.println("Please enter the following information."); //gathers input for the book type
                                    System.out.println("Product ID:");
                                    String bookID = scanner.nextLine();
                                    System.out.println("Name:");
                                    String bookName = scanner.nextLine();
                                    System.out.println("Price:");
                                    String bookPrice = scanner.nextLine();
                                    System.out.println("Year");
                                    String bookYear = scanner.nextLine();
                                    System.out.println("Author:");
                                    String bookAuthor = scanner.nextLine();
                                    System.out.println("Publisher:");
                                    String bookPublisher = scanner.nextLine();

                                    if (productClass.addErrorCheck(bookID, bookName, bookYear) == true) { //checks for errors in user input
                                        if (electronicsClass.checkID(bookID, productList) == true) { //checks for duplicate productIDs
                                            bkClass.setID(bookID);
                                            bkClass.setName(bookName);
                                            bkClass.setPrice(bookPrice);
                                            bkClass.setYear(bookYear);
                                            bkClass.setAuthor(bookAuthor);
                                            bkClass.setPublisher(bookPublisher);
                                            bkClass.setType("book");
                                            productList.add(bkClass);
                                            productClass.hashmapAdd(productList, hmap); //updates hashmap
                                            System.out.println("New book product was added!");
                                        }
                                    }

                                    break;

                                case "electronic": //second product type and user variant inputs
                                case "e":
                                case "E":
                                case "ELECTRONIC":
                                case "Electronic":
                                    System.out.println("Please enter the following information."); //gathers user input
                                    System.out.println("Product ID:");
                                    String electronicID = scanner.nextLine();
                                    System.out.println("Name:");
                                    String electronicName = scanner.nextLine();
                                    System.out.println("Price:");
                                    String electronicPrice = scanner.nextLine();
                                    System.out.println("Year");
                                    String electronicYear = scanner.nextLine();
                                    System.out.println("Maker:");
                                    String electronicMaker = scanner.nextLine();

                                    if (productClass.addErrorCheck(electronicID, electronicName, electronicYear) == true) { //checks for errors again
                                        if (electronicsClass.checkID(electronicID, productList) == true) { //checks for duplicate IDs
                                            ecClass.setID(electronicID);
                                            ecClass.setMaker(electronicMaker);
                                            ecClass.setPrice(electronicPrice);
                                            ecClass.setName(electronicName);
                                            ecClass.setYear(electronicYear);
                                            ecClass.setType("electronic");
                                            productList.add(ecClass);
                                            productClass.hashmapAdd(productList, hmap); //updates hashmap
                                            System.out.println("New electronic product was added!");
                                        }

                                    }

                                    break;

                                default:
                                    System.out.println("Pleas select from (b)ook or (e)lectronic!"); //prompts user to choose a valid option
                                    break;
                            }
                        }
                        break;
                    case "S": //search option with its variants
                    case "s":
                    case "search":
                    case "SEARCH":
                    case "Search":

                        System.out.println("Please enter the search parameters you know, if any."); //prompts user to enter any information they know

                        System.out.println("Product ID:");
                        String searchID = scanner.nextLine();
                        System.out.println("Name keywords:");
                        String searchName = scanner.nextLine();
                        System.out.println("Year:");
                        String searchYear = scanner.nextLine();

                        if (searchName.isEmpty()) {
                            if (searchID.isEmpty() && searchYear.isEmpty()) {
                                for (int x = 0; x < productList.size(); x++) {
                                    System.out.println(productList.get(x));
                                }
                            } else if (searchYear.contains("-")) { //if the year input contains a dash, it then determines what type of year range its looking for
                                if (searchYear.substring(0, 1).equals("-") && searchYear.length() == 5) { //here it looks for years in this format: -XXXX
                                    productClass.previousYears(searchYear, searchID, productList, null, 0);
                                } else if (searchYear.substring(4, 5).equals("-") && searchYear.length() == 9) { //here it looks for years in this format: XXXX-YYYY
                                    productClass.rangeYears(searchYear, searchID, productList, null, 0);
                                } else if (searchYear.substring(4, 5).equals("-") && searchYear.length() == 5) { //here it looks for years in this format: XXXX-
                                    productClass.futureYears(searchYear, searchID, productList, null, 0);
                                }
                            } else {
                                productClass.commonSearch(searchYear, searchID, productList, null, 0); //if no dash is detected, just uses specified year or no year                   
                            }
                        } else if (searchYear.isEmpty() && searchID.isEmpty() && !searchName.isEmpty()) //if searchName has keywords ONLY, limited to 3 words
                        {
                            productClass.searchNameOnly(searchName, hmap, e, productList);

                        } else if (!searchName.isEmpty()) //searches for multiple fields
                        {
                            if (!searchYear.isEmpty() || !searchID.isEmpty()) {

                                if (searchYear.contains("-")) { //if the year input contains a dash, it then determines what type of year range its looking for
                                    if (searchYear.substring(0, 1).equals("-") && searchYear.length() == 5) { //here it looks for years in this format: -XXXX
                                        productClass.MultiplePreviousYears(searchYear, searchID, productList, productClass.returnNameIndex(searchName, hmap, e, productList));
                                    } else if (searchYear.substring(4, 5).equals("-") && searchYear.length() == 9) { //here it looks for years in this format: XXXX-YYYY
                                        productClass.MultipleRangeYears(searchYear, searchID, productList, productClass.returnNameIndex(searchName, hmap, e, productList));
                                    } else if (searchYear.substring(4, 5).equals("-") && searchYear.length() == 5) { //here it looks for years in this format: XXXX-
                                        productClass.MultipleFutureYears(searchYear, searchID, productList, productClass.returnNameIndex(searchName, hmap, e, productList));
                                    }
                                } else {
                                    productClass.MultipleCommonSearch(searchYear, searchID, productList, productClass.returnNameIndex(searchName, hmap, e, productList)); //if no dash is detected, just uses specified year or no year                   
                                }

                            }
                        } else if (searchYear.contains("-")) { //if the year input contains a dash, it then determines what type of year range its looking for
                            if (searchYear.substring(0, 1).equals("-") && searchYear.length() == 5) { //here it looks for years in this format: -XXXX
                                productClass.previousYears(searchYear, searchID, productList, e, 1);
                            } else if (searchYear.substring(4, 5).equals("-") && searchYear.length() == 9) { //here it looks for years in this format: XXXX-YYYY
                                productClass.rangeYears(searchYear, searchID, productList, e, 1);
                            } else if (searchYear.substring(4, 5).equals("-") && searchYear.length() == 5) { //here it looks for years in this format: XXXX-
                                productClass.futureYears(searchYear, searchID, productList, e, 1);
                            }
                        } else {
                            productClass.commonSearch(searchYear, searchID, productList, e, 1); //if no dash is detected, just uses specified year or no year                   
                        }

                        break;

                    case "quit": //variants of the quit option
                    case "q":
                    case "QUIT":
                    case "Q":
                    case "Quit":
                        System.out.println("Program is ending. Thank you.");

                        productClass.fileOutput(fileName, productList);

                        break OUTER;
                    default:
                        System.out.println("Please enter a valid choice!"); //prompted if no valid choice is entered
                        break;
                }
            }
        }
    }

}
