package com.example;

/**
 * Created by mafaldaborges on 9/9/16.
 */
public abstract class Animal {

    private long legs;
    private String name;
    private String color;
    private String species;
    private double weight;

    public Animal(long legs, String name, String color, String species, double weight){
        this.legs = legs;
        this.name = name;
        this.color = color;
        this.species = species;
        this.weight = weight;
    }

    public long getLeg() {
        return legs;
    }

    public void setLeg(long newlegs) {
        this.legs = newlegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String newname) {
        this.name = newname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    abstract void grow();
}