package org.miage;

public class Calc implements InterfaceCalc{

    Stack pile  = new Stack();

    @Override
    public void enterValue(double value) {
        pile.push(value);
    }

    @Override
    public void add() throws NotEnoughOperandsOnStackException {
        if(pile.getSize() < 2){
            throw new NotEnoughOperandsOnStackException();
        }else{
            double val1 = pile.pop();
            double val2 = pile.pop();
            pile.push(val2 + val1);
        }
    }

    @Override
    public void subtract() throws NotEnoughOperandsOnStackException {
        if(pile.getSize() < 2){
            throw new NotEnoughOperandsOnStackException();
        }else{
            double val1 = pile.pop();
            double val2 = pile.pop();
            pile.push(val2 - val1);
        }
    }

    @Override
    public void multiply() throws NotEnoughOperandsOnStackException {
        if(pile.getSize() < 2){
            throw new NotEnoughOperandsOnStackException();
        }else{
            double val1 = pile.pop();
            double val2 = pile.pop();
            pile.push(val2 * val1);
        }
    }

    @Override
    public void divide() throws NotEnoughOperandsOnStackException, DivideByZeroException {
        if(pile.getSize() < 2){
            throw new NotEnoughOperandsOnStackException();
        }else{
            double val1 = pile.pop();
            double val2 = pile.pop();
            if(val1 != 0){
                pile.push(val2 / val1);
            }else{
                throw new DivideByZeroException();
            }
        }
    }

    @Override
    public double displayValueOnTop() throws NotEnoughOperandsOnStackException {
        if(pile.getSize() < 1){
            throw new NotEnoughOperandsOnStackException();
        }else{
            return pile.peek();
        }
    }
}
