package org.miage;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack implements InterfaceStack {
    private final List<Double> pile = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return pile.isEmpty();
    }

    @Override
    public int getSize(){
        return pile.size();
    }

    @Override
    public void push(double item){
        pile.add(item);
    }

    @Override
    public double peek() throws EmptyStackException{
        if(pile.isEmpty()){
            throw new EmptyStackException();
        }else{
            int taille = pile.size();
            return pile.get(taille-1);
        }
    }

    @Override
    public double pop() throws EmptyStackException{
        if(pile.isEmpty()){
            throw new EmptyStackException();
        }else{
            int taille = pile.size();
            return pile.remove(taille-1);
        }
    }
}
