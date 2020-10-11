package org.dominicjesse.javaCollectStreams;

import org.dominicjesse.models.Person;

import java.util.function.*;

public class LambdaReview {

    public static void runExamples() {
        //review of basics again
        Consumer<Boolean> printBool = System.out::println;
        Predicate<String> s1 = s -> s.length() > 20;
        printBool.accept(s1.test("ababa"));
        printBool.accept(s1.test("cdcdcdcdcdcdcdcdcdcdcdcdcdcdcd"));

        //REVIEW - just some other examples from java.util.function
        Consumer<Boolean> printStr = System.out::println;
        BiConsumer<Integer, Double> inter = (r, p) -> System.out.println(p * (r / 100));
        Supplier<Person> personSupplier = Person::new;
        Function<Person, Integer> personAge = Person::getAge;
        BiFunction<Person, Integer, Boolean> isPersonThisOld =
                (p, a) -> p.getAge() >= a ? true : false;
        UnaryOperator<Integer> sq = a -> a * a;
        BinaryOperator<Boolean> andLogic = (a, b) -> a && b;
        Predicate<Person> isSenior = p -> p.getAge() >= 65;
        BiPredicate<Person, Integer> isThisAge =  (p, a) -> p.getAge() >= a;
        //review of primitive lambdas
        //IntPredicate, IntFunction, IntUnaryOperator, IntToDoubleFunction, etc.

    }
}
