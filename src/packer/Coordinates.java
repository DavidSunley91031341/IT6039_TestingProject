package packer;

/**
 *
 * @author I.M.Bad
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    
    /**
     * Coordinates constructor
     * @param x coordinate on a flat plane
     * @param y coordinate on a flat plane
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x coordinate
     * @returns the distance in km from a fixed point along the x axis
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y coordinate
     * @return the distance in km from a fixed point along the y axis
     */
    public double getY() {
        return y;
    }
    
    /**
     * Gets euclidean distance from current coordinates to a set of different coordinates
     * @param other: coordinates of the other position
     * @return distance in km
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }
    
    /**
     * Gets manhattan distance from current coordinates to a set of different coordinates
     * @param other: coordinates of the other position
     * @return distance in km
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    
    /**
     * Gets the distance from the company's coordinates to a set of different coordinates
     * @param other: coordinates of the other position
     * @return distance in km
     */
    public double companyDistanceTo(Coordinates other) {
        double xDiff1 = other.getX() - this.getX();
        double yDiff1 = other.getY() - this.getY();
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1),0.5);
        double xDiff2 = other.getX() - this.getX();
        double yDiff2 = other.getY() - this.getY();
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        return ((dist1 + dist2)/2) + 1;
    }

}
