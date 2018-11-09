/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentthree;

import java.util.Objects;

/**
 *
 * @author Aashin Shazar
 */
public class bookClass extends productClass {

    private String bookAuthor;
    private String bookPublisher;
    private String bookType;

    /**
     * No argument constructor
     */
    public bookClass() {

    }

    /**
     *
     * @param bookID a string initializing book ID
     * @param bookName a string initializing book name
     * @param bookYear a string initializing book year
     * @throws java.lang.Exception
     */
    public bookClass(String bookName, String bookYear, String bookID) throws Exception {
        super(bookName, bookYear, bookID);
    }

    /**
     *
     * @param bookAuthor a string initializing book author
     * @param bookPublisher a string initializing book publisher
     * @param bookType a string initializing book type
     * @param itemPrice calls super to get item price from the extended class
     * @param itemName calls super to get item name from the extended class
     * @param itemYear calls super to get item year from the extended class
     * @param itemID calls super to get item ID from the extended class
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public bookClass(String bookAuthor, String bookPublisher, String bookType, String itemPrice, String itemName, String itemYear, String itemID) throws Exception {
        super(itemPrice, itemName, itemYear, itemID);
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookType = bookType;
    }

    /**
     *
     * @param bookAuthor a string initializing book author
     * @param bookPublisher a string initializing book publisher
     * @param bookType a string initializing book type
     * @param itemName calls super to get item name from the extended class
     * @param itemYear calls super to get item year from the extended class
     * @param itemID calls super to get item ID from the extended class
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public bookClass(String bookAuthor, String bookPublisher, String bookType, String itemName, String itemYear, String itemID) throws Exception {
        super(itemName, itemYear, itemID);
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookType = bookType;
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getProductType() {
        return bookType;
    }

    /**
     *
     * @param bookType
     */
    public void setType(String bookType) {
        this.bookType = bookType;
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
     * @return returns hash value needed to make equal function work
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(getID());
        hash = 59 * hash + Objects.hashCode(getName());
        hash = 59 * hash + Objects.hashCode(getPrice());
        hash = 59 * hash + Objects.hashCode(getYear());
        hash = 59 * hash + Objects.hashCode(this.bookAuthor);
        hash = 59 * hash + Objects.hashCode(this.bookPublisher);
        hash = 59 * hash + Objects.hashCode(this.bookType);
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
        final bookClass other = (bookClass) obj;
        if (!Objects.equals(getID(), other.getID())) {
            return false;
        }
        if (!Objects.equals(getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(getPrice(), other.getPrice())) {
            return false;
        }
        if (!Objects.equals(getYear(), other.getYear())) {
            return false;
        }
        if (!Objects.equals(this.bookAuthor, other.bookAuthor)) {
            return false;
        }
        if (!Objects.equals(this.bookType, other.bookType)) {
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
        return ("type = " + "\"" + this.bookType + "\"" + "\n"
                + "productID = " + "\"" + getID() + "\"" + "\n"
                + "name = " + "\"" + getName() + "\"" + "\n"
                + "price = " + "\"" + getPrice() + "\"" + "\n"
                + "year = " + "\"" + getYear() + "\"" + "\n"
                + "authors = " + "\"" + this.bookAuthor + "\"" + "\n"
                + "publisher = " + "\"" + this.bookPublisher + "\"" + "\n");
    }

}
