/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainassignmentone;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        //establishes two arrayLists to store the two types of products
        electronicsClass ecClass = new electronicsClass();
        bookClass bkClass = new bookClass();

        Scanner scanner = new Scanner(System.in);

        //uses the two arrayLists with the two custom classes for the two products
        ArrayList<bookClass> bookList = new ArrayList<>();
        ArrayList<electronicsClass> electronicList = new ArrayList<>();

        OUTER: //main command loop
        while (true) {
            ecClass = new electronicsClass();
            bkClass = new bookClass();
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

                                    if (addErrorCheck(bookID, bookName, bookYear) == true) { //checks for errors in user input
                                        if (electronicsClass.checkElecID(bookID, electronicList, bookList) == true
                                                && bookClass.checkBookID(bookID, bookList, electronicList) == true) { //checks for duplicate productIDs
                                            bkClass.setID(bookID);
                                            bkClass.setName(bookName);
                                            bkClass.setPrice(bookPrice);
                                            bkClass.setYear(bookYear);
                                            bkClass.setAuthor(bookAuthor);
                                            bkClass.setPublisher(bookPublisher);
                                            bookList.add(bkClass);
                                        }
                                    }

                                    break;

                                case "electronic": //second product type and user variant inputs
                                case "e":
                                case "E":
                                case "ELECTRONIC":
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

                                    if (addErrorCheck(electronicID, electronicName, electronicYear) == true) { //checks for errors again
                                        if (electronicsClass.checkElecID(electronicID, electronicList, bookList) == true
                                                && bookClass.checkBookID(electronicID, bookList, electronicList) == true) 
                                        { //checks for duplicate IDs
                                            ecClass.setID(electronicID);
                                            ecClass.setMaker(electronicMaker);
                                            ecClass.setPrice(electronicPrice);
                                            ecClass.setName(electronicName);
                                            ecClass.setYear(electronicYear);
                                            electronicList.add(ecClass);
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
                        System.out.println("Please enter the search parameters you know, if any."); //prompts user to enter any information they know

                        System.out.println("Product ID:");
                        String searchID = scanner.nextLine();
                        System.out.println("Name keywords:");
                        String searchName = scanner.nextLine();
                        System.out.println("Year:");
                        String searchYear = scanner.nextLine();

                        if (searchYear.contains("-")) { //if the year input contains a dash, it then determines what type of year range its looking for
                            if (searchYear.substring(0, 1).equals("-") && searchYear.length() == 5) { //here it looks for years in this format: -XXXX
                                bookClass.previousBookYears(searchYear, searchID, searchName, bookList);
                                electronicsClass.previousElecYears(searchYear, searchID, searchName, electronicList);
                            } 
                            else if (searchYear.substring(4, 5).equals("-") && searchYear.length() == 9) { //here it looks for years in this format: XXXX-YYYY
                                bookClass.rangeBookYears(searchYear, searchID, searchName, bookList);
                                electronicsClass.rangeElecYears(searchYear, searchID, searchName, electronicList);
                            } 
                            else if (searchYear.substring(4, 5).equals("-") && searchYear.length() == 5) { //here it looks for years in this format: XXXX-
                                bookClass.futureBookYears(searchYear, searchID, searchName, bookList);
                                electronicsClass.futureElecYears(searchYear, searchID, searchName, electronicList);
                            }
                        } 
                        else {
                            bookClass.commonBookSearch(searchYear, searchID, searchName, bookList); //if no dash is detected, just uses specified year or no year
                            electronicsClass.commonElecSearch(searchYear, searchID, searchName, electronicList); //checks both arrayLists
                        }

                        break;

                    case "quit": //variants of the quit option
                    case "q":
                    case "QUIT":
                    case "Q":
                        System.out.println("Program is ending. Thank you.");
                        break OUTER;
                    default:
                        System.out.println("Please enter a valid choice!"); //prompted if no valid choice is entered
                        break;
                }
            }
        }
    }

    /**
     *
     * @param subItem String that is being located within the string source
     * provided
     * @param source String that is being used to search for words within
     * @return returns true if the word is found within the source string
     */
    public static boolean matchContain(String subItem, String source) {

        if (source.isEmpty() == true) {
            return true;
        } else {

            String findWord = "\\b" + subItem + "\\b";
            Pattern patternWord = Pattern.compile(findWord.toLowerCase());
            Matcher matchWord = patternWord.matcher(source.toLowerCase());
            return matchWord.find();
        }
    }

    /**
     *
     * @param source String that words are being searched for within
     * @param subItem String of words that are being used to search
     * @return returns true if the keyWords are found within the source string
     */
    public static boolean matchKeywords(String source, String subItem) {

        String[] splitKeywords = subItem.split("\\s+");
        
        switch (splitKeywords.length) {
            case 1:
                return (matchContain(splitKeywords[0], source));
            case 2:
                return (matchContain(splitKeywords[0], source) && matchContain(splitKeywords[1], source));
            case 3:
                return (matchContain(splitKeywords[0], source) && matchContain(splitKeywords[1], source) && matchContain(splitKeywords[2], source));
            case 4:
                return (matchContain(splitKeywords[0], source) && matchContain(splitKeywords[1], source) && matchContain(splitKeywords[2], source) && matchContain(splitKeywords[3], source));
            default:
                break;
        }

        return true;
    }

    /**
     *
     * @param productID user specified string of productID
     * @param itemName user specified string of itemName
     * @param itemYear user specified string of itemYear
     * @return returns true if it passes all the error checking in user input
     */
    public static boolean addErrorCheck(String productID, String itemName, String itemYear) {
        if (productID.isEmpty() == true) {
            System.out.println("Product ID is a required value!");
            return false;
        }
        if (productID.matches("[0-9]+") && productID.length() == 6) {
            //good value
        } else {
            System.out.println("Product ID needs MUST be 6 numbers!");
            return false;
        }
        if (itemName.isEmpty() == true) {
            System.out.println("Item name is a required value!");
            return false;
        }

        if (itemYear.isEmpty() == true) {
            System.out.println("Item year is a required value!");
            return false;
        }
        if (itemYear.matches("[0-9]+") && itemYear.length() == 4) {
            //good value
        } else {
            System.out.println("Item year must be a 4 digit number!");
            return false;
        }

        int bookyrNum = Integer.parseInt(itemYear);

        if (bookyrNum < 1000 || bookyrNum > 9999) {
            System.out.println("Year value must be between 1000 and 9999!");
            return false;
        }
        return true;
    }

}
