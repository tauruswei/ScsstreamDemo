package com.joy.utils;

import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MyPartitionKeyExtractor implements PartitionKeyExtractorStrategy {
    public static final String PARTITION_PROP="partition";
    @Override
    public Object extractKey(Message<?> message) {
        return message.getHeaders().get(MyPartitionKeyExtractor.PARTITION_PROP);
    }
}
