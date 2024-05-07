import HashTesting.HashFamily;
import HashTesting.HashTesting;

public class Main {

    public static void main(String[] args) {
    
        /**
         * H13
         */
        // T12 Hash Family
        HashFamily exp1 = new HashFamily(5,1,0,5,5,4);
        exp1.fillOne(2, 3);
        HashTesting test = new HashTesting(
            exp1,
            new HashFamily(5, 1, 0, 5, 5, 4),
            new HashFamily(6, 1, 0, 6, 6, 4)
        );
        test.test();

        /**
         * H14
         */

    }
}