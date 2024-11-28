package org.miage;

import java.text.ParseException;

public class RPNParser implements InterfaceRPNParser {
    private final Calc calculatrice;

    public RPNParser() {
        this.calculatrice = new Calc();
    }

    @Override
    public double parseAndDisplayResult(String toParse) throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        // Découper la chaîne en tokens
        String[] tokens = toParse.split(" ");

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Effectuer directement l'opération correspondante
                switch (token) {
                    case "+":
                        calculatrice.add();
                        break;
                    case "-":
                        calculatrice.subtract();
                        break;
                    case "*":
                        calculatrice.multiply();
                        break;
                    case "/":
                        calculatrice.divide();
                        break;
                }
            } else {
                try {
                    // Ajouter la valeur numérique à la calculatrice
                    calculatrice.enterValue(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    // Gérer une entrée non convertible en nombre
                    throw new ParseException("Conversion impossible pour le token : " + token, 0);
                }
            }
        }

        // Retourner la valeur au sommet de la pile
        return calculatrice.displayValueOnTop();
    }
}
