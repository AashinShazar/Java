/**
 * PartyTrayOrder - Part 1
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 11/05/2017
 *
 * This class contains functionality to represent an order of partytray related products; More specifically orders with
 * cheeses, fruits and services.
 */
public class PartyTrayOrder extends GenericOrder {
    public PartyTrayOrder() {
    }

    /**
     * This method adds a cheese to the order
     * @param product The cheese
     */
    public void addProduct(Cheese product) {
        super.addProduct(product);
    }

    /**
     * This method adds a fruit to the order
     * @param product The fruit
     */
    public void addProduct(Fruit product) {
        super.addProduct(product);
    }

    /**
     * This method adds a service to the order
     * @param product The service
     */
    public void addProduct(Service product) {
        super.addProduct(product);
    }
}
