package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad
 */
public class Manifest {

    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    /**
     * Manifest constructor
     */
    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }

    /**
     * Adds a product to the manifest
     * @param p: product
     */
    public void addProduct(Product p) {
        addProduct(p, 1);
    }

    /**
     * Adds multiple products to the manifest
     * @param p: product
     * @param quantity 
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p, quantities.get(p) + quantity);
        } else {
            quantities.put(p, quantity);
            if (!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }

    /**
     * Removes product from the manifest
     * @param p: product 
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p, quantities.get(p) - 1);
        }
        if (quantities.get(p) == 0) {
            quantities.remove(p);
            byWeight.remove(p);
        }
    }

    /**
     * Gets the total weight of all the products in the manifest
     * @return manifest weight in kg
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += quantities.get(p) * p.getWeight();
        }
        return weight;
    }

    /**
     * Gets the heaviest product in the manifest that is under a certain weight
     * @param weight of the heaviest product
     * @return the heaviest product under the certain weight
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }

    /**
     * Gets the status of whether the manifest is empty or not.
     * @return true or false
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }

    /**
     * Determines whether a certain product is in the manifest
     * @param p: the specified product
     * @return  true or false
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }

    /**
     * Builds a string of all the items in the manifest and their quantities
     * @return products in the manifest and their quantities
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        if (result.length() == 0) {
            return "";
        }
        return result.substring(0, result.length() - 1);
    }

    /**
     * Determines whether the manifest contains fragile items
     * @return true or false
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines whether the manifest contains hazardous items
     * @return 
     */
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }

}
    

