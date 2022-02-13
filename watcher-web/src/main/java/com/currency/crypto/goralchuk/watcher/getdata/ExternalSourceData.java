package com.currency.crypto.goralchuk.watcher.getdata;

import com.currency.crypto.goralchuk.watcher.entity.CryptoCurrency;
import com.currency.crypto.goralchuk.watcher.services.CryptoCurrencyService;
import com.currency.crypto.goralchuk.watcher.utils.SSLUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Slf4j
@EnableScheduling
@Configuration
public class ExternalSourceData {

    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;
    @Autowired
    private Environment env;

    @Scheduled(fixedRate = 60000)
    public void updateCurrenciesValue(){
        updateValues(env.getProperty("currency.url.eth"));
        updateValues(env.getProperty("currency.url.btc"));
        updateValues(env.getProperty("currency.url.sol"));
    }

    protected void updateValues (String url){
        ObjectMapper mapper = new ObjectMapper();
        try {
            SSLUtil.turnOffSslChecking();
            CryptoCurrency[] newData = mapper.readValue(new URL(url), CryptoCurrency[].class);
            cryptoCurrencyService.saveOrUpdate(Arrays.stream(newData).findFirst().orElse(null));
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e) {
            log.error("Error get data from URL {}", e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
