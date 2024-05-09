package HashTesting;

import java.util.ArrayList;

public class HashFamily {

    /**
     * End for Index
     */
    private int endIndex, beginA, beginB, endAB, mod1, mod2;

    /**
     * Hashes
     */
    public ArrayList<CustomHash> x = new ArrayList<CustomHash>();
    public ArrayList<CustomHash> y = new ArrayList<CustomHash>();

    /**
     * Creates an Hash Experiment that saves all possible hashes that can be created to index end
     * @param end End of index
     */
    public HashFamily(int endIndex, int beginA, int beginB, int endAB, int mod1, int mod2) {
        this.endIndex = endIndex;
        this.endAB = endAB;
        this.mod1 = mod1;
        this.mod2 = mod2;
        this.beginA = beginA;
        this.beginB = beginB;
    }

    /**
     * Fill x and y list with all possibilities for one given x and y
     * @param x
     * @param y
     */
    public void fillOne(int x, int y) {
        for (int i = beginA; i < this.endAB; i++) {
            for (int j = beginB; j < this.endAB; j++) {
                this.x.add(new CustomHash(x, i, j, mod1, mod2));
                this.y.add(new CustomHash(y, i, j, mod1, mod2));
            }
        }
    }

    /**
     * Fill x,y to all possibilities to endIndex
     */
    public void fillAll() {
        for (int x = 0; x < endIndex; x++) {
            for (int y = 0; y < endIndex; y++) {
                this.fillOne(x, y);
            }
        }
    }

    /**
     * Calculate Collisions
     */
    public int calcCollisions() {
        if (this.x.size() == 0) fillAll();
        int collisions = 0;

        for (int i = 0; i < this.x.size(); i++) {
            if (
                this.x.get(i).getHash() == this.y.get(i).getHash()
            ) collisions++;
        }
        

        return collisions;
    }

    /**
     * Calculate Collisions
     */
    public int calcCollisions(ArrayList<CustomHash> x, ArrayList<CustomHash> y) {
        int collisions = 0;

        for (int i = 0; i < x.size(); i++) {
            if (
                x.get(i).getHash() == y.get(i).getHash()
            ) collisions++;
        }
        

        return collisions;
    }

    // @Override
    // public String toString() {
    //     String res = "";
    //     res += "_____________________________\n";
    //     res += "a  b  h_{a,b}(x)  h_{a,b}(y) \n";
    //     res += "_____________________________\n";

    //     int tmp = 0;
    //     for (int i = 0; i < x.size(); i++) {
    //         CustomHash x = this.x.get(i);
    //         CustomHash y = this.y.get(i);

    //         if (tmp != y.val) {
    //             res += "_____________________________\n";
    //             res += "a  b          "+x.val+"           "+y.val+"  \n";
    //             res += "_____________________________\n";
    //         }

    //         res += x.a+"  "+x.b+"            "+x.getHash()+"          "+y.getHash()+"  \n";
    //         tmp = y.val;
    //     }

    //     for (CustomHash hash : this.x) {
    //         System.out.println(hash.val);
    //     }
        
    //     return res;
    // }

    @Override
    public String toString() {
        String res = "";
        res += "_____________________________\n";
        res += "x  y  propbability \n";
        res += "_____________________________\n";

        ArrayList<CustomHash> x = new ArrayList<CustomHash>();
        ArrayList<CustomHash> y = new ArrayList<CustomHash>();

        for (int i = 0; i < this.x.size(); i++) {
            int start = i;
            int tmp = i;

            do {
                x.add(this.x.get(tmp));
                y.add(this.y.get(tmp));
                tmp++;
                if (this.x.get(tmp).a == endAB-1 && this.x.get(tmp).b == endAB-1) {
                    x.add(this.x.get(tmp));
                    y.add(this.y.get(tmp));
                    break;
                };
            } while(true);

            double collisions = this.calcCollisions(x, y);
            double probability = Math.round((double) (collisions / x.size())*100.0) / 100.0;

            res += this.x.get(start).val+"  "+this.y.get(start).val+"  "+probability+"  \n";

            i = tmp;
            x.clear();
            y.clear();
        }
        
        return res;
    }
}
