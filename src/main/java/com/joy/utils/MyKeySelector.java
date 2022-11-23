package com.joy.utils;

import org.springframework.cloud.stream.binder.PartitionSelectorStrategy;
import org.springframework.stereotype.Component;

@Component
public class MyKeySelector implements PartitionSelectorStrategy {
    @Override
    public int selectPartition(Object key, int partitionCount) {
        return Integer.parseInt(key.toString())% partitionCount;
    }
}
