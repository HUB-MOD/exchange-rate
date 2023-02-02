package com.hub.exchangerate.service;

import com.hub.exchangerate.model.dto.ExchangeDto;

import java.util.List;

public interface ExchangeService {
    ExchangeDto.Response getExchange(ExchangeDto.Request request);
    List <ExchangeDto.Exchange> findAll();
    ExchangeDto.Exchange updateById(Double exchangeType, Integer id);
    ExchangeDto.Exchange updateExchangeRate(ExchangeDto.Exchange exchange);

}
