package com.example.figure;

public class Triangolo extends Figura{
    private double base, altezza;

    public Triangolo(double base, double altezza) {
        this.base=base;
        this.altezza=altezza;
    }

    @Override
    public double area() {
        return (base*altezza)/2;
    }
    
}
