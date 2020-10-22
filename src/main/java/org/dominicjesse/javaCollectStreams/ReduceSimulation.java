package org.dominicjesse.javaCollectStreams;

import org.dominicjesse.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceSimulation {

    public static void runExamples() {
        List<User> userList = new ArrayList<>();
        //avg ages of users over age 20
        //map (people to age) -> filter (age > 20) -> reduce (mean age)
        //REDUCTION PROCESS - for (a,b) - at first, a = [0] and b=[1]
        //operation made, and result becomes a for next (a,b) call
        //for a lambda, must be ASSOCIATIVE
        //initial value must be IDENTITY ELEMENT of function

        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);
        List<Integer> parallelInts = new ArrayList<>();

        //this is associative, and works for parallel computing
        BinaryOperator<Integer> ops = (i1, i2) -> i1 + i2;
        //so is this, UNLESS WE USE POS NUMBERS,  since no identity element
        //BinaryOperator<Integer> ops = (i1, i2) -> Math.max(i1,i2);
        //this isn't, and you'll get different values below
        //BinaryOperator<Integer> ops = (i1, i2) -> (i1 + i2) * (i1 + i2);
        //next 2 are (first and last element)
        //BinaryOperator<Integer> ops = (i1, i2) -> i1;
        //BinaryOperator<Integer> ops = (i1, i2) -> i2;
        //average isn't
        //BinaryOperator<Integer> ops = (i1, i2) -> (i1 + i2) / 2;


        //normal run (one core)
        int reduction = reduce(ints, 0, ops);

        //SIMULATE parallel computing
        int reduction1 = reduce(ints1, 0, ops);
        parallelInts.add(reduction1);
        int reduction2 = reduce(ints2, 0, ops);
        parallelInts.add(reduction2);
        int parallelReduction = reduce(parallelInts, 0, ops);

        System.out.println("run normally: " + reduction);
        System.out.println("run in parallel: " + parallelReduction);
        System.out.println("appears associative: " + (reduction == parallelReduction));

    }

    public static int reduce(List<Integer> values, int identityElement, BinaryOperator<Integer> reduction) {
        int result = identityElement;
        for (int value: values)
            result = reduction.apply(result, value);

        return result;
    }


}
