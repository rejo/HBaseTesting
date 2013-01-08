/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.util.Random;
/**
 *
 * @author rj
 */
public class RandomKey {
    private static int maxKey;
    private RandomKey() {}
    public RandomKey(int maxKey) {
        RandomKey.maxKey = maxKey;
    }
    private static final Random generator = new Random(System.currentTimeMillis());
    public String get() {
        return "row" + generator.nextInt(maxKey);
    }
    
}
