package com.example;
import java.util.*;

/**
 * Created by mafaldaborges on 9/11/16.
 */
public class WeightComparator implements Comparator<Animal> {
    @Override public int compare(Animal a1, Animal a2){
        return (int)(a2.getWeight() - a1.getWeight());
    }
}
