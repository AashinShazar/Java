/**
 * DataGenerator - Part 1
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 11/05/2017
 *
 * This class contains functionality to generate several random objects and values. These can be used to test the
 * objects and methods regarding this assignment.
 */
public class DataGenerator {
    private int id;
    private static final String[] MFS = {"ASUS", "Acer", "MSI", "HP", "Dell", "COMPAQ", "LENOVO"};
    private static final String[] COURIERS = {"DHL", "FedEx"};
    private static final String[] DRIVE_TYPES = {"HDD", "SSD"};
    private static final float MAX_NUMERIC_RANGE= 500;

    /**
     * This method provides a unique integer ID on every call; Each call is the ID following the previous ID.
     * @return A unique integer ID
     */
    public int nextId() {
        id++;
        return id;
    }

    /**
     * This method provides a random price in the bounds 0 to 500.
     * @return A random float in the bounds 0 to 500.
     */
    public float getPrice() {
        return (float) (Math.random() * (MAX_NUMERIC_RANGE));
    }

    /**
     * This method provides a random integer in the bounds 1 to 500.
     * @return A random integer in the bounds 1 to 500.
     */
    public int getInt() {
        return (int)(Math.random() * (MAX_NUMERIC_RANGE + 1));
    }

    /**
     * This method provides a random manufacturer name
     * @return A random manufacturer name
     */
    public String getRandomMF() {
        return MFS[(int)(Math.random() * (MFS.length - 1))];
    }

    /**
     * This method provides a random courier name
     * @return A random courier name
     */
    public String getRandomCourier() {
        return COURIERS[(int)(Math.random() * (COURIERS.length - 1))];
    }

    /**
     * This method provides a random drive type
     * @return A random drive type
     */
    public String getRandomDriveType() {
        return DRIVE_TYPES[(int)(Math.random() * (DRIVE_TYPES.length - 1))];
    }

    /**
     * This method provides a random Apple object
     * @return A random Apple object
     */
    public Apple randomApple() {
        return new Apple(getPrice());
    }

    /**
     * This method provides a random AssemblyService object
     * @return A random AssemblyService object
     */
    public AssemblyService randomAssemblyService() {
        return new AssemblyService(getRandomMF(), getPrice());
    }

    /**
     * This method provides a random Cheddar object
     * @return A random Cheddar object
     */
    public Cheddar randomCheddar() {
        return new Cheddar(getPrice());
    }

    /**
     * This method provides a random Motherboard object
     * @return A random Motherboard object
     */
    public Motherboard randomMotherboard() {
        return new Motherboard(getRandomMF(), getPrice());
    }

    /**
     * This method provides a random Drive object
     * @return A random Drive object
     */
    public Drive randomDrive() {
        return new Drive(getRandomDriveType(), getInt(), getPrice());
    }

    /**
     * This method provides a random Peripheral object
     * @return A random Peripheral object
     */
    public Peripheral randomPeripheral() {
        return new Peripheral(getPrice());
    }

    /**
     * This method provides a random DeliveryService object
     * @return A random DeliveryService object
     */
    public DeliveryService randomDeliveryService() {
        return new DeliveryService(getRandomCourier(), getPrice());
    }

    /**
     * This method provides a random Mozzarella object
     * @return A random Mozzarella object
     */
    public Mozzarella randomMozzarella() {
        return new Mozzarella(getPrice());
    }

    /**
     * This method provides a random computer order, containing parameter 'size' times objects allowed in the order.
     * @return A random computer order object
     */
    public ComputerOrder randomComputerOrder(int size) {
        ComputerOrder order = new ComputerOrder();

        for (int i = 0; i < size; i++) {
            order.addProduct(randomAssemblyService());
            order.addProduct(randomDeliveryService());
            order.addProduct(randomMotherboard());
            order.addProduct(randomDrive());
            order.addProduct(randomPeripheral());
        }

        return order;
    }

    /**
     * This method provides a random partytray order, containing parameter 'size' times objects allowed in the order.
     * @return A random partytray order object
     */
    public PartyTrayOrder randomPartyTrayOrder(int size) {
        PartyTrayOrder order = new PartyTrayOrder();

        for (int i = 0; i < size; i++) {
            order.addProduct(randomMozzarella());
            order.addProduct(randomCheddar());
            order.addProduct(randomApple());
            order.addProduct(randomDeliveryService());
        }

        return order;
    }
}
