package org.miage;

import java.text.ParseException;
import java.util.ArrayList;

public class RPNParser implements InterfaceRPNParser {
    private final Calc calculatrice;

    public RPNParser() {
        this.calculatrice = new Calc();
    }

    @Override
    public double parseAndDisplayResult(String toParse) throws NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {
        // Découper la chaine à chaque espace
        String[] tokens = toParse.split(" ");

        // Liste des opérations contenus dans une chaine
        ArrayList<String> operandes = new ArrayList<>();

        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                operandes.add(token);
            }else{
                try{
                    calculatrice.enterValue(Double.parseDouble(token));
                }catch(NumberFormatException e){
                    throw new ParseException(e.getMessage(), 0);
                }
            }
        }


        for(String operand : operandes){
            switch (operand){
                case "+":
                    calculatrice.add();
                    break;
                case "-":
                    calculatrice.subtract();
                    break;
                case "*":
                    calculatrice.multiply();
                    break;
                case "/": calculatrice.divide();
                break;
            }
        }
        return calculatrice.displayValueOnTop();
    }
}
