package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot;
    private float capacity;

    /**
     * Box constructor
     * @param customer the box belongs to
     * @param depot where the box is
     */
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
        capacity = 20;
    }
    
    /**
     * Adds a product to a box
     * @param product
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    
    /** 
     * Adds a quantity of products to a box
     * @param product
     * @param quantity 
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   
    /**
     * Creates a box label in the form 
     * of a string with all the required information
     * @return 
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        return label.toString();
    }
    
    /**
     * Returns the created label string 
     * @return label string
     */
    public String toString() {
        return getLabel();
    }
    
    /**
     * Returns the weight of the box
     * @return weight
     */
    public double getWeight() {
        return contents.getTotalWeight();
    }
    
    /**
     * Determines whether a product can fit in the box
     * @param p: the product
     * @return true or false
     */
    public boolean canFit(Product p) {
        return p.getWeight() < capacity;
    }
    
    /**
     * Determines whether multiple products can fit in the box
     * @param p: the product
     * @param quantity
     * @return true or false
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < capacity;
    }
    
    /**
     * Determines amount of weight remaining before the box weighs 20kg
     * @return remaining capacity in kg
     */
    public double remainingCapacity() {
        return capacity - this.getWeight();
    }
    
    /**
     * Determines whether a product is fragile or not
     * @return true or false
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    /**
     * Determines whether a product is hazardous or not
     * @return true or false
     */
    public boolean isHazardous() {
        return false;
    }
}

