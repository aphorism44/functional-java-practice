package org.dominicjesse.javaCollectStreams;

import org.dominicjesse.models.User;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void runStreamExamples() {
        Stream.empty();
        Stream.of("one");
        Stream.of(1,2,3);
        //takes supplier
        Stream<String> str1 = Stream.generate(() -> "one");
        //takes unary operator; creates "+", "++", "+++", etc.
        Stream<String> str2 = Stream.iterate("+", s -> s + "+").limit(5);
        //random streams
        IntStream intStr = ThreadLocalRandom.current().ints();
        DoubleStream dStr = ThreadLocalRandom.current().doubles();

        //creating streams
        IntStream helloStream = "hello".chars();
        //Stream<String> words =
        //        Pattern.compile("[^\\p{javaLetter}]")
        //        .splitAsStream(book);
       // Stream<String> lines = Files.lines(path);

        Stream.Builder<String> stBuilder = Stream.builder();
        stBuilder.add("one").add("two").add("three");
        stBuilder.accept("four");
        Stream<String> stStream = stBuilder.build();
        stStream.forEach(System.out::println);
        //cannot add to Builder after it's been built
    }

    public static void runMapFilterReduce() {
        User p1 = new User("Alice", 23);
        User p2 = new User("Brian", 56);
        User p3 = new User("Chelsea", 46);
        User p4 = new User("David", 28);
        User p5 = new User("Erica", 37);
        User p6 = new User("Francisco", 18);
        List<User> users = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));
        //Stream<User> userStream = users.stream();
        users.stream()
                //function to Stream<Integer>
                .map(p -> p.getAge())
                //consumer - PEEK for debugging; is intermediate
                .peek(System.out::println)
                //predicate to Stream<Integer>
                .filter(age -> age > 20)
                //consumer - forEach is terminal
                .forEach(System.out::println);
        System.out.println();
        //keep users to end
        users.stream()
                .filter(u -> u.getAge() > 20)
                .forEach(System.out::println);
        System.out.println();
        //get halfway
        users.stream()
                .skip(2)
                .limit(3)
                .filter(u -> u.getAge() > 20)
                .forEach(System.out::println);
        System.out.println();
        //match reductions - terminal predicate, return booleans; short circuit
        //anyMatch, allMatch, noneMatch
        boolean anyOver = users.stream()
                .anyMatch(u -> u.getAge() > 20);
        System.out.println(anyOver);
        System.out.println();
        //find reductions - return Optionals
        //findFirst, findAny
        //WARN - unlike class, not taking arguments - FILTER first
        Optional<User> found = users.stream()
                .findAny();
        System.out.println();
        //reduce with identity
        int ageSum = users.stream()
                //Binary Operator
                .map(u -> u.getAge())
                .reduce(0, (u1, u2) -> u1 + u2);
        System.out.println(ageSum);
        System.out.println();
        //reduce no identity = use optional
        Optional<Integer> optionalSum = users.stream()
                .map(u -> u.getAge())
                .reduce((u1, u2) -> u1 + u2);
        System.out.println(optionalSum.get());
        System.out.println();
        //EXTRA - for parallel operations
        List<Integer> ages = users.stream()
                .reduce(
                        new ArrayList<Integer>()
                        , (list, u) -> { list.add(u.getAge()); return list; }
                        , (list1, list2) -> {list1.addAll(list2); return list1; }
                );
        ages.forEach(System.out::println);




    }
}
