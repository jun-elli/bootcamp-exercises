package com.ironhack.bootcamp.s08.testedComponents;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BuildNameExerciseMainTest {

    private BuildNameExerciseMain instance;

    @BeforeEach
    public void setup() {
        instance = new BuildNameExerciseMain();
    }

    @DisplayName("Valid first name and second name do not throw exception")
    @Test
    public void testConcat() {
        String fullName = instance.concat("Toni", "Mas");
        Assertions.assertEquals("Toni Mas", fullName);
    }

    @DisplayName("null first name throws IllegalArgumentException")
    @Test
    public void testConcatNullFirstArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> instance.concat("Toni", "Mas") );
    }
}
