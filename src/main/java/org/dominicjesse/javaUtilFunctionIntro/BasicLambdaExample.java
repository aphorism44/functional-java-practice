package org.dominicjesse.javaUtilFunctionIntro;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BasicLambdaExample {

    public static void runExamples() {
        System.out.println();
        Supplier<String> supplier =
                () -> {
                    System.out.println("I'm now in the Supplier.");
                    return "Hello Functional Java!";
                };

        Consumer<String> consumer =
                (String t) -> {
                    System.out.println("I'm now in the Consumer.");
                    System.out.println(t);
                };

        consumer.accept(supplier.get());

    }


}
