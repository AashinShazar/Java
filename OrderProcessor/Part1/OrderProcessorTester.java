/**
 * OrderProcessorTester - Part 1
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 11/05/2017
 *
 * This class contains a main method which tests the ComputerOrder and PartyTrayOrders classes in combination with the OrderProcessor class.
 * The main function creates an OrderProcessor containing 10 ComputerOrder and 10 PartyTrayOrders orders.
 * It then processes and dispatches the orders.
 */
public class OrderProcessorTester {
    public static void main(String[] args) {
        DataGenerator gen = new DataGenerator();

        OrderProcessor processor = new OrderProcessor();

        int nOrdersOfEachType = 3;
        for (int i = 0; i < nOrdersOfEachType; i++) {
            processor.accept(gen.randomComputerOrder(1));
            processor.accept(gen.randomPartyTrayOrder(1));
        }

        processor.process();

        processor.dispatchCheeses();
        processor.dispatchComputerParts();
        processor.dispatchFruits();
        processor.dispatchPeripherals();
        processor.dispatchServices();
    }
}
