package com.tlglearning.fizzbuzz.model;

import org.junit.jupiter.api.function.Executable;

class InvalidInvocation implements Executable {

  private final Analysis analysis;
  private final int value;

  public InvalidInvocation(Analysis analysis, int value) {
    this.analysis = analysis;
    this.value = value;
  }

  @Override
  public void execute() throws Throwable {
    analysis.analyze(value);
  }
}
