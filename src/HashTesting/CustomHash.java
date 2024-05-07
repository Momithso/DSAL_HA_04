package HashTesting;

public class CustomHash {

    /**
     * Value
     */
    public int val, a, b, mod1, mod2;

    /**
     * Creates a custom Hash Object
     * @param val
     */
    public CustomHash(int val, int a, int b, int mod1, int mod2) {
        this.val = val;
        this.a = a;
        this.b = b;
        this.mod1 = mod1;
        this.mod2 = mod2;
    }

     /**
     * Universal hash family
     * h_{a,b}(x) = (((ax+b) % mod1) mod2)
     * Bsp:
     * h_{1,0}(2) = (((1*2+0) % 5) 4) = 2
     * @param val Input String
     * @param a a of hash family
     * @param b b of hash family
     * @param mod1 Value for modulo one
     * @param mod2 Value for modulo two
     * @return
     */
    private int hash() {
        return (((a*val + b) % mod1) % mod2);
    }

    /**
     * Gets the hashed value
     * @param val Input String
     * @param a a of hash family
     * @param b b of hash family
     * @param mod1 Value for modulo one
     * @param mod2 Value for modulo two
     * @return
     */
    public int getHash() {
        return hash();
    }

    /**
     * Universal hash family
     * h_{a,b}(x) = (((ax+b) % mod1) mod2)
     * Bsp:
     * h_{1,0}(2) = (((1*2+0) % 5) 4) = 2
     * @param toHash Input String
     * @param a a of hash family
     * @param b b of hash family
     * @param mod1 Value for modulo one
     * @param mod2 Value for modulo two
     * @return Returns a CustomHash Object
     */
    public static CustomHash hashCustom(int toHash, int a, int b, int mod1, int mod2) {
        return new CustomHash(toHash, a, b, mod1, mod2);
    }

    /**
     * Hash Int
     */
    public static int hashInt(int toHash, int a, int b, int mod1, int mod2) {
        return new CustomHash(toHash,a,b,mod1,mod2).getHash();
    }
}
