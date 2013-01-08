HBaseTesting
============
This tool is very basic.  It will randomize the key before loading 10M rows of data in order to distribute amongst Region Servers.  It will also randomize reads for a long period of time.  Right now, requires a code change in the Main class to switch from reads or writes.

Should create a table in hbase shell in order to use for data loads and queries:

create {NAME => 'testtable', FAMILIES => [{NAME => 'colfam1', BLOOMFILTER => 'NONE', REPLICATION_SCOPE => '0', VERSIONS => '3', COMPRESSION => 'SNAPPY', MIN_VERSIONS => '0', TTL => '2147483647', BLOCKSIZE => '65536', IN_MEMORY => 'false', BLOCKCACHE => 'true'}]}

Write tests are commented out by default.  Uncomment them to run a load of X tables and comment the read portion.  Vice versa in order to perform a read test.

Observe cloudera manager, region server web uis, response times, etc.  Hopefully loading is distributed due to the randomized nature of the data loads and data reads.
