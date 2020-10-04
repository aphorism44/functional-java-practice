package org.dominicjesse.javaLambdas;

import org.dominicjesse.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class ChainLambdas {

    public static void runExamples() {
        System.out.println();
        Consumer<String> c1 = s -> System.out.println("c1 consumes " + s);
        Consumer<String> c2 = s -> System.out.println("c2 consumes " + s);
        Consumer<String> c3 = c1.andThen(c2);
        c3.accept("chain these");

        Predicate<String> isNull = s -> s == null;
        System.out.println("For null= " + isNull.test(null));
        System.out.println("For not null= " + isNull.test(""));

        Predicate<String> pEmpty = s -> s.isEmpty();
        System.out.println("For empty= " + pEmpty.test(""));
        System.out.println("For not empty= " + pEmpty.test("null"));

        Predicate<String> notNullOrEmpty = isNull.negate().and(pEmpty.negate());
        System.out.println("For null: " + notNullOrEmpty.test(null));
        System.out.println("For empty: " + notNullOrEmpty.test(""));
        System.out.println("For string: " + notNullOrEmpty.test("yadda"));

        List<String> strings =
                new ArrayList(Arrays.asList("one", "two", "three", "four", "five"
                , "six", "seven", "eight", "nine"));
        Comparator<String> cmp = (s1, s2) -> s1.compareTo(s2);
        strings.sort(cmp);
        System.out.println(strings);

        Comparator<String> cmp2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        strings.sort(cmp2);
        System.out.println(strings);

        //below is preferred to above
        Function<String, Integer> strLen = s -> s.length();
        Comparator<String> cmp3 = Comparator.comparing(strLen);
        strings.sort(cmp3);
        System.out.println(strings);

        //below is more efficient (primitives)
        ToIntFunction<String> sti = s -> s.length();
        Comparator<String> cmp4 = Comparator.comparingInt(sti);
        strings.sort(cmp4);
        System.out.println(strings);

        User sarahUser = new User("Sarah", 28);
        User jackUser = new User("James", 35);
        User maryUser = new User("Mary", 33);
        User johnUser = new User("John", 25);
        User johnUser2 = new User("John", 24);
        List<User> users = Arrays.asList(sarahUser, jackUser, maryUser, johnUser, johnUser2);

        Comparator<User> cmpName = Comparator.comparing(u -> u.getName());
        Comparator<User> ageCmp = Comparator.comparing(u -> u.getAge());
        Comparator<User> chainCmp = cmpName.thenComparing(ageCmp);
        users.sort(chainCmp);
        users.forEach(u -> System.out.println(u.getName() + ", " + u.getAge()));
        Comparator<User> chainCmpRev = chainCmp.reversed();
        users.sort(chainCmpRev);
        System.out.println();
        users.forEach(u -> System.out.println(u.getName() + ", " + u.getAge()));

    }

}
