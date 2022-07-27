package com.tlglearning.fizzbuzz;

import com.tlglearning.fizzbuzz.model.Analysis;
import com.tlglearning.fizzbuzz.model.State;

import java.util.Set;
import org.apache.commons.cli.Options;

public class FizzBuzz {

    private static final int DEFAULT_UPPER_BOUND = 100;

    public static void main(String[] args) {



        try {
            int upperBound = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_UPPER_BOUND;
            if(upperBound <= 1){
                throw new IllegalArgumentException();
            }
            Analysis analysis = new Analysis();
            for (int i = 1; i <= upperBound; i++) {
                Set<State> result = analysis.analyze(i);

                System.out.println(result.isEmpty() ? i : result);


            }
        } catch (IllegalArgumentException e) {
            System.out.printf("usage: java %1$s [upperBound]%n", FizzBuzz.class.getName());
            System.out.println("Where: upperBound is a positive integer, with a default of 100");
        } finally {
            System.out.println("Thanks for playing FizzBuzz");
        }

    }
}
