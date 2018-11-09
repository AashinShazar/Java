/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentthree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Aashin
 */
public abstract class productClass {

    private String itemPrice;
    private String itemName;
    private String itemYear;
    private String itemID;

    /**
     * No argument constructor
     */
    public productClass() {

    }

    /**
     *
     * @param itemPrice a string initializing item price
     * @param itemName a string initializing item name
     * @param itemYear a string initializing item year
     * @param itemID a string initializing item ID
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public productClass(String itemPrice, String itemName, String itemYear, String itemID) throws Exception {
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        this.itemYear = itemYear;
        this.itemID = itemID;

        if (itemID.isEmpty()) {
            throw new Exception("Product ID is a required value!" + "\n");
        }

        if (itemName.isEmpty()) {
            throw new Exception("Item name is a required value!" + "\n");
        }

        if (!itemID.matches("[0-9]+") || itemID.length() != 6) {
            throw new Exception("Product ID needs MUST be 6 numbers!" + "\n");
        }

        if (itemYear.isEmpty()) {
            throw new Exception("Item year is a required value!" + "\n");
        }
        if (!itemYear.matches("[0-9]+") || itemYear.length() != 4) {
            throw new Exception("Item year must be a 4 digit number!" + "\n");
        }

        int bookyrNum = Integer.parseInt(itemYear);

        if (bookyrNum < 1000 || bookyrNum > 9999) {
            throw new Exception("Year value must be between 1000 and 9999!" + "\n");
        }

    }

    /**
     *
     * @param itemName a string initializing item name
     * @param itemYear a string initializing item year
     * @param itemID a string initializing item ID
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public productClass(String itemName, String itemYear, String itemID) throws Exception {
        this.itemName = itemName;
        this.itemYear = itemYear;
        this.itemID = itemID;

        if (itemID.isEmpty()) {
            throw new Exception("Product ID is a required value!" + "\n");
        }

        if (!itemID.matches("[0-9]+") || itemID.length() != 6) {
            throw new Exception("Product ID needs MUST be 6 numbers!" + "\n");
        }

        if (itemName.isEmpty()) {
            throw new Exception("Item name is a required value!" + "\n");
        }

        if (itemYear.isEmpty()) {
            throw new Exception("Item year is a required value!" + "\n");
        }
        if (!itemYear.matches("[0-9]+") || itemYear.length() != 4) {
            throw new Exception("Item year must be a 4 digit number!" + "\n");
        }

        int bookyrNum = Integer.parseInt(itemYear);

        if (bookyrNum < 1000 || bookyrNum > 9999) {
            throw new Exception("Year value must be between 1000 and 9999!" + "\n");
        }

    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getName() {
        return itemName;
    }

    /**
     *
     * @param itemName uses this string to set the value of the private string
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public void setName(String itemName) throws Exception {
        if (itemName.isEmpty()) {
            throw new Exception("Item name is a required value!" + "\n");
        } else {
            this.itemName = itemName;
        }

    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getPrice() {
        return itemPrice;
    }

    /**
     *
     * @param itemPrice uses this string to set the value of the private string
     */
    public void setPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getYear() {
        return itemYear;
    }

    /**
     *
     * @param itemYear uses this string to set the value of the private string
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public void setYear(String itemYear) throws Exception {

        if (itemYear.isEmpty()) {
            throw new Exception("Item year is a required value!" + "\n");
        } else {
            this.itemYear = itemYear;
        }
        if (!itemYear.matches("[0-9]+") || itemYear.length() != 4) {
            throw new Exception("Item year must be a 4 digit number!" + "\n");
        } else {
            this.itemYear = itemYear;
        }

        int bookyrNum = Integer.parseInt(itemYear);

        if (bookyrNum < 1000 || bookyrNum > 9999) {
            throw new Exception("Year value must be between 1000 and 9999!" + "\n");
        } else {
            this.itemYear = itemYear;
        }
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getID() {
        return itemID;
    }

    /**
     *
     * @param itemID uses this string to set the value of the private string
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public void setID(String itemID) throws Exception {

        if (itemID.isEmpty()) {
            throw new Exception("Product ID is a required value!" + "\n");
        } else {
            this.itemID = itemID;
        }

    }

    /**
     *
     * @param prevYear takes in an input specified by the user to establish the
     * upper limit on the year search
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param sourceList a specified arrayList to search for the provided input
     * in
     * @param index specifies which index to specifically look for the multiple
     * fields
     */
    public static void MultiplePreviousYears(String prevYear, String productID, ArrayList<productClass> sourceList, int index[]) {
        //System.out.println("Years up to this year is included.");
        int pastYears = Integer.parseInt(prevYear);

        for (int y = 1000; y < pastYears + 1; y++) {
            for (int x = 0; x < index.length; x++) {
                if (matchContain(sourceList.get(index[x]).getID(), productID)
                        && matchContain(sourceList.get(index[x]).getYear(), String.valueOf(y))) {
                    windowClass.outputToDisplay("Item found via up to years: " + "\n" + sourceList.get(index[x]), null);
                }
            }
        }
    }

    /**
     *
     * @param rangeYear1 takes in a first input specified by the user to
     * establish the range of years to search in
     * @param rangeYear2 takes in a second input specified by the user to
     * establish the range of years to search in
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param sourceList a specified arrayList to search for the provided input
     * in
     * @param index specifies which index to specifically look for the multiple
     * fields
     */
    public static void MultipleRangeYears(String rangeYear1, String rangeYear2, String productID, ArrayList<productClass> sourceList, int index[]) {
        //System.out.println("This is a range of years.");
        int rangeYears1 = Integer.parseInt(rangeYear1);
        int rangeYears2 = Integer.parseInt(rangeYear2);

        for (int y = rangeYears1; y < rangeYears2 + 1; y++) {
            for (int x = 0; x < index.length; x++) {
                if (matchContain(sourceList.get(index[x]).getID(), productID)
                        && matchContain(sourceList.get(index[x]).getYear(), String.valueOf(y))) {
                    windowClass.outputToDisplay("Item found via range years: " + "\n" + sourceList.get(index[x]), null);

                }
            }
        }
    }

    /**
     *
     * @param futureYear takes in an input specified by the user to establish
     * the lower limit of ranges to search from
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param sourceList a specified arrayList to search for the provided input
     * in
     * @param index specifies which index to specifically look for the multiple
     * fields
     */
    public static void MultipleFutureYears(String futureYear, String productID, ArrayList<productClass> sourceList, int index[]) {
        //System.out.println("Years after this year is included.");
        int futureYears = Integer.parseInt(futureYear);

        for (int y = futureYears; y < 9999; y++) {
            for (int x = 0; x < index.length; x++) {
                if (matchContain(sourceList.get(index[x]).getID(), productID)
                        && matchContain(sourceList.get(index[x]).getYear(), String.valueOf(y))) {
                    windowClass.outputToDisplay("Item found in years after " + "\n" + sourceList.get(index[x]), null);

                }
            }

        }
    }

    /**
     *
     * @param commonYear takes in an input specified by the user to search for
     * just a year
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param sourceList a specified arrayList to search for the provided input
     * in
     * @param index specifies which index to specifically look for the multiple
     * fields
     */
    public static void MultipleCommonSearch(String commonYear, String productID, ArrayList<productClass> sourceList, int index[]) {

        if (commonYear.isEmpty() && productID.isEmpty()) {
            for (int x = 0; x < sourceList.size(); x++) {
                windowClass.outputToDisplay("Listing all items: " + "\n" + sourceList.get(x), null);
            }
        } else {
            for (int x = 0; x < index.length; x++) {
                if (matchContain(sourceList.get(index[x]).getID(), productID)
                        && matchContain(sourceList.get(index[x]).getYear(), commonYear)) {

                    windowClass.outputToDisplay("Item found: " + "\n" + sourceList.get(index[x]), null);
                } else {
                    //windowClass.outputToDisplay("Item was not found!", null);
                }

            }
        }
    }

    /**
     *
     * @param prevYear takes in an input specified by the user to establish the
     * upper limit on the year search
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param sourceList a specified arrayList to search for the provided input
     * in
     * @param exclusiveList a specified arrayList containing the index values of
     * the successful hashMap search
     * @param value an integer that checks if the hashMap search was successful
     * based on 0 meaning false and 1 meaning true
     */
    public static void previousYears(String prevYear, String productID, ArrayList<productClass> sourceList, ArrayList<Integer> exclusiveList, int value) {
        //System.out.println("Years up to this year is included.");
        int pastYears = Integer.parseInt(prevYear);

        if (value != 0) {
            for (int x = 0; x < sourceList.size(); x++) {
                for (int y = 1000; y < pastYears + 1; y++) {

                    if (matchContain(sourceList.get(x).getID(), productID)
                            && matchContain(sourceList.get(x).getYear(), String.valueOf(y))) {
                        windowClass.outputToDisplay("Item found via up to years: " + "\n" + sourceList.get(x), null);
                        break;
                    }
                }
            }
        } else {
            for (int x = 0; x < sourceList.size(); x++) {
                for (int y = 1000; y < pastYears + 1; y++) {

                    if (matchContain(sourceList.get(x).getID(), productID)
                            && matchContain(sourceList.get(x).getYear(), String.valueOf(y))) {
                        windowClass.outputToDisplay("Item found via up to years: " + "\n" + sourceList.get(x), null);
                        break;
                    }
                }
                //System.out.println("Item was not found in years before!");
            }
        }

    }

    /**
     *
     * @param rangeYear1 takes in a first input specified by the user to
     * establish the range of years to search in
     * @param rangeYear2 takes in a second input specified by the user to
     * establish the range of years to search in
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param sourceList a specified arrayList to search for the provided input
     * in
     * @param exclusiveList a specified arrayList containing the index values of
     * the successful hashMap search
     * @param value an integer that checks if the hashMap search was successful
     * based on 0 meaning false and 1 meaning true
     */
    public static void rangeYears(String rangeYear1, String rangeYear2, String productID, ArrayList<productClass> sourceList, ArrayList<Integer> exclusiveList, int value) {
        //System.out.println("This is a range of years.");
        int rangeYears1 = Integer.parseInt(rangeYear1);
        int rangeYears2 = Integer.parseInt(rangeYear2);

        if (value != 0) {
            for (int x = 0; x < exclusiveList.size(); x++) {
                for (int y = rangeYears1; y < rangeYears2 + 1; y++) {

                    if (matchContain(sourceList.get(x).getID(), productID)
                            && matchContain(sourceList.get(x).getYear(), String.valueOf(y))) {
                        windowClass.outputToDisplay("Item found via range years: " + "\n" + sourceList.get(x), null);
                        break;
                    }
                }
            }
        } else {
            for (int x = 0; x < sourceList.size(); x++) {

                for (int y = rangeYears1; y < rangeYears2 + 1; y++) {

                    if (matchContain(sourceList.get(x).getID(), productID)
                            && matchContain(sourceList.get(x).getYear(), String.valueOf(y))) {
                        windowClass.outputToDisplay("Item found via range years: " + "\n" + sourceList.get(x), null);
                        break;
                    }
                }
                //searchDisplay.append("Item was not found in range of years!");
            }
        }

    }

    /**
     *
     * @param futureYear takes in an input specified by the user to establish
     * the lower limit of ranges to search from
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param sourceList a specified arrayList to search for the provided input
     * in
     * @param exclusiveList a specified arrayList containing the index values of
     * the successful hashMap search
     * @param value an integer that checks if the hashMap search was successful
     * based on 0 meaning false and 1 meaning true
     */
    public static void futureYears(String futureYear, String productID, ArrayList<productClass> sourceList, ArrayList<Integer> exclusiveList, int value) {
        //System.out.println("Years after this year is included.");
        int futureYears = Integer.parseInt(futureYear);

        if (value != 0) {
            for (int x = 0; x < exclusiveList.size(); x++) {
                for (int y = futureYears; y < 9999; y++) {

                    if (matchContain(sourceList.get(x).getID(), productID)
                            && matchContain(sourceList.get(x).getYear(), String.valueOf(y))) {
                        windowClass.outputToDisplay("Item found in years after " + "\n" + sourceList.get(x), null);
                        break;
                    }
                }
            }
        } else {
            for (int x = 0; x < sourceList.size(); x++) {
                for (int y = futureYears; y < 9999; y++) {

                    if (matchContain(sourceList.get(x).getID(), productID)
                            && matchContain(sourceList.get(x).getYear(), String.valueOf(y))) {
                        windowClass.outputToDisplay("Item found in years after " + "\n" + sourceList.get(x), null);
                        break;
                    }
                }
                //System.out.println("Item was not found in years after!");
            }
        }
    }

    /**
     *
     * @param commonYear takes in an input specified by the user to search for
     * just a year
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param sourceList a specified arrayList to search for the provided input
     * in
     * @param exclusiveList a specified arrayList containing the index values of
     * the successful hashMap search
     * @param value an integer that checks if the hashMap search was successful
     * based on 0 meaning false and 1 meaning true
     */
    public static void commonSearch(String commonYear, String productID, ArrayList<productClass> sourceList, ArrayList<Integer> exclusiveList, int value) {

        if (commonYear.isEmpty() && productID.isEmpty()) {
            for (int x = 0; x < sourceList.size(); x++) {
                windowClass.outputToDisplay("Listing all items: " + "\n" + sourceList.get(x), null);
            }
        } else if (value != 0) {
            for (int x = 0; x < exclusiveList.size(); x++) {
                if (matchContain(sourceList.get(x).getID(), productID)
                        && matchContain(sourceList.get(x).getYear(), commonYear)) {

                    windowClass.outputToDisplay("Item found: " + "\n" + sourceList.get(x), null);
                } else {
                    //   windowClass.outputToDisplay("Item was not found!", null);
                }
            }

        } else {
            for (int x = 0; x < sourceList.size(); x++) {

                if (matchContain(sourceList.get(x).getID(), productID)
                        && matchContain(sourceList.get(x).getYear(), commonYear)) {

                    windowClass.outputToDisplay("Item found: " + "\n" + sourceList.get(x), null);
                } else if (x == sourceList.size() - 1) {
                    // windowClass.outputToDisplay("Item was not found!", null);
                }
            }
        }
    }

    /**
     *
     * @param fileName a string containing the file name to be used for input
     * and output
     * @param sourceList a arrayList containing all the products in this program
     */
    public static void fileInput(String fileName, ArrayList<productClass> sourceList) {
        try {
            File f = new File(fileName);
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(f)));

            while (scanner.hasNextLine()) {
                String splitThis = scanner.nextLine();
                String[] typeTok = splitThis.split("productID = |name = |price = |year = |authors = |publisher = |maker = ");

                if (typeTok[0].contains("book")) {
                    bookClass bkClass = new bookClass();
                    String productID = scanner.nextLine();
                    String itemName = scanner.nextLine();
                    String itemPrice = scanner.nextLine();
                    String itemYear = scanner.nextLine();
                    String itemAuthor = scanner.nextLine();
                    String itemPublisher = scanner.nextLine();

                    bkClass.setType("book");
                    bkClass.setID(productID.substring(productID.indexOf("\"") + 1, productID.lastIndexOf("\"")));
                    bkClass.setName(itemName.substring(itemName.indexOf("\"") + 1, itemName.lastIndexOf("\"")));
                    bkClass.setPrice(itemPrice.substring(itemPrice.indexOf("\"") + 1, itemPrice.lastIndexOf("\"")));
                    bkClass.setYear(itemYear.substring(itemYear.indexOf("\"") + 1, itemYear.lastIndexOf("\"")));
                    bkClass.setAuthor(itemAuthor.substring(itemAuthor.indexOf("\"") + 1, itemAuthor.lastIndexOf("\"")));
                    bkClass.setPublisher(itemPublisher.substring(itemPublisher.indexOf("\"") + 1, itemPublisher.lastIndexOf("\"")));
                    sourceList.add(bkClass);

                } else if (typeTok[0].contains("electronics")) {
                    electronicsClass ecClass = new electronicsClass();
                    String productID = scanner.nextLine();
                    String itemName = scanner.nextLine();
                    String itemPrice = scanner.nextLine();
                    String itemYear = scanner.nextLine();
                    String itemMaker = scanner.nextLine();

                    ecClass.setType("electronics");
                    ecClass.setID(productID.substring(productID.indexOf("\"") + 1, productID.lastIndexOf("\"")));
                    ecClass.setName(itemName.substring(itemName.indexOf("\"") + 1, itemName.lastIndexOf("\"")));
                    ecClass.setPrice(itemPrice.substring(itemPrice.indexOf("\"") + 1, itemPrice.lastIndexOf("\"")));
                    ecClass.setYear(itemYear.substring(itemYear.indexOf("\"") + 1, itemYear.lastIndexOf("\"")));
                    ecClass.setMaker(itemMaker.substring(itemMaker.indexOf("\"") + 1, itemMaker.lastIndexOf("\"")));
                    sourceList.add(ecClass);

                }

            }

        } catch (Exception e) {
            System.out.println("Could not open file!");
            // e.printStackTrace();
        }
    }

    /**
     *
     * @param fileName a string containing the file name used for input and
     * output of products
     * @param sourceList a arrayList containing all the products in this program
     */
    public static void fileOutput(String fileName, ArrayList<productClass> sourceList) {
        try {

            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for (int i = 0; i < sourceList.size(); i++) {
                writer.println(sourceList.get(i));
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Failed to write.");
            //e.printStackTrace();
        }
    }

    /**
     *
     * @param sourceList a arrayList containing all the products in this program
     * @param hmap a arraylist of integers used in the hashmap creation
     */
    public static void hashmapAdd(ArrayList<productClass> sourceList, HashMap<String, ArrayList<Integer>> hmap) {
        int total;
        total = 0;

        for (int f = 0; f < sourceList.size(); f++) {
            String str = sourceList.get(f).getName().toLowerCase();
            String[] splited = str.split("\\s+");

            for (int z = 0; z < splited.length; z++) {
                //System.out.println(splited[z] + " z is " + total);
                hashmapListAdd(splited[z], total, hmap);
            }
            total++;

        }
    }

    /**
     *
     * @param keyValue a string value that is stored within the hashmap
     * @param itemValue a integer value that is stored along with the keyValue
     * @param hmap a arraylist of integers used in the hashmap creation
     */
    public static void hashmapListAdd(String keyValue, Integer itemValue, HashMap<String, ArrayList<Integer>> hmap) {
        List<Integer> hmapList = hmap.get(keyValue);

        // if list does not exist create it
        if (hmapList == null) {
            hmapList = new ArrayList<>();
            hmapList.add(itemValue);
            hmap.put(keyValue, (ArrayList<Integer>) hmapList);
        } else // add if item is not already in list
         if (!hmapList.contains(itemValue)) {
                hmapList.add(itemValue);
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
     * @param searchName value passed in to search for
     * @param hmap hashmap value to search in
     * @param e integer arraylist that accompanies hashmap
     * @param productList sourcelist where all the products are stored
     */
    public static void searchNameOnly(String searchName, HashMap<String, ArrayList<Integer>> hmap, ArrayList<Integer> e, ArrayList<productClass> productList) {
        String[] splitKeywords = searchName.split("\\s+");

        if (splitKeywords.length == 1) {
            if (hmap.containsKey(splitKeywords[0])) {
                e = hmap.get(splitKeywords[0]);
                //System.out.println(e);
                for (int x = 0; x < e.size(); x++) {

                    windowClass.outputToDisplay("", productList.get(e.get(x)));
                }
            }
        } else if (splitKeywords.length == 2) {
            if (hmap.containsKey(splitKeywords[0]) && hmap.containsKey(splitKeywords[1])) {
                e = hmap.get(splitKeywords[0]);
                e = hmap.get(splitKeywords[1]);
                //System.out.println(e);
                for (int x = 0; x < e.size(); x++) {
                    windowClass.outputToDisplay("", productList.get(e.get(x)));
                }
            }
        } else if (splitKeywords.length == 3) {
            if (hmap.containsKey(splitKeywords[0]) && hmap.containsKey(splitKeywords[1]) && hmap.containsKey(splitKeywords[2])) {
                e = hmap.get(splitKeywords[0]);
                e = hmap.get(splitKeywords[1]);
                e = hmap.get(splitKeywords[2]);
                //System.out.println(e);
                for (int x = 0; x < e.size(); x++) {
                    windowClass.outputToDisplay("", productList.get(e.get(x)));
                }
            }
        }

    }

    /**
     *
     * @param toConvert little function that converts arraylist integers to just
     * an integer
     * @return this returns the integer after conversion from arraylist
     */
    public static int[] ArrayIntegerToInteger(List<Integer> toConvert) {
        int[] returnInt = new int[toConvert.size()];
        Iterator<Integer> iterator = toConvert.iterator();
        for (int i = 0; i < returnInt.length; i++) {
            returnInt[i] = iterator.next().intValue();
        }
        return returnInt;
    }

    /**
     *
     * @param searchName value passed in to search for
     * @param hmap hashmap value to search in
     * @param e integer arraylist that accompanies hashmap
     * @param productList sourcelist where all the products are stored
     * @return this returns the index of where the product item is stored
     */
    public static int[] returnNameIndex(String searchName, HashMap<String, ArrayList<Integer>> hmap, ArrayList<Integer> e, ArrayList<productClass> productList) {

        String[] splitKeywords = searchName.split("\\s+");

        if (splitKeywords.length == 1) {
            if (hmap.containsKey(splitKeywords[0])) {
                e = hmap.get(splitKeywords[0]);
                //System.out.println(e);
                return ArrayIntegerToInteger(e);
                // System.out.println(productList.get(e.get(0)));
            }
        } else if (splitKeywords.length == 2) {
            if (hmap.containsKey(splitKeywords[0]) && hmap.containsKey(splitKeywords[1])) {
                e = hmap.get(splitKeywords[0]);
                e = hmap.get(splitKeywords[1]);
                // System.out.println(e);
                return ArrayIntegerToInteger(e);
                //System.out.println(productList.get(e.get(0)));
            }
        } else if (splitKeywords.length == 3) {
            if (hmap.containsKey(splitKeywords[0]) && hmap.containsKey(splitKeywords[1]) && hmap.containsKey(splitKeywords[2])) {
                e = hmap.get(splitKeywords[0]);
                e = hmap.get(splitKeywords[1]);
                e = hmap.get(splitKeywords[2]);
                //System.out.println(e);
                return ArrayIntegerToInteger(e);
                //System.out.println(productList.get(e.get(0)));
            }

        }
        return ArrayIntegerToInteger(e);
    }

    /**
     *
     * @return returns hash value needed to make equal function work
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.itemPrice);
        hash = 41 * hash + Objects.hashCode(this.itemName);
        hash = 41 * hash + Objects.hashCode(this.itemYear);
        hash = 41 * hash + Objects.hashCode(this.itemID);
        return hash;
    }

    /**
     *
     * @param obj checks if object is equal to the actual value instead of
     * string value
     * @return returns true if it indeed is equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final productClass other = (productClass) obj;
        if (!Objects.equals(this.itemPrice, other.itemPrice)) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemYear, other.itemYear)) {
            return false;
        }
        if (!Objects.equals(this.itemID, other.itemID)) {
            return false;
        }
        return true;
    }

}
