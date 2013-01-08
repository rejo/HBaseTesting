/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hbaseclienttest;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import util.RandomInsertList;

/**
 *
 * @author rj
 */
public class PutXRecs implements HBaseExecution {

    private int _x = 0;
    private String _zk_quorum = null;

    public PutXRecs(int x, String zk_quorum) {
        _x = x;
        _zk_quorum = zk_quorum;
    }

    private PutXRecs() {}
    
    @Override
    public void run() throws IOException {
        Configuration conf = HBaseConfiguration.create();

        conf.set("hbase.zookeeper.quorum", _zk_quorum);
        HTable table = new HTable(conf, "testtable");
        Iterator<Integer> it = RandomInsertList.generateXRandomInts(10000000);
        for (int i = 0; i < _x; i++) {
            int val = it.next();
            Put put = new Put(Bytes.toBytes("row" + val));
            put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"), Bytes.toBytes("val" + val));
            put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual2"), Bytes.toBytes("val" + val+1));
            table.put(put);
        }
    }
}
