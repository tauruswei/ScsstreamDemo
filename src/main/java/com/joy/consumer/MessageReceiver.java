package com.joy.consumer;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    @StreamListener(Sink.INPUT)
    public void process(Object message){
        System.out.println("received message: "+message);
    }
}
