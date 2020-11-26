package org.dominicjesse;


import org.dominicjesse.KnowledgeShare.SimpleLambdaExample;
import org.dominicjesse.javaCollectStreams.ReduceSimulation;
import org.dominicjesse.javaCollectStreams.Streams;
import org.dominicjesse.javaFunctional.ReuseFunctions;
import org.dominicjesse.javaFunctional.RewriteSimpleExample;

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
        /*
        TestFakeComparator.runExamples();
        LambdaReview.runExamples();
        TestFakePredicate.runExamples();
        CollectionsLambda.testListExamples();
        CollectionsLambda.testMapExamples();
        CollectionsLambda.testLiveCode();
        ReduceSimulation.runExamples();
        Streams.runStreamExamples();
        Streams.runMapFilterReduce();
        SimpleLambdaExample.runExample();
        */
        //below examples: Pluralsight course
        //"Applying Functional Programming Techniques in Java" (package: javaFunctional)
        //by Esteban Herrera
        RewriteSimpleExample.runExamples();
        ReuseFunctions.runExamples();



    }
}
