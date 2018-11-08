/**
 * OrderProcessor - Part 2
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 11/05/2017
 *
 * This class contains functionality to accept order, process them by sorting all products contained in the orders in their
 * respectable subcontainers and dispatching the products contained in these subcontainers.
 */

import java.lang.reflect.Field;
import java.util.ArrayList;

public class OrderProcessor {
    private ArrayList<GenericOrder> orders;

    private ArrayList<ProductTuple> computerPartOrders;
    private ArrayList<ProductTuple> peripheralOrders;
    private ArrayList<ProductTuple> cheeseOrders;
    private ArrayList<ProductTuple> fruitOrders;
    private ArrayList<ProductTuple> serviceOrders;


    /**
     * The constructor of the class. It initializes the class.
     */
    public OrderProcessor() {
        orders = new ArrayList<>();
        computerPartOrders = new ArrayList<>();
        peripheralOrders = new ArrayList<>();
        cheeseOrders = new ArrayList<>();
        fruitOrders = new ArrayList<>();
        serviceOrders = new ArrayList<>();
    }

    /**
     * This method accepts an order and stores it in the internal container.
     * @param order The order to accept.
     */
    public void accept(GenericOrder order) {
        orders.add(order);
    }

    /**
     * This method sorts all accepted orders in the internal collections.
     */
    public void process() {
        for (GenericOrder o: orders) { // For every accepted order
            for (Object p: o.getGenericProducts()) { // For every product in the order

                // Sort each product in its respectable subcontainer.
                // Each product is stored in its subcontainer as a (Product, orderID) pair using the ProductTuple class.
                if (p instanceof ComputerPart)
                    computerPartOrders.add(new ProductTuple((Product) p, o.getId()));
                if (p instanceof Peripheral)
                    peripheralOrders.add(new ProductTuple((Product) p, o.getId()));
                if (p instanceof Cheese)
                    cheeseOrders.add(new ProductTuple((Product) p, o.getId()));
                if (p instanceof Fruit)
                    fruitOrders.add(new ProductTuple((Product) p, o.getId()));
                if (p instanceof Service)
                    serviceOrders.add(new ProductTuple((Product) p, o.getId()));
            }
        }
    }

    /**
     * This method simulates the dispatch of the computer parts collection.
     */
    public void dispatchComputerParts() {
        printProducts(computerPartOrders);
    }

    /**
     * This method simulates the dispatch of the peripherals collection.
     */
    public void dispatchPeripherals() {
        printProducts(peripheralOrders);
    }

    /**
     * This method simulates the dispatch of the cheeses collection.
     */
    public void dispatchCheeses() {
        printProducts(cheeseOrders);
    }

    /**
     * This method simulates the dispatch of the fruits collection.
     */
    public void dispatchFruits() {
        printProducts(fruitOrders);
    }

    /**
     * This method simulates the dispatch of the services collection.
     */
    public void dispatchServices() {
        printProducts(serviceOrders);
    }

    /**
     * This method prints the type and fields of each product to the standard output.
     * @param products The list of products to print.
     */
    private void printProducts(ArrayList<ProductTuple> products) {
        for (ProductTuple p: products)
            printProduct(p.getOrderId(), p.getProduct());
    }

    /**
     * This method prints the info of a product to the standard output.
     * @param orderId The order ID of the order the product is contained in.
     * @param product The product
     */
    private void printProduct(int orderId, Product product) {
        String type = product.getClass().getSimpleName(); // Get the class name of the product.
        String fields = type + " - ";

        Field[] prodFields = product.getClass().getDeclaredFields(); // Get the declared fields of the product

        for (Field f: prodFields) { // For every field
            try {
                fields += f.getName() + "=" + f.get(product).toString() + ", "; // Print the name and value of the field
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        fields += "price=$" + product.price() +  ", order number=" + orderId; // Append the price and order number

        System.out.println(fields); // Print the product
    }

    private class ProductTuple<A extends Product, B extends Integer> {
        /**
         * This class contains functionality to hold a product and the order number of the product.
         */
        private final A product;
        private final B id;

        public ProductTuple(A prod, B id) {
            this.product = prod;
            this.id = id;
        }

        /**
         * Returns the order ID of the product.
         * @return The order ID of the product.
         */
        public int getOrderId() {
            return id;
        }

        /**
         * Returns the product
         * @return The product
         */
        public A getProduct() {
            return product;
        }
    }
}

