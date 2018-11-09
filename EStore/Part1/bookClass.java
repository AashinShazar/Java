/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainassignmentone;

import java.util.ArrayList;
import java.util.Objects;
import static mainassignmentone.EStoreSearchClass.matchContain;
import static mainassignmentone.EStoreSearchClass.matchKeywords;

/**
 *
 * @author Aashin Shazar
 */
public class bookClass {

    private String bookID;
    private String bookName;
    private String bookPrice;
    private String bookYear;
    private String bookAuthor;
    private String bookPublisher;

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getName() {
        return bookName;
    }

    /**
     *
     * @param bookName uses this string to set the value of the private string
     */
    public void setName(String bookName) {
        this.bookName = bookName;
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getPrice() {
        return bookPrice;
    }

    /**
     *
     * @param bookPrice uses this string to set the value of the private string
     */
    public void setPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getYear() {
        return bookYear;
    }

    /**
     *
     * @param bookYear uses this string to set the value of the private string
     */
    public void setYear(String bookYear) {
        this.bookYear = bookYear;
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getAuthor() {
        return bookAuthor;
    }

    /**
     *
     * @param bookAuthor uses this string to set the value of the private string
     */
    public void setAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getPublisher() {
        return bookPublisher;
    }

    /**
     *
     * @param bookPublisher uses this string to set the value of the private
     * string
     */
    public void setPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getID() {
        return bookID;
    }

    /**
     *
     * @param bookID uses this string to set the value of the private string
     */
    public void setID(String bookID) {
        this.bookID = bookID;
    }

    /**
     *
     * @param prevYear takes in an input specified by the user to establish the
     * upper limit on the year search
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param keyWords takes in an input specified by the user to find matching
     * keyWords
     * @param sourceList a specified arrayList to search for the provided input
     * in
     */
    public static void previousBookYears(String prevYear, String productID, String keyWords, ArrayList<bookClass> sourceList) {
        //System.out.println("Years up to this year is included.");
        int pastYears = Integer.parseInt(prevYear.substring(1, 5));

        for (int x = 0; x < sourceList.size(); x++) {
            for (int y = 1000; y < pastYears + 1; y++) {

                if (matchContain(sourceList.get(x).getID(), productID)
                        && matchKeywords(sourceList.get(x).getName(), keyWords)
                        && matchContain(sourceList.get(x).getYear(), String.valueOf(y))) {
                    System.out.println("Item found via up to years: " + "\n" + sourceList.get(x));
                    break;
                }
            }
            System.out.println("Item was not found in years before!");
        }
    }

    /**
     *
     * @param rangeYear takes in an input specified by the user to establish the
     * range of years to search in
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param keyWords takes in an input specified by the user to find matching
     * keyWords
     * @param sourceList a specified arrayList to search for the provided input
     * in
     */
    public static void rangeBookYears(String rangeYear, String productID, String keyWords, ArrayList<bookClass> sourceList) {
        //System.out.println("This is a range of years.");
        int rangeYears1 = Integer.parseInt(rangeYear.substring(0, 4));
        int rangeYears2 = Integer.parseInt(rangeYear.substring(5, 9));

        for (int x = 0; x < sourceList.size(); x++) {

            for (int y = rangeYears1; y < rangeYears2 + 1; y++) {

                if (matchContain(sourceList.get(x).getID(), productID)
                        && matchKeywords(sourceList.get(x).getName(), keyWords)
                        && matchContain(sourceList.get(x).getYear(), String.valueOf(y))) {
                    System.out.println("Item found via range years: " + "\n" + sourceList.get(x));
                    break;
                }
            }
            System.out.println("Item was not found in range of years!");
        }
    }

    /**
     *
     * @param futureYear takes in an input specified by the user to establish
     * the lower limit of ranges to search from
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param keyWords takes in an input specified by the user to find matching
     * keyWords
     * @param sourceList a specified arrayList to search for the provided input
     * in
     */
    public static void futureBookYears(String futureYear, String productID, String keyWords, ArrayList<bookClass> sourceList) {
        //System.out.println("Years after this year is included.");
        int futureYears = Integer.parseInt(futureYear.substring(0, 4));

        for (int x = 0; x < sourceList.size(); x++) {
            for (int y = futureYears; y < 9999; y++) {

                if (matchContain(sourceList.get(x).getID(), productID)
                        && matchKeywords(sourceList.get(x).getName(), keyWords)
                        && matchContain(sourceList.get(x).getYear(), String.valueOf(y))) {
                    System.out.println("Item found in years after " + "\n" + sourceList.get(x));
                    break;
                }
            }
            System.out.println("Item was not found in years after!");
        }
    }

    /**
     *
     * @param commonYear takes in an input specified by the user to search for
     * just a year
     * @param productID takes in an input specified by the user to find a
     * matching productID
     * @param keyWords takes in an input specified by the user to find matching
     * keyWords
     * @param sourceList a specified arrayList to search for the provided input
     * in
     */
    public static void commonBookSearch(String commonYear, String productID, String keyWords, ArrayList<bookClass> sourceList) {

        if (commonYear.isEmpty() && productID.isEmpty() && keyWords.isEmpty()) {
            for (int x = 0; x < sourceList.size(); x++) {
                System.out.println("Listing all items: " + "\n" + sourceList.get(x));
            }
        } else {
            for (int x = 0; x < sourceList.size(); x++) {

                if (matchContain(sourceList.get(x).getID(), productID)
                        && matchKeywords(sourceList.get(x).getName(), keyWords)
                        && matchContain(sourceList.get(x).getYear(), commonYear)) {

                    System.out.println("Item found: " + "\n" + sourceList.get(x));
                } else {
                    System.out.println("Item was not found!");
                }
            }
        }
    }

    /**
     *
     * @param productID user specified string of productID
     * @param sourceList user specified arrayList where IDs originate in
     * @param compareList user specified arrayList where IDs are being searched
     * in
     * @return returns true if no duplicate productID exists in the book class arrayList
     */
    public static boolean checkBookID(String productID, ArrayList<bookClass> sourceList, ArrayList<electronicsClass> compareList) {
        if (sourceList.isEmpty() && compareList.isEmpty()) {
            System.out.println("First item added added to the arrayList!");
            return true;
        } else if (sourceList.isEmpty() && !compareList.isEmpty()) {
            for (int x = 0; x < compareList.size(); x++) {

                if (compareList.get(x).getID().equals(productID)) {
                    System.out.println("ERROR: This product ID is already in use within the electronics arrayList. Item not added!");
                    return false;
                } else {
                    System.out.println("Item was checked in the electronics arrayList and then added!");
                    return true;
                }
            }
        } else if (!sourceList.isEmpty() && !compareList.isEmpty()) {

            for (int x = 0; x < sourceList.size(); x++) {

                if (sourceList.get(x).getID().equals(productID)) {
                    System.out.println("ERROR: This product ID is already in use in the book arrayList. Item not added!");
                    return false;
                } else {
                    for (int y = 0; y < compareList.size(); y++) {

                        if (compareList.get(x).getID().equals(productID)) {
                             System.out.println("ERROR: This product ID is already in use in the electronics arrayList. Item not added!");
                            return false;
                        } else {
                            System.out.println("Item was checked in both arrayLists and added!");
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     *
     * @return returns hash value needed to make equal function work
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.bookID);
        hash = 59 * hash + Objects.hashCode(this.bookName);
        hash = 59 * hash + Objects.hashCode(this.bookPrice);
        hash = 59 * hash + Objects.hashCode(this.bookYear);
        hash = 59 * hash + Objects.hashCode(this.bookAuthor);
        hash = 59 * hash + Objects.hashCode(this.bookPublisher);
        return hash;
    }

    /**
     *
     * @param obj checks if object is equal to the actual value instead of string value
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
        final bookClass other = (bookClass) obj;
        if (!Objects.equals(this.bookID, other.bookID)) {
            return false;
        }
        if (!Objects.equals(this.bookName, other.bookName)) {
            return false;
        }
        if (!Objects.equals(this.bookPrice, other.bookPrice)) {
            return false;
        }
        if (!Objects.equals(this.bookYear, other.bookYear)) {
            return false;
        }
        if (!Objects.equals(this.bookAuthor, other.bookAuthor)) {
            return false;
        }
        if (!Objects.equals(this.bookPublisher, other.bookPublisher)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return returns the actual readable value of the bookClass values via an
     * overrides toString method
     */
    @Override
    public String toString() {
        return ("Product ID: " + this.bookID + "\n"
                + "Product Name: " + this.bookName + "\n"
                + "Product Price: " + this.bookPrice + "\n"
                + "Product Year: " + this.bookYear + "\n"
                + "Product Author: " + this.bookAuthor + "\n"
                + "Product Publisher: " + this.bookPublisher);
    }

}
