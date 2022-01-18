package com.example.figure;

public class Disegno {
    public static void main(String[] args) {
        Figura[] foglio = { new Rettangolo(2, 3), new Quadrato(5),
                            new Triangolo(4, 5), new Cerchio(6), new Rettangolo(4,6) };
        for(Figura f: foglio) {
            System.out.println(f);
        }

        if(foglio[0].equals(foglio[3])) {
            System.out.println("Sono due oggetti di tipo "+foglio[0].getClass().getSimpleName());
        }
        else {
            System.out.println("Il primo oggetto e' di tipo "+foglio[0].getClass().getSimpleName()+" mentre il secondo e' di tipo "+foglio[3].getClass().getSimpleName());
        }
    }
}
    