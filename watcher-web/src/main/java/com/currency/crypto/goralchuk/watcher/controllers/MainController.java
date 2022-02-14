package com.currency.crypto.goralchuk.watcher.controllers;

import com.currency.crypto.goralchuk.watcher.utils.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableAutoConfiguration
public class MainController {

    @GetMapping(value ="")
    public ResponseEntity<Message> home() {
        Message message = new Message("Hello broker!");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
