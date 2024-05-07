package HashTesting;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class HashTesting {

    /**
     * ArrayList where all experiments are stored
     */
    private ArrayList<HashFamily> experiments = new ArrayList<HashFamily>();

    public HashTesting(HashFamily... experiments) {
        for (HashFamily experiment : experiments) this.experiments.add(experiment);
    }

    public void test() {
        int index = 1;
        for (HashFamily experiment : experiments) {
            try {
                PrintWriter writer = new PrintWriter(("output-"+index+".txt"), "UTF-8");

                if (experiment.x.size() < 1) experiment.fillAll();
                int tableSize = experiment.x.size();
                int collisions = experiment.calcCollisions();
                double collisionsProbability = (double) collisions / tableSize;
                writer.write(experiment.toString());

                System.out.println("Experiment: " + index);
                System.out.println("Size: " + tableSize );
                System.out.println("Collisions: " + collisions );
                System.out.println("Collision probability: " + String.valueOf(collisionsProbability) +"\n");

                writer.close();
                index++;
            } catch (FileNotFoundException e) {
                System.out.println("File not Found");
            } catch (UnsupportedEncodingException e) {
                System.out.println("Unsupported Encoding");
            }
        }
    }
}
