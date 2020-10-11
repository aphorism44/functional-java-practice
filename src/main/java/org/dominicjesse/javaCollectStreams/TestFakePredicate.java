package org.dominicjesse.javaCollectStreams;

import org.dominicjesse.interfaces.Predicate;

import java.util.function.Consumer;

public class TestFakePredicate {

    public static void runExamples() {
        Consumer<Boolean> print = System.out::println;
        //below uses our custom predicate
        Predicate<String> p1  = s -> s.length() > 5;
        Predicate<String> p2  = s -> s.length() < 7;

        Predicate<String> p3 = p1.and(p2);
        print.accept(p3.test("aaaaaa"));
        print.accept(p3.test("aa"));
        print.accept(p3.test("aaaaaaaa"));

        Predicate<String> p4 = p1.or(p2);
        System.out.println();
        print.accept(p4.test("aaaaaa"));
        print.accept(p4.test("aa"));
        print.accept(p4.test("aaaaaaaa"));

        Predicate<String> p5 = Predicate.isEqualsTo("Yes");
        System.out.println();
        print.accept(p5.test("aaaaaa"));
        print.accept(p5.test("Yes"));

        Predicate<Integer> p6 = Predicate.isEqualsTo(1);
        System.out.println();
        print.accept(p6.test(1));
        print.accept(p6.test(2));

    }


}
