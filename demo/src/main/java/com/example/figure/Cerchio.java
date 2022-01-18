package com.example.figure;

public class Cerchio extends Figura{
    private double raggio;

    public Cerchio(double raggio) {
        this.raggio=raggio;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(raggio, 2);
    }
    
}
