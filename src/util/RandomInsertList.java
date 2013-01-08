/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author rj
 */
public class RandomInsertList {

    public static Iterator<Integer> generateXRandomInts(int numberOfRows) {

        ArrayList<Integer> l = new ArrayList();
        for (int i = 0; i < numberOfRows; i++) {
            l.add(i);
        }
        Collections.shuffle(l);
        return l.iterator();
    }
}
