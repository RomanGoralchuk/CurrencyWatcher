package com.currency.crypto.goralchuk.watcher.dao;

import com.currency.crypto.goralchuk.watcher.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {
}
