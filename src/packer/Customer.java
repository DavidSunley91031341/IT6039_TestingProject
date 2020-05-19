package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I.M.Bad
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;

    /**
     * Customer constructor 
     * @param name
     * @param address: current address in the address arrayList
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
     * Adds another address to the customer's address arrayList 
     * @param address: new address being added
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    /**
     * Gets the name of the customer
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the depot that is closest to the customer's address
     * @param d: depot
     * @return closest depot address
     */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestDistance = distance;
                bestAddress = a;
            }
        }
        return bestAddress;
    }

    /**
     * Prints the customer's name as a string
     * @return customer name string
     */
    public String toString() {
        return this.getName();
    }
}
