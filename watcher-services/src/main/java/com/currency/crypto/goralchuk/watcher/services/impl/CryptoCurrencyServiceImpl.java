package com.currency.crypto.goralchuk.watcher.services.impl;

import com.currency.crypto.goralchuk.watcher.dao.CryptoCurrencyRepository;
import com.currency.crypto.goralchuk.watcher.entity.CryptoCurrency;
import com.currency.crypto.goralchuk.watcher.services.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CryptoCurrencyServiceImpl implements CryptoCurrencyService {

    @Autowired
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    @Override
    public CryptoCurrency saveOrUpdate(CryptoCurrency entity) {
        return cryptoCurrencyRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CryptoCurrency> findById(Long id) {
        return cryptoCurrencyRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        cryptoCurrencyRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CryptoCurrency> findAll() {
        return cryptoCurrencyRepository.findAll();
    }
}
