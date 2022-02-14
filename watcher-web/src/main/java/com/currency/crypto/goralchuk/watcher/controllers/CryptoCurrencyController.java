package com.currency.crypto.goralchuk.watcher.controllers;

import com.currency.crypto.goralchuk.watcher.dto.CryptoCurrencyDto;
import com.currency.crypto.goralchuk.watcher.entity.CryptoCurrency;
import com.currency.crypto.goralchuk.watcher.services.CryptoCurrencyService;
import com.currency.crypto.goralchuk.watcher.utils.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@EnableAutoConfiguration
@RequestMapping("/currencies")
public class CryptoCurrencyController {

    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "")
    public ResponseEntity<List<CryptoCurrencyDto>> getAllCurrency() {
        List<CryptoCurrency> currencyList = cryptoCurrencyService.findAll();
        List<CryptoCurrencyDto> currencyListDto = MapperUtil.convertList(currencyList, this::convertToCurrencyDto);
        if (currencyList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(currencyListDto, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CryptoCurrency> findCurrencyByID(@PathVariable("id") Long id) {
        Optional<CryptoCurrency> currency = cryptoCurrencyService.findById(id);
        if (currency.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currency.get(), HttpStatus.OK);
    }

    private CryptoCurrencyDto convertToCurrencyDto(CryptoCurrency currency) {
        return modelMapper.map(currency, CryptoCurrencyDto.class);
    }
}
