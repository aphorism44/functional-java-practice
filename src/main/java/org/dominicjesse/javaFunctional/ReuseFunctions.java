package org.dominicjesse.javaFunctional;

import java.util.function.Function;

public class ReuseFunctions {

    public static void runExamples() {
        //currying - convert function of multiple arguments into
        //function that uses one argument at a time

        //partial application - like above
        //,but can take more than 1 argument at a time

        Function<Double, Function<Double, Double>> calculateTax = rate -> amount -> amount * rate;
        Function<Double, Double> calculateNationalTax = calculateTax.apply(0.2);
        Function<Double, Double> calculateStateTax = calculateTax.apply(0.3);

        System.out.println(calculateNationalTax.apply(100.00));
        System.out.println(calculateStateTax.apply(100.00));

        

    }

}
