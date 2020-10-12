package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class YatzyTest {

    @Test
    void checkingIfYatzyWork() {

        Dice[] dices = new Dice[5];

        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
        }

       assertTrue(Yatzy.checkIfYatzy(dices));
    }

    @Test
    void checkingIfYatzyDontWork() {

        Dice[] dices = new Dice[5];

        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
        }

        dices[0].value = 1;

        assertFalse(Yatzy.checkIfYatzy(dices));
    }
}