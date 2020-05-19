package packer;

/**
 *
 * @author I.M.Bad
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    /**
     * Product constructor
     * @param name
     * @param weight
     * @param hazardous
     * @param fragile 
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
     * Gets the products weight
     * @return product weight in kg
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Gets the name of the product
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Determines whether the product is hazardous or not
     * @return true or false
     */
    public boolean isHazardous() {
        return hazardous;
    }

    /**
     * Determines whether the product is fragile or not
     * @return true or false
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * Prints the product name to a string
     * @return product name string
     */
    public String toString() {
        return this.getName();
    }
    
    /**
     * Compares whether two different products are the same
     * @param o: the other product
     * @return true or false
     */
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }
    
}
