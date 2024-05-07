import HashTesting.HashExperiment;
import HashTesting.HashTesting;

public class Main {

    public static void main(String[] args) {
    
        HashTesting test = new HashTesting(
            new HashExperiment(5, 1, 0, 5, 5, 4),
            new HashExperiment(6, 1, 0, 6, 6, 4)
        );

        test.test();
    }
}