/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentthree;

import java.util.Objects;

/**
 *
 * @author Aashin
 */
public class electronicsClass extends productClass {

    private String electronicMaker;
    private String electronicType;

    /**
     * No argument constructor
     */
    public electronicsClass() {

    }

    /**
     *
     * @param electronicID a string initializing electronic ID
     * @param electronicName a string initializing electronic name
     * @param electronicYear a string initializing electronic year
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public electronicsClass(String electronicName, String electronicYear, String electronicID) throws Exception {
        super(electronicName, electronicYear, electronicID);
    }

    /**
     *
     * @param electronicMaker a string initializing electronic maker
     * @param electronicType a string initializing electronic type
     */
    public electronicsClass(String electronicMaker, String electronicType) {
        this.electronicMaker = electronicMaker;
        this.electronicType = electronicType;
    }

    /**
     *
     * @param electronicMaker a string initializing electronic maker
     * @param electronicType a string initializing electronic type
     * @param itemPrice calls super to get item price from the extended class
     * @param itemName calls super to get item name from the extended class
     * @param itemYear calls super to get item year from the extended class
     * @param itemID calls super to get item ID from the extended class
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public electronicsClass(String electronicMaker, String electronicType, String itemPrice, String itemName, String itemYear, String itemID) throws Exception {
        super(itemPrice, itemName, itemYear, itemID);
        this.electronicMaker = electronicMaker;
        this.electronicType = electronicType;
    }

    /**
     *
     * @param electronicMaker a string initializing electronic maker
     * @param electronicType a string initializing electronic type
     * @param itemName calls super to get item name from the extended class
     * @param itemYear calls super to get item year from the extended class
     * @param itemID calls super to get item ID from the extended class
     * @throws java.lang.Exception throws an exception if the values are
     * improper
     */
    public electronicsClass(String electronicMaker, String electronicType, String itemName, String itemYear, String itemID) throws Exception {
        super(itemName, itemYear, itemID);
        this.electronicMaker = electronicMaker;
        this.electronicType = electronicType;
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getProductType() {
        return electronicType;
    }

    /**
     *
     * @param electronicType
     */
    public void setType(String electronicType) {
        this.electronicType = electronicType;
    }

    /**
     *
     * @return a string containing the private variable within this class
     */
    public String getMaker() {
        return electronicMaker;
    }

    /**
     *
     * @param electronicMaker uses this string to set the value of the private
     * string
     */
    public void setMaker(String electronicMaker) {
        this.electronicMaker = electronicMaker;
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
        hash = 59 * hash + Objects.hashCode(this.electronicMaker);
        hash = 59 * hash + Objects.hashCode(this.electronicType);
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
        final electronicsClass other = (electronicsClass) obj;
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
        if (!Objects.equals(this.electronicMaker, other.electronicMaker)) {
            return false;
        }
        if (!Objects.equals(this.electronicType, other.electronicType)) {
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
        return ("type = " + "\"" + this.electronicType + "\"" + "\n"
                + "productID = " + "\"" + getID() + "\"" + "\n"
                + "name = " + "\"" + getName() + "\"" + "\n"
                + "price = " + "\"" + getPrice() + "\"" + "\n"
                + "year = " + "\"" + getYear() + "\"" + "\n"
                + "maker = " + "\"" + this.electronicMaker + "\"" + "\n");
    }

}
