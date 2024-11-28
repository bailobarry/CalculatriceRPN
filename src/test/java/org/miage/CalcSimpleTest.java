package org.miage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcSimpleTest {

    @Test
    public void enterValue() {
        CalcSimple calc = new CalcSimple();
        calc.enterValue(8);
        assertEquals("La valeur entree est 8.0", 8.0, calc.displayValueOnTop(), 0.01);
    }

    @Test
    public void add() {
        double attendu = 18.0;
        CalcSimple calc = new CalcSimple();
        calc.add();
        assertEquals("Le resultat de add est 18.0", calc.displayValueOnTop(), attendu, 0.01);
    }

    @Test
    public void subtract() {
        double attendu = 0.0;
        CalcSimple calc = new CalcSimple();
        calc.subtract();
        assertEquals("Le resultat de subtract est 0.0",  calc.displayValueOnTop(), attendu, 0.01);
    }

    @Test
    public void multiply() {
        double attendu = 81;
        CalcSimple calc = new CalcSimple();
        calc.multiply();
        assertEquals("Le resultat de multiply est 81.0", calc.displayValueOnTop(), attendu, 0.01);
    }

    @Test
    public void divide() {
        double attendu = 1.0;
        CalcSimple calc = new CalcSimple();
        calc.divide();
        assertEquals("Le resultat de divide est 1.0", calc.displayValueOnTop(), attendu, 0.01);
    }

    @Test
    public void displayValueOnTop() {
        double attendu = 9.0;
        CalcSimple calc = new CalcSimple();
        assertEquals("Le resultat de displayValueOnTop est 20.0", calc.displayValueOnTop(), attendu, 0.01);
    }
}