// Duc Manh Nguyen
// 501140042

public class Shoes extends Product {
    int black6, black7, black8, black9, black10;
    int brown6, brown7, brown8, brown9, brown10;

    public Shoes(String name, String id, double price, int black6, int black7, int black8, int black9, int black10,
            int brown6, int brown7, int brown8, int brown9, int brown10) {
        // Make use of the constructor in the super class Product. Initialize additional
        // Shoes instance variables.
        // Set category to CLOTHING

        super(name, id, price, 100000, Product.Category.CLOTHING);

        this.black6 = black6;
        this.black7 = black7;
        this.black8 = black8;
        this.black9 = black9;
        this.black10 = black10;

        this.brown6 = brown6;
        this.brown7 = brown7;
        this.brown8 = brown8;
        this.brown9 = brown9;
        this.brown10 = brown10;

    }

    // Check if a valid format
    public boolean validOptions(String productOptions) {
        return productOptions.equalsIgnoreCase("6 Black")
                || productOptions.equalsIgnoreCase("7 Black")
                || productOptions.equalsIgnoreCase("8 Black")
                || productOptions.equalsIgnoreCase("9 Black")
                || productOptions.equalsIgnoreCase("10 Black")
                || productOptions.equalsIgnoreCase("6 Brown")
                || productOptions.equalsIgnoreCase("7 Brown")
                || productOptions.equalsIgnoreCase("8 Brown")
                || productOptions.equalsIgnoreCase("9 Brown")
                || productOptions.equalsIgnoreCase("10 Brown");
    }

    // Override getStockCount() in super class.
    public int getStockCount(String productOptions) {
        if (productOptions.equalsIgnoreCase("6 Black"))
            return black6;
        if (productOptions.equalsIgnoreCase("7 Black"))
            return black7;
        if (productOptions.equalsIgnoreCase("8 Black"))
            return black8;
        if (productOptions.equalsIgnoreCase("9 Black"))
            return black9;
        if (productOptions.equalsIgnoreCase("10 Black"))
            return black10;
        if (productOptions.equalsIgnoreCase("6 Brown"))
            return brown6;
        if (productOptions.equalsIgnoreCase("7 Brown"))
            return brown7;
        if (productOptions.equalsIgnoreCase("8 Brown"))
            return brown8;
        if (productOptions.equalsIgnoreCase("9 Brown"))
            return brown9;
        return brown10;
    }

    public void setStockCount(int stockCount, String productOptions) {
        if (productOptions.equalsIgnoreCase("6 Black"))
            black6 = stockCount;
        else if (productOptions.equalsIgnoreCase("7 Black"))
            black7 = stockCount;
        else if (productOptions.equalsIgnoreCase("8 Black"))
            black8 = stockCount;
        else if (productOptions.equalsIgnoreCase("9 Black"))
            black9 = stockCount;
        else if (productOptions.equalsIgnoreCase("10 Black"))
            black10 = stockCount;
        else if (productOptions.equalsIgnoreCase("6 Brown"))
            brown6 = stockCount;
        else if (productOptions.equalsIgnoreCase("7 Brown"))
            brown7 = stockCount;
        else if (productOptions.equalsIgnoreCase("8 Brown"))
            brown8 = stockCount;
        else if (productOptions.equalsIgnoreCase("9 Brown"))
            brown9 = stockCount;
        else
            brown10 = stockCount;
    }

    /*
     * When a pair of Shoes is ordered, reduce the stock count for the specific
     * stock type
     */
    public void reduceStockCount(String productOptions) {
        if (productOptions.equalsIgnoreCase("6 Black"))
            black6--;
        else if (productOptions.equalsIgnoreCase("7 Black"))
            black7--;
        else if (productOptions.equalsIgnoreCase("8 Black"))
            black8--;
        else if (productOptions.equalsIgnoreCase("9 Black"))
            black9--;
        else if (productOptions.equalsIgnoreCase("10 Black"))
            black10--;
        else if (productOptions.equalsIgnoreCase("6 Brown"))
            brown6--;
        else if (productOptions.equalsIgnoreCase("7 Brown"))
            brown7--;
        else if (productOptions.equalsIgnoreCase("8 Brown"))
            brown8--;
        else if (productOptions.equalsIgnoreCase("9 Brown"))
            brown9--;
        else
            brown10--;
    }

    /*
     * Print product information in super class and append Shoes specific
     * information
     */
    public void print() {
        // Make use of the super class print() method
        super.print();
    }

}
