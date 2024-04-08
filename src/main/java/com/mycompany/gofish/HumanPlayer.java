package com.mycompany.gofish;

/**
 *
 * @author jennyle
 * @author saadkhan
 * @author destinyodia
 * 
 * Date: 07 April 2024
 */

public class HumanPlayer extends Player {
    private String iD; // Change the type of ID to String

    public HumanPlayer(String name) {
        super(name);
        // Set the unique ID as the name
        this.iD = name;
    }

    // Remove the getId() method as it's no longer needed

    @Override
    public String toString() {
        return getName() + " (ID: " + iD + ")"; // Include the ID in the toString() method
    }

    @Override
    public void play() {
        System.out.println("Human player!");
    }
}
