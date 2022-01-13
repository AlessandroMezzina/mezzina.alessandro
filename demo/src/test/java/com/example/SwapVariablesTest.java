package com.example;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;

public class SwapVariablesTest {
    @Test
    public void testSwap() {
        int v1 = 3, v2 = 4;
        SwapVariables swapVariables = new SwapVariables(v1, v2);
        swapVariables.swap();
        assertEquals(v1, swapVariables.b);
        assertEquals(v2, swapVariables.a);
    }
}
