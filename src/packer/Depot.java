package packer;

/**
 *
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;

    /**
     * Depot constructor
     * @param name of depot
     * @param address of depot
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    /**
     * Gets the name of the depot
     * @return depot name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets coordinates of the depot
     * @return depot coordinates
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    /**
     * Prints depot name as a string
     * @return depot name string
     */
    public String toString() {
        return this.getName();
    }
    
}
