package org.miage;

public class NotEnoughOperandsOnStackException extends RuntimeException {
    public NotEnoughOperandsOnStackException() {
        super("Nombre d'éléments incorrect.");
    }
}
