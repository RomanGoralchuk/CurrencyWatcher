package com.currency.crypto.goralchuk.watcher.checkdata;

import com.currency.crypto.goralchuk.watcher.entity.CryptoCurrency;
import com.currency.crypto.goralchuk.watcher.entity.Note;
import com.currency.crypto.goralchuk.watcher.services.CryptoCurrencyService;
import com.currency.crypto.goralchuk.watcher.services.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j(topic = "INTERNAL_DATA")
@EnableScheduling
@Component
public class InternalCheckData {

    @Autowired
    private NoteService noteService;
    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;
    @Autowired
    private Environment env;

    @Scheduled(fixedRate = 2000)
    public void checkNoteData() {
        double percentageIncrease = Double.parseDouble(Objects.requireNonNull(
                env.getProperty("percent.increase")));
        double percentageDecline = Double.parseDouble(Objects.requireNonNull(
                env.getProperty("percent.decline")));
        List<CryptoCurrency> currencyList = cryptoCurrencyService.findAll();

        for (final CryptoCurrency currency : currencyList) {
            double actualPrice = currency.getPriceUsd();

            List<Note> noteList = noteService.findByCurrencyId(currency.getId());
            for (final Note note : noteList) {
                double oldPrice = note.getCurrencyPriceUsd();
                double differencePercent = (actualPrice - oldPrice) / oldPrice * 100;
                String formattedDouble = String.format("%.2f", differencePercent);
                if ( percentageIncrease < differencePercent || percentageDecline > differencePercent ){
                    log.warn(
                            "Currency: " + note.getCurrencyId() +
                                    "(" + currency.getSymbol() + ")" +
                                    ", User: " + note.getUsername() +
                                    ", Change: " + formattedDouble +
                                    ", Date last registration: " + note.getDateNote()
                    );
                }
            }

        }

    }
}
