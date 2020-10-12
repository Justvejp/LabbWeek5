package com.company;

public class Dice {

    public int value = 0;

    public void generateRandomValue() {
        this.value = (int) (Math.random()*6+1);
    }
}
