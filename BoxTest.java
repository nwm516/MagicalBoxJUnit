package org.example;

import static org.junit.Assert.*;

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

        // Good box volume tests
        assertEquals(36, (firstBox.volume()), 0);
        assertEquals(20, (secondBox.volume()), 0);
        assertEquals(125, (thirdBox.volume()), 0);

        // Bad box volume tests
        assertThrows(IllegalArgumentException.class, () -> badBoxOne.volume());
        assertThrows(IllegalArgumentException.class, () -> badBoxTwo.volume());
        assertThrows(IllegalArgumentException.class, () -> badBoxThree.volume());

        // Unexpected values
        assertNotEquals(35, (firstBox.volume()), 0);
        assertNotEquals(0, (secondBox.volume()), 0);
        assertNotEquals(100, (thirdBox.volume()), 0);
    }

    @org.junit.jupiter.api.Test
    void addItem() {

        // First item added
        String firstItem = "Magic Broom";
        firstBox.addItem(firstItem);
        assertEquals(firstBox.printItems(), "[Magic Broom]");

        // Second item added
        String secondItem = "Double Jump Sneakers";
        firstBox.addItem(secondItem);
        assertEquals(firstBox.printItems(), "[Magic Broom, Double Jump Sneakers]");

        // Null value addition attempt
        assertThrows(IllegalArgumentException.class, () -> firstBox.addItem(null));

        // Testing Boundaries of box
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

        // First removal & test
        firstBox.removeItem(secondItem);
        assertEquals(firstBox.printItems(), "[Ice Nunchucks, Lightning Sword]");

        // A removal attempt at something that was never added
        firstBox.removeItem(fourthItem);
        assertEquals(firstBox.printItems(), "[Ice Nunchucks, Lightning Sword]");

        // Null value removal attempt
        assertThrows(IllegalArgumentException.class, () -> firstBox.removeItem(null));
    }
}