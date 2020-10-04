package org.dominicjesse.javaCollectStreams;

import org.dominicjesse.models.User;

import java.util.function.Function;

public class Lambdas {

    public static void runExamples() {

        //method references = shortened lambda version
        Function<User, Integer> getAge = u -> u.getAge();



    }

}
