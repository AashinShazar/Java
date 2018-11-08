import java.util.ArrayList;

/**
 * GenericOrder - Part 2
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 11/05/2017
 *
 * This class represents a generic container that acts as a collection of an arbitrary number of objects in Products.java.
 * Each instance of this class has a unique ID.
 */
public class GenericOrder<T extends Product> {
    private static int globalId = 0;
    private int id;

    ArrayList<T> genericProducts;

    /**
     * The default constructor of this class. It assigns the unique ID to the instance and initializes the member variables.
     */
    public GenericOrder() {
        assignId();
        genericProducts = new ArrayList<T>();
    }

    /**
     * A constructor of this class. It can be used when a list of products is already present.
     * @param products The list of products
     */
    public GenericOrder(ArrayList<T> products) {
        assignId();
        genericProducts = products;
    }

    /**
     * This method assigns a unique ID following the ID of a previous instance.
     */
    private void assignId() {
        globalId++;
        id = globalId;
    }

    /**
     * This method adds a product to the internal collection.
     * @param product The product to add
     */
    public void addProduct(T product) {
        genericProducts.add(product);
    }

    /**
     * This method removes a product from the internal collection.
     * @param product The product to remove.
     */
    public void removeProduct(T product) {
        genericProducts.remove(product);
    }

    /**
     * This provides the size of the internal collection.
     * @return The size of the internal collection.
     */
    public int getOrderSize() {
        return genericProducts.size();
    }

    /**
     * This method returns the internal collection of products.
     * @return The internal collection of products.
     */
    public ArrayList<T> getGenericProducts() {
        return genericProducts;
    }

    /**
     * This method returns the unique ID of the instance of this class.
     * @return The unique idea of the instance.
     */
    public int getId() {
        return id;
    }
}
