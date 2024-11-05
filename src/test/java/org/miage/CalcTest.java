package org.miage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {
    Calc calc;

    @Before
    public void setUp(){
        calc = new Calc();
    }

    @Test
    public void testenterValue() {
        calc.enterValue(5.23);
        assertEquals("La valeur entrée est 5.23", 5.23, calc.displayValueOnTop(), 0.01);
        calc.enterValue(10.50);
        assertEquals("La valeur entrée est 10.50", 10.50, calc.displayValueOnTop(), 0.01);
    }

    @Test
    public void testadd() {
        assertThrows("Le nombre d'opérandes est insuffisant, addition impossible", NotEnoughOperandsOnStackException.class, () -> calc.add());
        calc.enterValue(6.35);
        calc.enterValue(4.40);
        calc.add();
        assertEquals("Le resultat de l'addition est 10.75", 10.75, calc.displayValueOnTop(), 0.01);
    }

    @Test
    public void testsubtract() {
        assertThrows("Le nombre d'opérandes est insuffisant, soustraction impossible", NotEnoughOperandsOnStackException.class, () -> calc.subtract());
        calc.enterValue(0);
        calc.enterValue(8.26);
        calc.subtract();
        assertEquals("Le resultat de la soustraction est -8.26", 8.26, calc.displayValueOnTop(), 0.01);
        calc.enterValue(5.25);
        calc.enterValue(1);
        calc.subtract();
        assertEquals("Le resultat de la soustraction est -4.25", -4.25, calc.displayValueOnTop(), 0.01);
        calc.enterValue(10.90);
        calc.enterValue(6.50);
        calc.subtract();
        assertEquals("Le resultat de la soustract est -4.40", -4.40, calc.displayValueOnTop(), 0.01);
    }

    @Test
    public void testmultiply() {
        assertThrows("Le nombre d'opérandes est insuffisant, multiplication impossible", NotEnoughOperandsOnStackException.class, () -> calc.multiply());
        calc.enterValue(0);
        calc.enterValue(2.36);
        calc.multiply();
        assertEquals("Le resultat de la multiplication est 0.00", 0.00, calc.displayValueOnTop(), 0.01);
        calc.enterValue(7.35);
        calc.enterValue(1);
        calc.multiply();
        assertEquals("Le resultat de la multiplication est 7.35", 7.35, calc.displayValueOnTop(), 0.01);
        calc.enterValue(6.30);
        calc.enterValue(3.80);
        calc.multiply();
        assertEquals("Le resultat de la multiplcation est 23.94", 23.94, calc.displayValueOnTop(), 0.01);
    }

    @Test
    public void testdivide() {
        assertThrows("Le nombre d'opérandes est insuffisant, division impossible", NotEnoughOperandsOnStackException.class, () -> calc.divide());
        calc.enterValue(0.00);
        calc.enterValue(8.45);
        assertThrows("La division par 0 est impossible", DivideByZeroException.class, () -> calc.divide());
        calc.enterValue(5.25);
        calc.enterValue(0.00);
        calc.divide();
        assertEquals("Le resultat de la division est 0.00", 0.00, calc.displayValueOnTop(), 0.01);
        calc.enterValue(1);
        calc.enterValue(10.80);
        calc.divide();
        assertEquals("Le resultat de la division est 10.80", 10.80, calc.displayValueOnTop(), 0.01);
        calc.enterValue(4.23);
        calc.enterValue(40.40);
        calc.divide();
        assertEquals("Le resultat de la division est 9.55", 9.55, calc.displayValueOnTop(), 0.01);
    }

    @Test
    public void testdisplayValueOnTop() {
        assertThrows("Il n'y a pas d'opérandes dans la calculatrice", NotEnoughOperandsOnStackException.class, () -> calc.displayValueOnTop());
        calc.enterValue(8.53);
        calc.enterValue(15.65);
        calc.displayValueOnTop();
        assertEquals("La valeur du sommet de la pile est 15.65", 15.65, calc.displayValueOnTop(), 0.01);
    }
}