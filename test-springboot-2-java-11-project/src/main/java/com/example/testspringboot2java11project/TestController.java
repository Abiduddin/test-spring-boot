package com.example.testspringboot2java11project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {


    @GetMapping("test/get")
    public String get() throws InterruptedException {
        log.info("testing get request");
        Thread.sleep(2000);
        return "test";
    }
}
