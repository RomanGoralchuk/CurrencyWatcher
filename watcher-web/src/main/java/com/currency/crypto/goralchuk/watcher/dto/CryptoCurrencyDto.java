package com.currency.crypto.goralchuk.watcher.dto;

import com.currency.crypto.goralchuk.watcher.entity.Symbol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoCurrencyDto {
    private Long id;
    private Symbol symbol;
}
