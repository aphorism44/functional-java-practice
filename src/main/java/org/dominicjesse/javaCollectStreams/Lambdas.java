package org.dominicjesse.javaCollectStreams;

import org.dominicjesse.interfaces.Comparator;
import org.dominicjesse.models.Person;
import org.dominicjesse.models.User;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas {

    public static void runExamples() {

        //method references = shortened lambda version (learned in previous class)
        Function<User, Integer> getAge = u -> u.getAge();
        //different types of method refs:
        BinaryOperator<Integer> sum1= (i1, i2) -> i1 + i2;
        BinaryOperator<Integer> sum2= (i1, i2) -> Integer.sum(i1, i2);
        BinaryOperator<Integer> sum3 = Integer::sum;
        System.out.println(sum1.apply(7,5) + sum2.apply(7,5) + sum3.apply(7,5));

        Consumer<String> printString = System.out::println;
        printString.accept("hello method reference");

        //below is the interface exercise - see "Compatator" class in interfaces package
        //this is the initial Comparator exercise - we watch it go into the new Comparator
        //essentially, a new API
        Comparator<Person> cAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> cFName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> cLName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
        //you can create functions
        Function<Person, Integer> gAge = Person::getAge;
        Function<Person, String> gFN = Person::getFirstName;
        Function<Person, String> gLN = Person::getLastName;
        //now wrote Comparitors using the above functions, but look to new interface
        Comparator<Person> cAge2 = Comparator.comparing(Person::getAge);
        Comparator<Person> cFName2 = Comparator.comparing(Person::getFirstName);
        Comparator<Person> cLName2 = Comparator.comparing(Person::getLastName);
        //thenComparing needs interface update - takes in/returns Comparator<Person>
        Comparator<Person> personCmp = cLName2.thenComparing(cFName2);
        //now change thenComparing to take a function and comparable
        Comparator<Person> cmp = Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getAge);
    }

}
