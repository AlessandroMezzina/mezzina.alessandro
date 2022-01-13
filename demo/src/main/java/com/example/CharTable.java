package com.example;

public class CharTable {
    public static void main(String[] args) {
        CharTable cht=new CharTable();

        for(int i=97; i<=122; i++) {
            int j=65;
            cht.stampaLettera(i, j);
        }
    }

    public String stampaLettera(int i, int j) {
        return (char)i+"="+i+"\t"+(char)j+"="+j;
    }

}
