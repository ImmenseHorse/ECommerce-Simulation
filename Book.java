// Duc Manh Nguyen
// 501140042

import java.util.Comparator;

/* A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.

*/
public class Book extends Product {
  private String author;
  private String title;
  private int year;

  // Stock related information NOTE: inherited stockCount variable is used for
  // EBooks
  private int paperbackStock;
  private int hardcoverStock;

  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title,
      String author, int yearPublished) {
    // Make use of the constructor in the super class Product. Initialize additional
    // Book instance variables.
    // Set category to BOOKS

    super(name, id, price, 100000, Product.Category.BOOKS);
    this.title = title;
    this.author = author;
    this.paperbackStock = paperbackStock;
    this.hardcoverStock = hardcoverStock;
    year = yearPublished;

  }

  // Check if a valid format
  public boolean validOptions(String productOptions) {
    // check productOptions for "Paperback" or "Hardcover" or "EBook"
    // if it is one of these, return true, else return false
    return productOptions.equalsIgnoreCase("Paperback")
        || productOptions.equalsIgnoreCase("Hardcover")
        || productOptions.equalsIgnoreCase("EBook");
  }

  // Override getStockCount() in super class.
  public int getStockCount(String productOptions) {
    // Use the productOptions to check for (and return) the number of stock for
    // "Paperback" etc
    // Use the variables paperbackStock and hardcoverStock at the top.
    // For "EBook", use the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("Paperback")) {
      return paperbackStock;
    } else if (productOptions.equalsIgnoreCase("Hardcover")) {
      return hardcoverStock;
    }

    return super.getStockCount("EBook");
  }

  public void setStockCount(int stockCount, String productOptions) {
    // Use the productOptions to check for (and set) the number of stock for
    // "Paperback" etc
    // Use the variables paperbackStock and hardcoverStock at the top.
    // For "EBook", set the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("Paperback")) {
      paperbackStock = stockCount;
    } else if (productOptions.equalsIgnoreCase("Hardcover")) {
      hardcoverStock = stockCount;
    } else if (productOptions.equalsIgnoreCase("EBook")) {
      super.setStockCount(stockCount, "EBook");
    }

  }

  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  public void reduceStockCount(String productOptions) {
    // Use the productOptions to check for (and reduce) the number of stock for
    // "Paperback" etc
    // Use the variables paperbackStock and hardcoverStock at the top.
    // For "EBook", set the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("Paperback")) {
      paperbackStock--;
    } else if (productOptions.equalsIgnoreCase("Hardcover")) {
      hardcoverStock--;
    } else if (productOptions.equalsIgnoreCase("EBook")) {
      super.reduceStockCount("EBook");
    }
  }

  /*
   * Print product information in super class and append Book specific information
   * title and author
   */
  public void print() {
    // Replace the line below.
    // Make use of the super class print() method and append the title and author
    // info. See the video
    super.print();
    System.out.printf(" Book Title: %s Author: %s Year Published: %s", title, author, year);
  }

  public String getAuthor() {
    return author;
  }

  public int getYear() {
    return year;
  }
}

class SortBooksByAuthor implements Comparator<Book> {
  public int compare(Book b1, Book b2) {
    if (b1.getYear() < b2.getYear()) {
      return -1;
    } else if (b1.getYear() > b2.getYear()) {
      return 1;
    }
    return 0;
  }
}
