package org.miage;

public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException() {
        super("Impossible de faire la division par 0.");
    }
}
