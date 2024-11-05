package org.miage;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {
    Stack pile;

    @Before
    public void setUp(){
        pile = new Stack();
    }

    @Test
    public void testIsEmpty() {
        assertTrue("La pile est vide.", pile.isEmpty());
    }

    @Test
    public void testGetSize(){
        assertEquals("Aucun element dans la pile",0, pile.getSize());
        pile.push(5.23);
        pile.push(1.05);
        pile.push(2.32);
        assertEquals("Il y a 3 elements dans la pile",3, pile.getSize());
    }

    @Test
    public void testPush(){
        pile.push(3.05);
        assertEquals("1 element ajouté dans la pile",1, pile.getSize());
        pile.push(9.45);
        assertEquals("2 elements ajoutés dans la pile",2, pile.getSize());
        pile.push(8.01);
        assertEquals("3 elements ajoutés dans la pile", 3, pile.getSize());
    }

    @Test
    public void testPeek(){
        assertThrows("Peek est vide dans la pile",EmptyStackException.class, () -> pile.peek());
        pile.push(15.23);
        pile.push(10.05);
        pile.push(7.32);
        assertEquals("La valeur de peek est 7.32", 7.32, pile.peek(), 0.01);
    }

    @Test
    public void testPop(){
        assertThrows("Aucune valeur dans la pile",EmptyStackException.class, () -> pile.pop());
        pile.push(16.33);
        pile.push(8.48);
        pile.push(11.58);
        assertEquals("Il y a 3 elements dans la pile",3, pile.getSize());
        assertEquals("Suppression de 11.58", 11.58, pile.pop(), 0.01);
        assertEquals("Il reste 2 elements dans la pile", 2, pile.getSize());
    }
}