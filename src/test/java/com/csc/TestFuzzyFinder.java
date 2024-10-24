package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
  }

  @Test
  void testLinearSearchWithRandomizedFuzzies(){
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    int index = finder.linearSearch(fuzzies);
    assertEquals(fuzzies.get(index).color, "gold");
  }

  @Test
  void testLinearSearchWithSortedFuzzies(){
    ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
    int index = finder.linearSearch(fuzzies);
    assertEquals(fuzzies.get(index).color, "gold");
  }

  @Test
  void testBinarySearchWithRandomizedFuzzies(){
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    int index = finder.binarySearch(fuzzies);
    assertEquals(-1, index);
  }

  @Test
  void testBinarySearchWithSortedFuzzies(){
    ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
    int index = finder.binarySearch(fuzzies);
    assertEquals(fuzzies.get(index).color, "gold");
  }
}
