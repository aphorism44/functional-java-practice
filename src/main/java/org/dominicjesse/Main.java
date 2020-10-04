package org.dominicjesse;


import org.dominicjesse.javaCollectStreams.LambdaDataProcessing;
import org.dominicjesse.javaCollectStreams.Lambdas;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        //below 4 examples: Pluralsight course
        //"Using Lambda Expressions in Java Code" (package: javaLambdas)
        //by Jose Paumard
        /*
        BasicLambdaExample.runExamples();
        JavaLambdas.runExamples();
        PrimitiveLambdas.runExamples();
        ChainLambdas.runExamples();
        */
        //below examples: Pluralsight course
        //"From Collections to Streams in Java 8 using Lambda Expressions" (package: javaCollectStreams)
        //by Jose Paumard
        Lambdas.runExamples();
        LambdaDataProcessing.runExamples();

    }
}
