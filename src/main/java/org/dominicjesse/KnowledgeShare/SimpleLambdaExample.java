package org.dominicjesse.KnowledgeShare;

import org.dominicjesse.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleLambdaExample {

    public static void runExample() {
        User p1 = new User("Alice", 41, 500000);
        User p2 = new User("Brian", 59, 1500000);
        User p3 = new User("Chelsea", 46, 75000);
        User p4 = new User("David", 48, 100000);
        User p5 = new User("Erica", 37, 300000);
        User p6 = new User("Francisco", 18, 50000);
        List<User> users = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));

        Predicate<User> userOver35 = u -> u.getAge() >= 35;
        Predicate<User> userSmallRetirement = u -> u.getNetWorth() <= 250000;
        Function<User, String> getName = u -> u.getName();
        Consumer<String> printName = System.out::println;

        //print names of people who need financial advice
        users.stream()
                .filter(userOver35)
                .filter(userSmallRetirement)
                .map(getName)
                .forEach(printName);

        System.out.println();

        Predicate<User> usersOver40 = u -> u.getAge() >= 40;
        Predicate<User> haveMoney = u -> u.getNetWorth() >= 400000;
        Function<User, Double> getMoney = u -> u.getNetWorth();
        //A BINARY OPERATOR IS A TYPE OF FUNCTION
        BinaryOperator<Double> sumMoney = (a, b) -> a + b;

        //get total possible investment funds
        Optional<Double> possibleInvestment = users.stream()
                .filter(u -> u.getAge() >= 40)
                .filter(u -> u.getNetWorth() >= 400000)
                .map(u -> u.getNetWorth())
                .reduce((a, b) -> a + b);

        System.out.println(possibleInvestment.get());
    }


}
