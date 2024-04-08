package com.mycompany.gofish;

/**
 *
 * @author JennyLe
 * @author Saad
 * @author destinyodia
 * 
 * Date: 07 April 2024
 */

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }


    @Override
    public void play() {
        System.out.println("Computer Player");
    }
    @Override
    public String toString(){
        return getName();
    }
    
}
