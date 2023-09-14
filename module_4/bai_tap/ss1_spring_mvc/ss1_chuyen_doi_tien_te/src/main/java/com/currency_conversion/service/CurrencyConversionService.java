package com.currency_conversion.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService {
    @Override
    public double convertUSDToVND(int amountOfMoney) {
        return amountOfMoney * 24190;
    }
  }
