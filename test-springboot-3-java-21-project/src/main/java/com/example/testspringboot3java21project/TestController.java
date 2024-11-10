package com.example.testspringboot3java21project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {


    @GetMapping("test/get")
    public String get() throws InterruptedException {
        log.info("Testing get request");
        Thread virtulaThread = Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(2000);
                log.info("wait completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        virtulaThread.join();
        log.info("process done");
        return "test";
    }
}
