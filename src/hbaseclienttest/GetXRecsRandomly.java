/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hbaseclienttest;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import util.RandomKey;

/**
 *
 * @author rj
 */
public class GetXRecsRandomly implements HBaseExecution {

    private final int _numberOfGets;
    private final RandomKey _rk;
    private long _totalTimes = 0;
    
    public GetXRecsRandomly(int numberOfGets) {
        _numberOfGets = numberOfGets;
        _rk = new RandomKey(10000000);
    }

    private GetXRecsRandomly() {
        _numberOfGets = 0;
        _rk = new RandomKey(0);
    }

    long  beforeGet = 0;
    long  afterGet = 0;
    @Override
    public void run() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "earth");
        HTable table = new HTable(conf,"testtable");
        for(int i = 1; i <= _numberOfGets; i++) {
            Get get = new Get(Bytes.toBytes(_rk.get()));  //Randomize key retrieval
//            System.out.println(_rk.get());
            get.addColumn(Bytes.toBytes("colfam1"),Bytes.toBytes("qual1"));
            beforeGet = System.currentTimeMillis();
            Result result = table.get(get);
            afterGet = System.currentTimeMillis();
            _totalTimes+= afterGet-beforeGet;
            if (i%10000 == 0) {
                System.out.format("Avg time (%d gets): %f ms\n",i, (float)_totalTimes/i);
            }
        }
            
        System.out.format("Overall Avg time (%d gets): %f ms\n",_numberOfGets,(float)_totalTimes/_numberOfGets);
    }
}
