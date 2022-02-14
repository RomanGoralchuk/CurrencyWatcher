package com.currency.crypto.goralchuk.watcher.controllers;

import com.currency.crypto.goralchuk.watcher.entity.CryptoCurrency;
import com.currency.crypto.goralchuk.watcher.entity.Note;
import com.currency.crypto.goralchuk.watcher.services.CryptoCurrencyService;
import com.currency.crypto.goralchuk.watcher.services.NoteService;
import com.currency.crypto.goralchuk.watcher.utils.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;

    @GetMapping(value = "")
    public ResponseEntity<Message> notes() {
        Message message = new Message("Place your bet!");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        Optional<CryptoCurrency> existCurrencyValue = cryptoCurrencyService.findById(note.getCurrencyId());
        if (existCurrencyValue.isEmpty()) {
            log.debug("Currency was not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        note.setCurrencyPriceUsd(existCurrencyValue.get().getPriceUsd());
        noteService.saveOrUpdate(note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }
}
