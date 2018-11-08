/**
 * ComputerOrder - Part 1
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 11/05/2017
 *
 * This class contains functionality to represent an order of computer related products; More specifically orders with
 * computer parts, peripherals and services.
 */
public class ComputerOrder extends GenericOrder {
    public ComputerOrder() {

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
     * This method adds a service to the order
     * @param product The service
     */
    public void addProduct(Service product) {
        super.addProduct(product);
    }

}
