package com.ironhack.bootcamp.s07;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathLibraryTest {

    private List<Integer> intList1;
    private List<Integer> intList2;
    private List<Integer> intList3;
    private MathLibrary math;

    @BeforeEach
    public void setUp() {
        math = new MathLibrary();
    }

    /* ==== this is designed to fail */
    @Test
    @DisplayName("Test it is able to add two numbers")
    public void add_twoPositiveInts_Summed() {
        assertEquals(2, math.add(1, 1));
        assertEquals(18, math.add(3, 15));
        assertEquals(298, math.add(152, 146));
    }

    /* ==== this is designed to fail */
    @Test
    @DisplayName("List of positive ints should be summed")
    public void sumList_positiveInts_Sum() {
        intList1 = Arrays.asList(1,2,3,4,5);
        intList2 = Arrays.asList(11,2,43);
        intList3 = Arrays.asList(100);
        assertEquals(15, math.sumList(intList1));
        assertEquals(56, math.sumList(intList2));
        assertEquals(100, math.sumList(intList3));
    }

    /*
    @Test
    @DisplayName("List of negative ints should be summed")
    public void sumList_negativeInts_Sum() {
        intList1 = Arrays.asList(-1,-2,-3,-4,-5);
        intList2 = Arrays.asList(-35, -68);
        intList3 = Arrays.asList(-1, -1, -1, -1, -1 ,-1 ,-1 ,-1 ,-1);
        assertEquals(-15, math.sumList(intList1));
        assertEquals(-103, math.sumList(intList2));
        assertEquals(-9, math.sumList(intList3));
    }

    @Test
    @DisplayName("List of mixed ints should be summed")
    public void sumList_mixedInts_Sum() {
        intList1 = Arrays.asList(-1,2,-3,4,-5);
        intList2 = Arrays.asList(-1750, 45, 32);
        intList3 = Arrays.asList(2, -1, 2, -1, 2 ,-1, 2, -1);
        assertEquals(-3, math.sumList(intList1));
        assertEquals(-1673, math.sumList(intList2));
        assertEquals(4, math.sumList(intList3));
    }

     */

}