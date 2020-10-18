package org.dominicjesse.javaCollectStreams;

import java.util.*;
import java.util.function.*;

import org.dominicjesse.models.City;
import org.dominicjesse.models.Person;
import org.dominicjesse.models.User;

public class CollectionsLambda {

    public static void testListExamples() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Sarah", 28));
        users.add(new User("James", 35));
        users.add(new User("Mary", 33));
        users.add(new User("John", 25));
        users.add(new User("John", 24));
        //removeIf - takes Predicate
        users.removeIf(u -> u.getAge() > 30);
        //forEach -takes Consumer
        users.forEach(System.out::println);
        //replaceAll - takes UnaryOperator
        ArrayList<Integer> nats = new ArrayList<>();
        nats.add(1);
        nats.add(2);
        nats.add(3);
        nats.add(4);
        nats.replaceAll(a -> a * a);
        nats.forEach(System.out::println);
        //sort - takes Comparator
        nats.sort((a, b) -> b - a);
        nats.forEach(System.out::println);
        //can sort while creating complex comparator
        users.sort(
                Comparator.comparing(User::getName)
                .thenComparing(User::getAge)
        );
        users.forEach(u -> System.out.println(u.getName() + "," + u.getAge()));
    }

    public static void testMapExamples() {
        Map<String, Double> prices = new HashMap<>();
        prices.put("H7263", 2.34);
        prices.put("S9732", 3.44);
        prices.put("J8009", 9.34);
        prices.put("A7832", 8.27);
        prices.put("L0123", 7.14);
        //forEach takes BiConsumer
        BiConsumer<String, Double> printMap = (k, v) -> System.out.println(k + ":" + v);
        prices.forEach((i, p) -> prices.put(i, p * .9));
        prices.forEach(printMap);
        //prices.forEach((k, v) -> System.out.println(k + ":" + v));

        double def = prices.getOrDefault("L9283", 2.12);
        System.out.println(def);
        prices.putIfAbsent("H7263", 6.66);
        System.out.println(prices.get("H7263"));

        Map<City, List<Person>> cityListMap = new HashMap<>();
        City chicago = new City("Chicago");
        City boston = new City("Boston");
        List<Person> personList = new ArrayList<>();
        Person maria = new Person("Maria", "Larson", 42);
        personList.add(maria);
        cityListMap.put(chicago, personList);
        Person john = new Person("John", "Smith", 33);
        cityListMap.get(chicago).add(john);
        System.out.println(cityListMap.get(chicago));
        cityListMap.putIfAbsent(boston, new ArrayList<>());
        //replace ONLY if key exists
        City phoenix = new City("Phoenix");
        cityListMap.replace(phoenix, personList, new ArrayList<>());
        //replaceAll takes BiFunction
        //can target key-value pair with remove
        cityListMap.remove(chicago, john);
        System.out.println(cityListMap.get(chicago));
        //compute* methods - often remaps - always return a value
        //compute, computeIfAbsent, merge
    }

    public static  void testLiveCode() {
        User p1 = new User("Alice", 23);
        User p2 = new User("Brian", 56);
        User p3 = new User("Chelsea", 46);
        User p4 = new User("David", 28);
        User p5 = new User("Erica", 37);
        User p6 = new User("Francisco", 18);
        List<User> people = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));

        people.forEach(System.out::println);
        people.removeIf(p  -> p.getAge() < 30);
        people.replaceAll(p -> new User(p.getName().toUpperCase(), p.getAge()));
        System.out.println();
        people.forEach(System.out::println);
        people.sort(Comparator.comparing(p -> p.getAge()));
        System.out.println();
        people.forEach(System.out::println);

        City newYork = new City("New York");
        City chicago = new City("Chicago");
        City losAngeles = new City("Los Angeles");
        Map<City, List<User>> cityMap = new HashMap<>();

        System.out.println();
        System.out.println(cityMap.getOrDefault(newYork, Collections.EMPTY_LIST));

        cityMap.putIfAbsent(newYork, new ArrayList<>());
        cityMap.get(newYork).add(p1);
        cityMap.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);

        System.out.println();
        System.out.println(cityMap.getOrDefault(newYork, Collections.EMPTY_LIST));

        Map<City, List<User>> cityMap2 = new HashMap<>();
        cityMap2.computeIfAbsent(chicago, city -> new ArrayList<>()).add(p3);
        cityMap2.computeIfAbsent(losAngeles, city -> new ArrayList<>()).add(p4);
        cityMap2.computeIfAbsent(losAngeles, city -> new ArrayList<>()).add(p5);
        cityMap2.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p6);

        System.out.println();
        System.out.println(cityMap);
        System.out.println();
        System.out.println(cityMap2);

        cityMap2.forEach(
                (city, users) ->  {
                    cityMap.merge(
                            city, users
                            , (peopleFromMap1, peopleFromMap2) -> {
                                peopleFromMap1.addAll(peopleFromMap2);
                                return peopleFromMap1;
                            });
                });

        System.out.println();
        System.out.println(cityMap);


    }

}
