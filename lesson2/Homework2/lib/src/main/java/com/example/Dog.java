package com.example;
import java.lang.*;
/**
 * Created by mafaldaborges on 9/11/16.
 */
public class Dog extends Animal {
    public Dog(String name, String color){
        super(4, name, color, "Dog", (Math.random()*25));
    }

    @Override
    public void grow() {
        setWeight(getWeight()*(1.5));
    }
}
