package org.dominicjesse.javaFunctional;

import org.dominicjesse.javaFunctional.orderExample.Order;
import org.dominicjesse.javaFunctional.orderExample.RewardPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RewriteSimpleExample {

    public static void runExamples() {

        //sequential vs declarative programming = how we do it vs. what we want
        List<Item> orders = new ArrayList<>();
        List<Item> shipped = new ArrayList<>();

        //sequential
        for (Item item : orders)
            if (item.isShipped)
                shipped.add(item);

        //declarative
        shipped = orders.stream()
                .filter(i -> i.isShipped)
                .collect(Collectors.toList());


        //associativity - f(g(x)) = g(f(x))

        List<RewardPoints> pointList = Arrays.asList(
                new RewardPoints(10)
                , new RewardPoints(20)
                , new RewardPoints(45)
                , new RewardPoints(90)
                , new RewardPoints(120)
        );
        Predicate<RewardPoints> moreThan40Points = rp -> rp.points > 40;
        Predicate<RewardPoints> lessThan100Points = rp -> rp.points < 100;
        List<RewardPoints> betweenList = pointList.stream()
                .filter(moreThan40Points.and(lessThan100Points))
                .collect(Collectors.toList());
        betweenList.forEach(System.out::println);



    }

    public class Item {

        public final boolean isShipped;

        public Item(boolean isShipped) {
            this.isShipped = isShipped;
        }
    }


}
