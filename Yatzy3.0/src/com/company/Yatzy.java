package com.company;

import java.util.Scanner;

public class Yatzy {

    private final Scanner sc = new Scanner(System.in);
    private final Dice[] dices = new Dice[5];
    private int turns = 0;

    private Yatzy() {
        initiateDices();
        playGame();
    }

    private void initiateDices() {

        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
        }
    }

    private void playGame() {

        System.out.println("Welcome to Yatzy, type (R) to roll the dices, or anything else to close the program.");
        System.out.print("Type here: ");

        while (turns < 3) {

            if (sc.next().equalsIgnoreCase("R")) {

                turns++;

                startTurn();

            } else {
                System.out.println("Closing game..");
                return;
            }
        }
        newGameOrNot();
    }

    private void startTurn() {

        rollDices();

        if (checkIfYatzy(dices)) {
            System.out.println("You got Yatzy!! " + turns + " of 3");

        } else {
            System.out.println("Not good enough, turn " + turns + " of 3");
        }
    }

    private void rollDices() {

        for (int i = 0; i < dices.length; i++) {
            dices[i].generateRandomValue();
            System.out.println("Dice " + (i+1) + " = " + dices[i].value);
        }
    }

    public static boolean checkIfYatzy(Dice[] d) {

        boolean b = true;

        for (int i = 1; i < d.length; i++) {

            if (d[i].value != d[i-1].value) {

                b = false;
                break;
            }
        }
        return b;
    }

    private void newGameOrNot() {

        System.out.println("You ran of of rounds, do you want to start a new game press (Y), anything else will close the program.");
        System.out.print("Type here: ");

        if (sc.next().equalsIgnoreCase("Y")) {

            turns = 0;

            playGame();

        } else {
            System.out.println("Closing game..");
        }
    }

    public static void main(String[] args) {
        new Yatzy();
    }
}
