package com.tlglearning.fizzbuzz.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class AnalysisTest {

  static final Set<State> fizzExpected = EnumSet.of(State.FIZZ);
  static final Set<State> fizzBuzzExpected = EnumSet.of(State.BUZZ, State.FIZZ);
  static final Set<State> buzzExpected = EnumSet.of(State.BUZZ);
  static final Set<State> neitherExpected = EnumSet.noneOf(State.class); // Set.of()

  final Analysis analysis = new Analysis();

  @ParameterizedTest
  @ValueSource(ints = {3, 21, 999_999_999})
  void analyze_fizz(int value) {
    assertEquals(fizzExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 15, 999_999_990})
  void analyze_fizzBuzz(int value) {
    assertEquals(fizzBuzzExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 85, 999_999_985})
  void analyze_buzz(int value) {
    assertEquals(buzzExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "neither.csv", numLinesToSkip = 1)
  void analyze_neither(int value) {
    assertEquals(neitherExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -3, -5, -15})
  void analyze_negative(int value) {
    //expression lambda(anonymous function)
    // lambda limited to functional interfaces
    assertThrows(IllegalArgumentException.class, () -> analysis.analyze(value));
  }

}