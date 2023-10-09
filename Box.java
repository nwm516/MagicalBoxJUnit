package org.example;

import java.util.ArrayList;

/**
 * Defines Box class for items to be held within
 *
 * @author Nicholas Miller
 * @version 10/08/2023
 *
 *
 *
 */
public class Box {

    /** Defines width for Box object in constructor */
    private double width;

    /** Defines height for Box object in constructor */
    private double height;

    /** Defines depth for Box object in constructor */
    private double depth;

    /** ArrayList used for storage of items in Box object */
    private ArrayList<String> inside = new ArrayList<>();

    /**
     * Boolean value to determine if ArrayList is at capacity
     * and can no longer add items to ArrayList
     */
    private boolean boxNotFull = true;

    /**
     * Box constructor
     *
     * @param width     Defines width dimension of Box object; cannot be below 0
     * @param height    Defines height dimension of Box object; cannot be below 0
     * @param depth     Defines depth dimension of Box object; cannot be below 0
     */
    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    /**
     * Calculates volume of Box object
     *
     * @return
     */
    public double volume() {
        double calculatedVol = (this.width * this.height * this.depth);

        if (calculatedVol < 0) {
            throw new IllegalArgumentException("Volume cannot be negative");
        }
        System.out.println("Box's Volume: " + calculatedVol);
        return calculatedVol;
    }

    /**
     * Determines whether the box has enough room for another item
     * to be added
     *
     * @param   inside  the ArrayList whose capacity is being tested
     */
    public boolean hasRoom(ArrayList inside) {
        if (inside.size() > 9) {
            boxNotFull = false;
            return boxNotFull;
        }
        return boxNotFull;
    }
    /**
     * Adds an item to the Box object's ArrayList
     *
     * @param   item    Item to be added to the Box object's ArrayList; cannot be null
     */
    public void addItem(String item) {
        this.hasRoom(inside);

        if (boxNotFull) {
            if (item == null) {
                throw new IllegalArgumentException("Item must not be null");
            }
            inside.add(item);
        }
        else {
            return;
        }
    }

    /**
     * Removes an item from the Box object's ArrayList
     *
     * @param   item    Item to be removed from the Box object's ArrayList; cannot be null
     */
    public void removeItem(String item) {
        int insideInitialSize = inside.size();
        int insideAfterLoop = 0;

        for (int insideCounter = 0; insideCounter < inside.size(); insideCounter++) {
            if (item == null) {
                throw new IllegalArgumentException("Item must not be null");
            }
            if (inside.get(insideCounter).equals(item)) {
                inside.remove(item);
            }
            insideAfterLoop = inside.size();
        }

        if (insideInitialSize != insideAfterLoop) {
            System.out.println(item + " was removed from the magic box.");
        }
        else {
            System.out.println(item + " was not inside the magic box. No removal was necessary.");
        }
    }

    /**
     * Prints the contents of the Box object's ArrayList
     *
     * @return      variable to show contents of Box
     */
    public String printItems() {
        String output = inside.toString();
        return output;
    }
}
