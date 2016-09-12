package com.example;
import java.util.*;


/**
 * Created by mafaldaborges on 9/11/16.
 */
public class Farm {

    ArrayList<Animal> animalList = new ArrayList<Animal>();
    public Farm(){}

    public void addAnimal(Animal newAnimal){
        this.animalList.add(newAnimal);
    }

    public Animal getAnimal(int pos){
        return this.animalList.get(pos);
    }

    public ArrayList<Animal> getHeaviestAnimals(){
        ArrayList<Animal> copy = new ArrayList(animalList);
        Collections.sort(copy, new WeightComparator());
        return copy;

    }

    public void printCatNames(){
        for (int i = 0; i < animalList.size(); i++){
            if (animalList.get(i).getSpecies() == "Cat"){
                System.out.println(animalList.get(i).getName());
            }
        }
    }

    public long averageLegs(){
        long counter = 0;
        for (int i = 0; i < animalList.size(); i++){
            counter += animalList.get(i).getLeg();
        }
        return counter/animalList.size();
    }



}
