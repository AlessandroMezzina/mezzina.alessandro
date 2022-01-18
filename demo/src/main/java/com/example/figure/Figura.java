package com.example.figure;

public abstract class Figura {
    public abstract double area();
    @Override
    public String toString() {
        return "L'area della figura "+descriviti()+" è "+area();
    }

    public String descriviti() {
        return this.getClass().getSimpleName(); //Ritorna nome classe senza package
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(obj instanceof Figura)
            return this.getClass().getSimpleName()==((Figura)obj).getClass().getSimpleName();
        return false;
    }
}
    