package com.tlglearning.fizzbuzz.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

class AnalysisTest {

  static final Set<State> fizzExpected = EnumSet.of(State.FIZZ);

  static final Set<State> buzzExpected = EnumSet.of(State.BUZZ);

  static final Set<State> fizzBuzzExpected = EnumSet.of(State.FIZZ,State.BUZZ);

  static final Set<State> neitherExpected = EnumSet.noneOf(State.class);

  private Analysis analysis = new Analysis();

  @BeforeEach
  public void setUp(){
    analysis = new Analysis();
  }

  @ParameterizedTest
  @ValueSource(ints = {3,6,999_999_999,})
  void analyze_fizz(int value) {
    assertEquals(fizzExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {5,20,100_000_000,})
  void analyze_buzz(int value) {
    assertEquals(buzzExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {0,15,30,150_000_000,})
  void analyze_fizzbuzz(int value) {
    assertEquals(fizzBuzzExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "neither.csv", numLinesToSkip = 1)
  void analyze_neither(int value) {
    assertEquals(neitherExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1,-3,-5,-15})
  void analyze_negative(int value){
    try{
      analysis.analyze(value);
      fail();
    }catch (IllegalArgumentException e){
      // Do nothing; this is the expected behavior
    }
  }
}