package com.example;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }

    public static int gcd(int m, int n) {

        if (m>n){
            if (n ==0){
                return m;
            }
            return gcd(n, m%n);
        }
        else{
            if (m ==0){
                return n;
            }
            return gcd(m, n%m);
        }

    }

    public void simplify(){
        int k = gcd(numerator,denominator);
        numerator = numerator/k;
        denominator = denominator/k;
    }

    public Fraction add(Fraction f){
        int n = ((f.numerator*denominator)+(numerator*f.denominator));
        int d = denominator*f.denominator;
        int k = gcd(n,d);
        Fraction a = new Fraction(n/k,d/k);
        return a;


    }



}

