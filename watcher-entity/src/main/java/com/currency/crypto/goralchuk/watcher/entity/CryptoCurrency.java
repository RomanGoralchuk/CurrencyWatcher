package com.currency.crypto.goralchuk.watcher.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect
@Entity
@Table(name = "crypto_currency")
public class CryptoCurrency {
    @Id
    @Column(name = "currency_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private Symbol symbol;
    @JsonProperty("price_usd")
    private double priceUsd;
}
