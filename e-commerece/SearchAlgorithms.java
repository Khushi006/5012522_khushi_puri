import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class SearchAlgorithms {
    
    // Linear search method
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary search method
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);
            
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Apparel"),
            new Product(3, "Coffee Maker", "Home Appliance")
        };

        // Sorting the array by productName for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));
        
        String targetName = "Shirt";
        
        // Linear Search
        Product result = linearSearch(products, targetName);
        if (result != null) {
            System.out.println("Linear Search - Product found: " + result);
        } else {
            System.out.println("Linear Search - Product not found.");
        }
        
        // Binary Search
        result = binarySearch(products, targetName);
        if (result != null) {
            System.out.println("Binary Search - Product found: " + result);
        } else {
            System.out.println("Binary Search - Product not found.");
        }
    }
}
