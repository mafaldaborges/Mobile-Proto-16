package com.example;
import java.lang.*;

/**
 * Created by mafaldaborges on 9/9/16.
 */
public class Cat extends Animal {

    public Cat(String name, String color){
        super(4, name, color, "Cat", (Math.random()*25));
    }

    @Override
    public void grow() {
        setWeight(getWeight()*3);
    }


}
