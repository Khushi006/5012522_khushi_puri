import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(String productId, String productName, int quantity, double price) {
        Product product = new Product(productId, productName, quantity, price);
        inventory.put(productId, product);
    }

    public void updateProduct(String productId, String productName, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.remove(productId) == null) {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.addProduct("001", "Laptop", 10, 999.99);
        ims.addProduct("002", "Smartphone", 20, 499.99);
        ims.displayInventory();

        ims.updateProduct("001", "Laptop", 8, 999.99);
        ims.displayInventory();

        ims.deleteProduct("002");
        ims.displayInventory();
    }
}
