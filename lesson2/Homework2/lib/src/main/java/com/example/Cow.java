package com.example;
import java.lang.*;
/**
 * Created by mafaldaborges on 9/11/16.
 */
public class Cow extends Animal{
    public Cow(String name, String color){
        super(4, name, color, "Cow", (Math.random()*100 + 100));
    }

    @Override
    public void grow() {
        setWeight(getWeight()*5);
    }
}
