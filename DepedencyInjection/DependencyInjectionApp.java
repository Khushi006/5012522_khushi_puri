public class DependencyInjectionApp {
    public static void main(String[] args) {
        // Create a concrete repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        customerService.findCustomerById(1);
    }
}

// Step 2: Define Repository Interface
interface CustomerRepository {
    Customer findCustomerById(int id);
}

// Step 3: Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // Simulate finding a customer in a database
        if (id == 1) {
            return new Customer(id, "Khushi Puri");
        } else {
            return null;
        }
    }
}

// Step 4: Define Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    // Step 5: Implement Dependency Injection (constructor injection)
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void findCustomerById(int id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer found: " + customer);
        } else {
            System.out.println("Customer not found.");
        }
    }
}

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "'}";
    }
}

