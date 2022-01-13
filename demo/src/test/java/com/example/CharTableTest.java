package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharTableTest {
    @Test
    public void testChar(){
        CharTable cht=new CharTable();
        int j=65;
        for(int i=97; i<=122; i++) {
            assertEquals((char)i+"="+i+"\t"+(char)j+"="+j,cht.stampaLettera(i, j));
        }
    }

    @Test
    public void baseTest() {
        CharTable cht=new CharTable();
        assertEquals("a=97\tA=65", cht.stampaLettera(97, 65));
    }
}
