package org.dominicjesse.javaUtilFunctionIntro;


import org.dominicjesse.models.User;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class JavaLambdas {
    //are 40 different toolbox interfaces total
    //concentrate on
    //1.    T Supplier.get() - always returns something
    //2.    void Consumer.accept(T) - always takes in something and does something
    //3.    boolean Predicate.test(T) - boolean used for filter
    //4.    R Function.apply(T) - maps one type to another
    //(also)
    //5.    void Runnable.run() - just runs some code

    public static void runExamples() {
        System.out.println();
        List<String> strings =
                new ArrayList(Arrays.asList("one", "two", "three", "four", "five"));
        //Predicate.test returns a boolean -
        //Predicate<String> tFilter = (String s) -> !s.startsWith("t");
        strings.removeIf(s -> !s.startsWith("t"));

        //Consumer.accept is a void function, but does things to input
        Consumer<String> printString = s -> System.out.println(s);
        //NOTE - can fit on one line if needed
        strings.forEach(printString);

        User sarahUser = new User("Sarah");
        User jackUser = new User("Jack");
        User maryUser = new User("Mary");
        User johnUser = new User("John");

        List<User> users = Arrays.asList(sarahUser, jackUser, maryUser, johnUser);
        List<String> names = new ArrayList<>();
        //Function.apply takes in one type and returns another
        //NOTE - don't need to include types; compiler infers that
        //this shortening is called METHOD REFERENCE
        Function<User, String> toName = u -> u.getName();
        for (User u: users) {
            String name = toName.apply(u);
            names.add(name);
        }

        //use the below variables to avoid the below possible confusion
        //Consumer<User> userAction = u -> System.out.println(u);
        //users.forEach(userAction);
        //names.forEach(printString);
        //careful with below
        users.forEach(u -> System.out.println(u));
        names.forEach(u -> System.out.println(u));

        }


}
