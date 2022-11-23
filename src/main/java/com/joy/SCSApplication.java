package com.joy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
// 引入消息的产生端和消费端
@EnableBinding({Source.class, Sink.class})
public class SCSApplication {
    public static void main(String[] args) {
        SpringApplication.run(SCSApplication.class,args);
    }
//    引入原子类实例
    @Bean
    public AtomicInteger index(){
        return  new AtomicInteger(0);
    }
}
