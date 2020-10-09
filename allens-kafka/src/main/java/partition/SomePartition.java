package partition;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.record.InvalidRecordException;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

public class SomePartition implements Partitioner {


    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        List<PartitionInfo> partitionInfoList = cluster.partitionsForTopic(s);
        int numPartitions = partitionInfoList.size();
        if (bytes == null || !(o instanceof String)) {
            throw new InvalidRecordException("We expect all message to have customer name as key");
        }
        HashMap hashMap = new HashMap();

        // HashSet
        // CountDownLatch
        // ThreadPoolExecutor
        // LinkedList

        if (((String) o).equals("Some")) {
            return numPartitions;
        }
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
