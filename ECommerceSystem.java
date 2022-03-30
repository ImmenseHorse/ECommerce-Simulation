// Duc Manh Nguyen
// 501140042

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem {
  private ArrayList<Product> products = new ArrayList<Product>();
  private ArrayList<Customer> customers = new ArrayList<Customer>();

  private ArrayList<ProductOrder> orders = new ArrayList<ProductOrder>();
  private ArrayList<ProductOrder> shippedOrders = new ArrayList<ProductOrder>();

  // These variables are used to generate order numbers, customer id's, product
  // id's
  private int orderNumber = 500;
  private int customerId = 900;
  private int productId = 700;

  // General variable used to store an error message when something is invalid
  // (e.g. customer id does not exist)
  String errMsg = null;

  // Random number generator
  Random random = new Random();

  public ECommerceSystem() {
    // NOTE: do not modify or add to these objects!! - the TAs will use for testing
    // If you do the class Shoes bonus, you may add shoe products

    // Create some products. Notice how generateProductId() method is used
    products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney", 2021));
    products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast", 2010));
    products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive", 1975));
    products.add(
        new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney", 2022));
    products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));

    // Create some customers. Notice how generateCustomerId() method is used
    customers.add(new Customer(generateCustomerId(), "Inigo Montoya", "1 SwordMaker Lane, Florin"));
    customers.add(new Customer(generateCustomerId(), "Prince Humperdinck", "The Castle, Florin"));
    customers.add(new Customer(generateCustomerId(), "Andy Dufresne", "Shawshank Prison, Maine"));
    customers.add(new Customer(generateCustomerId(), "Ferris Bueller", "4160 Country Club Drive, Long Beach"));

    // Create some shoes.
    products.add(new Shoes("Shoes", generateProductId(), 132.5, 20, 7, 8, 0, 100, 4, 17, 13, 666, 1001));
    products.add(new Shoes("Shoes", generateProductId(), 1999.99, 1, 23, 99, 13, 4, 0, 11, 23, 12, 136));
  }

  private String generateOrderNumber() {
    return "" + orderNumber++;
  }

  private String generateCustomerId() {
    return "" + customerId++;
  }

  private String generateProductId() {
    return "" + productId++;
  }

  public String getErrorMessage() {
    return errMsg;
  }

  public void printAllProducts() {
    for (Product p : products)
      p.print();
  }

  // Print all products that are books. See getCategory() method in class Product
  public void printAllBooks() {
    for (Product p : products) {
      if (p.getCategory().equals(Product.Category.BOOKS)) {
        ((Book) p).print();
      }
    }
  }

  // Print all current orders
  public void printAllOrders() {
    for (ProductOrder order : orders) {
      order.print();
    }
  }

  // Print all shipped orders
  public void printAllShippedOrders() {
    for (ProductOrder order : shippedOrders) {
      order.print();
    }
  }

  // Print all customers
  public void printCustomers() {
    for (Customer cus : customers) {
      cus.print();
    }
  }

  /*
   * Given a customer id, print all the current orders and shipped orders for them
   * (if any)
   */
  public boolean printOrderHistory(String customerId) {
    // Make sure customer exists - check using customerId
    // If customer does not exist, set errMsg String and return false
    // see video for an appropriate error message string
    // ... code here
    ArrayList<String> custID = new ArrayList<String>();

    for (Customer cust : customers) {
      custID.add(cust.getId());
    }

    if (!(custID.contains(customerId))) {
      errMsg = "Order " + customerId + " Not Found";
      return false;
    }

    // Print current orders of this customer
    System.out.println("Current Orders of Customer " + customerId);
    // enter code here
    for (ProductOrder order : orders) {
      if (order.getCustomer().getId().equals(customerId)) {
        order.print();
      }
    }

    // Print shipped orders of this customer
    System.out.println("\nShipped Orders of Customer " + customerId);
    // enter code here
    for (ProductOrder order : shippedOrders) {
      if (order.getCustomer().getId().equals(customerId)) {
        order.print();
      }
    }

    return true;
  }

  public String orderProduct(String productId, String customerId, String productOptions) {
    // First check to see if customer object with customerId exists in array list
    // customers
    // if it does not, set errMsg and return null (see video for appropriate error
    // message string)
    // else get the Customer object

    boolean valid = false;
    Customer custo = null;
    for (Customer cust : customers) {
      if (cust.getId().equals(customerId)) {
        valid = true;
        custo = cust;
        break;
      }
    }
    if (!valid) {
      errMsg = "Customer " + customerId + " Not Found";
      return null;
    }

    // Check to see if product object with productId exists in array list of
    // products
    // if it does not, set errMsg and return null (see video for appropriate error
    // message string)
    // else get the Product object

    valid = false;
    Product produ = null;
    for (Product prod : products) {
      if (prod.getId().equals(productId)) {
        valid = true;
        produ = prod;
        break;
      }
    }
    if (!valid) {
      errMsg = "Product " + productId + " Not Found";
      return null;
    }

    // Check if the options are valid for this product (e.g. Paperback or Hardcover
    // or EBook for Book product)
    // See class Product and class Book for the method vaidOptions()
    // If options are not valid, set errMsg string and return null;

    if (produ.getCategory().equals(Product.Category.BOOKS)) {
      if (!((Book) produ).validOptions(productOptions)) {
        errMsg = "Product Book ProductId " + productId + " Invalid Options: " + productOptions;
        return null;
      }
    }

    else if (produ.getCategory().equals(Product.Category.CLOTHING) && Shoes.class.isInstance(produ)) {
      if (!((Shoes) produ).validOptions(productOptions)) {
        errMsg = "Product Shoes ProductId " + productId + " Invalid Options: " + productOptions;
        return null;
      }
    }

    else if (!produ.validOptions(productOptions)) {
      errMsg = "ProductId " + productId + " Invalid Options: " + productOptions;
      return null;
    }

    // Check if the product has stock available (i.e. not 0)
    // See class Product and class Book for the method getStockCount()
    // If no stock available, set errMsg string and return null

    if (produ.getCategory().equals(Product.Category.BOOKS)) {
      if (((Book) produ).getStockCount(productOptions) == 0) {
        errMsg = "Product Book ProductId " + productId + " Not available";
        return null;
      }
    }

    if (produ.getCategory().equals(Product.Category.CLOTHING) && Shoes.class.isInstance(produ)) {
      if (((Shoes) produ).getStockCount(productOptions) == 0) {
        errMsg = "Product Shoes ProductId " + productId + " Not available";
        return null;
      }
    }

    if (produ.getStockCount(productOptions) == 0) {
      errMsg = "ProductId " + productId + " Not available";
      return null;
    }

    // Create a ProductOrder, (make use of generateOrderNumber() method above)
    // reduce stock count of product by 1 (see class Product and class Book)
    // Add to orders list and return order number string

    String orNum = generateOrderNumber();
    ProductOrder order1 = new ProductOrder(orNum, produ, custo, productOptions);
    if (produ.getCategory().equals(Product.Category.BOOKS)) {
      ((Book) produ).reduceStockCount(productOptions);
    } else {
      produ.reduceStockCount(productOptions);
    }

    orders.add(order1);
    System.out.print("Order #");
    return orNum;

  }

  /*
   * Create a new Customer object and add it to the list of customers
   */

  public boolean createCustomer(String name, String address) {
    // Check name parameter to make sure it is not null or ""
    // If it is not a valid name, set errMsg (see video) and return false
    // Repeat this check for address parameter

    if (name == null || name.isEmpty()) {
      errMsg = "Invalid Customer Name";
      return false;
    }

    if (address == null || address.isEmpty()) {
      errMsg = "Invalid Customer Address";
      return false;
    }

    // Create a Customer object and add to array list
    customers.add(new Customer(generateCustomerId(), name, address));

    return true;
  }

  public ProductOrder shipOrder(String orderNumber) {
    // Check if order number exists first. If it doesn't, set errMsg to a message
    // (see video)
    // and return null
    // Retrieve the order from the orders array list, remove it, then add it to the
    // shippedOrders array list
    // return a reference to the order

    for (ProductOrder order : orders) {
      if (order.getOrderNumber().equals(orderNumber)) {
        orders.remove(order);
        shippedOrders.add(order);
        order.print();
        return order;
      }
    }

    errMsg = "Order " + orderNumber + " Not Found";
    return null;
  }

  /*
   * Cancel a specific order based on order number
   */
  public boolean cancelOrder(String orderNumber) {
    // Check if order number exists first. If it doesn't, set errMsg to a message
    // (see video)
    // and return false

    for (ProductOrder order : orders) {
      if (order.getOrderNumber().equals(orderNumber)) {
        orders.remove(order);
        return true;
      }
    }

    errMsg = "Order " + orderNumber + " Not Found";
    return false;
  }

  // Sort products by increasing price
  public void sortByPrice() {
    Collections.sort(products);
  }

  // Sort products alphabetically by name
  public void sortByName() {
    Collections.sort(products, new Product());
  }

  // Sort customers alphabetically by name
  public void sortCustomersByName() {
    Collections.sort(customers);
  }

  // Check if the entered author is valid
  public boolean isAuthorValid(String author) {
    ArrayList<String> authors = new ArrayList<String>();

    for (Product p : products) {
      if (p.getCategory().equals(Product.Category.BOOKS)) {
        authors.add(((Book) p).getAuthor());
      }
    }

    if (!authors.contains(author)) {
      errMsg = "Author " + author + " Not Found";
      return false;
    }

    return true;
  }

  // Print all books by the given author in an increasing order of year published.
  public void booksByAuthor(String author) {

    ArrayList<Book> theirBooks = new ArrayList<Book>();

    for (Product p : products) {
      if (p.getCategory().equals(Product.Category.BOOKS) && ((Book) p).getAuthor().equals(author)) {
        theirBooks.add((Book) p);
      }
    }
    Collections.sort(theirBooks, new SortBooksByAuthor());

    for (Book b : theirBooks) {
      b.print();
    }

  }

}
