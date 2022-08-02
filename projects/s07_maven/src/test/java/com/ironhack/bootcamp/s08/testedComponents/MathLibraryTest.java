package com.ironhack.bootcamp.s08.testedComponents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathLibraryTest{

    @Test
    public void multiply_largeInts_IllegalArgumentException() {

        MathLibrary math = new MathLibrary();
        assertThrows(IllegalArgumentException.class, () -> math.multiply(90000000, 40000000));

    }
}