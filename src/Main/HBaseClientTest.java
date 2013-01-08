package Main;

import hbaseclienttest.GetXRecsRandomly;
import hbaseclienttest.HBaseExecution;
import hbaseclienttest.PutXRecs;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rj
 */
public class HBaseClientTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        //PutXrecs(number_of_rows, zookeeper_quorum)
//        HBaseExecution hbe = new PutXRecs(10000000, "earth"); 
//        hbe.run();
        HBaseExecution hbe = new GetXRecsRandomly(1000000);
        hbe.run();

        
    }
}
