package org.example;

/**
 * Main method to allow Box class program to run
 *
 * @author Nicholas Miller
 * @version 10/08/2023
 *
 */

public class Main {
    public static void main(String[] args) {
        Box magicBox = new Box(3, 3, 5);
        magicBox.volume();

        magicBox.addItem("Wand");
        magicBox.addItem("Staff");
        magicBox.addItem("Shield");
        magicBox.printItems();

        magicBox.addItem("Bow");
        magicBox.addItem("Quiver");
        magicBox.addItem("Mace");
        magicBox.addItem("Metal Armor");
        magicBox.addItem("Scroll of Wind");
        magicBox.addItem("Tome of Darkness");
        magicBox.addItem("Swift Boots");

        magicBox.addItem("Purple Goo");
        magicBox.addItem("Gold Goo");
        magicBox.printItems();

        magicBox.removeItem("Broadsword");

        magicBox.removeItem("Shield");
        magicBox.printItems();
    }
}