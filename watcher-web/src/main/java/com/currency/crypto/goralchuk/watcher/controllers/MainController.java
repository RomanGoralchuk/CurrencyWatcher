package com.currency.crypto.goralchuk.watcher.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/")
    String home() {
        log.error("ERROR");
        log.warn("WARN");
        log.debug("DEBUG");
        log.info("INFO");
        return "Hello broker!";
    }
}
