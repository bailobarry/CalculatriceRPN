package org.miage;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class RPNParserTest {

    RPNParser rpn;

    @Before
    public void setUp(){
        rpn = new RPNParser();
    }
    @Test
    public void testParseAndDisplayResult() throws ParseException {
        assertThrows("Le nombre d'opérandes est insuffisant", NotEnoughOperandsOnStackException.class, () -> rpn.parseAndDisplayResult("5 +"));
        assertThrows("La division par 0 est impossible", DivideByZeroException.class, () -> rpn.parseAndDisplayResult("3 0 /"));
        assertThrows("Conversion impossible", ParseException.class, () -> rpn.parseAndDisplayResult("3 ab +"));
        assertEquals("Le resultat est 13.0", 13.0, rpn.parseAndDisplayResult("3 5 2 * +"), 0.01);
        assertEquals("Le resultat est 17.0", 17.0, rpn.parseAndDisplayResult("3 5 * 2 +"), 0.01);
        assertEquals("Le resultat est -10.0", -10.0, rpn.parseAndDisplayResult("10 20 -"), 0.01);
        assertEquals("Le resultat est 0.5", 0.5, rpn.parseAndDisplayResult("10 20 /"), 0.01);
        assertEquals("Le resultat est 4.0", 4.0, rpn.parseAndDisplayResult("1 1 1 1 + + +"), 0.01);
    }
}