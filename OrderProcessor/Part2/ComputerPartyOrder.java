/**
 * ComputerPartyOrder - Part 2
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 11/05/2017
 *
 * This class contains functionality to represent an order of computer and party related products; More specifically orders with
 * computer parts, peripherals and cheeses, fruits and services.
 */
public class ComputerPartyOrder extends GenericOrder {
    public ComputerPartyOrder() {
    }

    /**
     * This method adds a computer part to the order
     * @param product The computer part
     */
    public void addProduct(ComputerPart product) {
        super.addProduct(product);
    }

    /**
     * This method adds a peripheral to the order
     * @param product The peripheral
     */
    public void addProduct(Peripheral product) {
        super.addProduct(product);
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
