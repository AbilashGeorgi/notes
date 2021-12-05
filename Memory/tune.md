# Tuning

* -Xmx2g k/m/g
* -Xms1g k/m/g
* -XX:MaxPermSize=256M - set the size of permgen (before java 8)

* -verbose:gc print to the console when a gc takes place.

* by default young generation is set to a third of heap size. If your application would have less older gen, this can be changed using argument. Oracle recommends b/w quarter and half should by young gen. 
  > -Xmn256m

* -XX:HeapDumpOnOutOfMemory - creates a heap dump on out of memory.

* Oracle VM has 3 types of collectors.
  * Serial: uses single thread to perform gc. For small datasets and single processor computers.
    > -XX:+UseSerialGC
  * Parallel: parallel gc on young generation. For larger datasets for better performance.(throughput collector) -XX:+UseParallelGC

  * Mostly Concurrent: Does most of the collection concurrent. Closest we can get to realtime.
  
    There is mark sweep and G1 collector
    > -XX:+UseConcMarkSweepGC
    
    > -XX:+UseG1GC

By default based on hardware.
java -XX:+PrintCommandLineFlags can be used to find out.