package org.dominicjesse.javaUtilFunctionIntro;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;

public class PrimitiveLambdas {

    //NOTE - need to use primitive lambdas to save
    //up to 60x over normal wrappers
    public static void runExamples() {
        System.out.println();
        IntSupplier intSup = () -> 10;
        int getInt = intSup.getAsInt();
        System.out.println(getInt);

        DoubleToIntFunction floorF = d -> (int)Math.floor(d);
        int fInt = floorF.applyAsInt(3.1415926535);
        System.out.println(fInt);
    }

}
