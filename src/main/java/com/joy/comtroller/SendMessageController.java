package com.joy.comtroller;

import com.joy.utils.MyPartitionKeyExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class SendMessageController {
    @Autowired
    private Source source;
    @Autowired
    private AtomicInteger atomicInteger;
    @GetMapping("send")
    public Object send(String message){
        MessageBuilder<String> messageBuilder = MessageBuilder.withPayload(message).setHeader(MyPartitionKeyExtractor.PARTITION_PROP,atomicInteger.incrementAndGet());
        source.output().send(messageBuilder.build());
        return  "message sended"+message;
    }
}
