public class TestBuilderPattern {
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setCoolingSystem("Liquid Cooling")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setPowerSupply("500W")
                .build();

        // Print the configurations
        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
