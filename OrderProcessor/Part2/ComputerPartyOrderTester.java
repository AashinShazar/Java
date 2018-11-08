/**
 * ComputerPartyOrderTester - Part 2
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 11/05/2017
 *
 * This class contains a main method which tests the ComputerPartyOrder class in combination with the OrderProcessor class.
 * The main function creates an OrderProcessor containing 10 ComputerPartyOrder orders. It then processes and dispatches
 * the orders.
 */
public class ComputerPartyOrderTester {
    public static void main(String[] args) {
        int nSampleSize = 10;
        OrderProcessor processor = new OrderProcessor();
        DataGenerator generator = new DataGenerator();

        for (int i = 0; i < nSampleSize; i++) {
            processor.accept(generator.randomComputerPartyOrder(1));
        }

        processor.process();

        processor.dispatchCheeses();
        processor.dispatchComputerParts();
        processor.dispatchFruits();
        processor.dispatchPeripherals();
        processor.dispatchServices();
    }
}
