package org.dominicjesse.interfaces;

//import org.dominicjesse.models.Person;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

    public int compare(T t1, T t2);

    //PART 1 THENCOMPARE - return either the comparator's compare or this interface's as default
   public default Comparator<T> thenComparing(Comparator<T> cmp) {
        return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
    }

    //PART 2 - THENCOMPARE takes in a function for a type/comparable instead
    //and calls the first THENCOMPARE
    public default Comparator<T> thenComparing(Function<T, Comparable> f) {
       //Comparator<T> cmp = comparing(f);
       //return (p1, p2) -> cmp.compare(p1, p2);
        return thenComparing(comparing(f));
    }


    //COMPARING - static function that takes in function, applies it to 2 persons, and returns the comparison
    //Comparable = String and Integer; U = Person
    public static <U> Comparator<U> comparing(Function<U, Comparable> f) {
        //call above compare
        return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
    }
}
