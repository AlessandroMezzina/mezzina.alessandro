package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals; // se si rispetta una condizione il test viene considerato superato (vedere sotto)

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1); // se si rispetta una condizione il test viene considerato superato
        // assertEquals(1, 2); se scrivo 2 come secondo parametro invece di 1, il test fallisce e appaiono errori
    }

    @Test
    void testMessage() {
        assertEquals("Hello World!", App.message()); // per il test del messaggio Hello World!
    }

}
