package com.example.testspringboot3reactivejava21project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@RestController
@Slf4j
public class TestController {


    @GetMapping("test/get")
    public Mono<String> get() {
        log.info("get test called");


        return Mono.defer(() ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("waiting complete");
            return Mono.just("test");
        }).subscribeOn(Schedulers.boundedElastic());

//        return Mono.fromCallable(()->{
//            Thread.sleep(2000);
//            log.info("waiting complete");
//            return "test";
//        });
//        return Mono.just("Hello Test");
//        return Mono.fromCallable(()->"test");
    }
}
