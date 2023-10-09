package org.example;

import static org.junit.Assert.*;

/**
 * BoxTest class is used to test Box's methods,
 * ensuring that all methods are responding appropriately
 *
 * @author Nicholas Miller
 * @version 10/08/2023
 *
 */

class BoxTest {

    // Good Boxes
    Box firstBox = new Box(3, 3, 4);
    Box secondBox = new Box(2, 2, 5);
    Box thirdBox = new Box(5, 5, 5);

    // Bad Boxes (volumes less than 0)
    Box badBoxOne = new Box(-1, 2, 2);
    Box badBoxTwo = new Box(3, -3, 4);
    Box badBoxThree = new Box(5, 6, -7);

    @org.junit.jupiter.api.Test
    void volume() {

        // Good box volume tests establishing correctly created Box objects
        assertEquals(36, (firstBox.volume()), 0);
        assertEquals(20, (secondBox.volume()), 0);
        assertEquals(125, (thirdBox.volume()), 0);

        // Bad box volume tests, preventing Boxes with wrong dimensions
        assertThrows(IllegalArgumentException.class, () -> badBoxOne.volume());
        assertThrows(IllegalArgumentException.class, () -> badBoxTwo.volume());
        assertThrows(IllegalArgumentException.class, () -> badBoxThree.volume());

        // Unexpected values, asserting values off from what is expected
        assertNotEquals(35, (firstBox.volume()), 0);
        assertNotEquals(0, (secondBox.volume()), 0);
        assertNotEquals(100, (thirdBox.volume()), 0);
    }

    @org.junit.jupiter.api.Test
    void addItem() {

        // First item added, checking on successful method execution
        String firstItem = "Magic Broom";
        firstBox.addItem(firstItem);
        assertEquals(firstBox.printItems(), "[Magic Broom]");

        // Second item added, checking on successful method execution
        String secondItem = "Double Jump Sneakers";
        firstBox.addItem(secondItem);
        assertEquals(firstBox.printItems(), "[Magic Broom, Double Jump Sneakers]");

        // Null value addition attempt, preventing items with no value/text information
        assertThrows(IllegalArgumentException.class, () -> firstBox.addItem(null));

        // Testing Boundaries of box, preventing additional items past the 10th being added
        firstBox.addItem("Three");
        firstBox.addItem("Four");
        firstBox.addItem("Five");
        firstBox.addItem("Six");
        firstBox.addItem("Seven");
        firstBox.addItem("Eight");
        firstBox.addItem("Nine");
        firstBox.addItem("Ten");
        firstBox.addItem("Eleven");
        assertEquals(firstBox.printItems(), "[Magic Broom, Double Jump Sneakers, Three, Four, Five, Six, Seven, Eight, Nine, Ten]");

    }

    @org.junit.jupiter.api.Test
    void removeItem() {

        String firstItem = "Ice Nunchucks";
        String secondItem = "Fire Staff";
        String thirdItem = "Lightning Sword";
        String fourthItem = "Wind Sai";

        // Items added to box
        firstBox.addItem(firstItem);
        firstBox.addItem(secondItem);
        firstBox.addItem(thirdItem);

        /* First removal and test,
           checking successful removal and appropriate outcome of items still remaining */
        firstBox.removeItem(secondItem);
        assertEquals(firstBox.printItems(), "[Ice Nunchucks, Lightning Sword]");

        /* A removal attempt at something that was never added,
           assuring Box object's contents are what we expect */
        firstBox.removeItem(fourthItem);
        assertEquals(firstBox.printItems(), "[Ice Nunchucks, Lightning Sword]");

        /* Null value removal attempt,
           again preventing passage of items with no value/text information */
        assertThrows(IllegalArgumentException.class, () -> firstBox.removeItem(null));
    }
}