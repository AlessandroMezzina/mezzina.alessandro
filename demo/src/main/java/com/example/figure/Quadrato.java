package com.example.figure;

public class Quadrato extends Figura{
    private double l;
    public Quadrato(double l) {
        this.l=l;
    }

    @Override
    public double area() {
        return l*l;
    }
    
}
