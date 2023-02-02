package com.hub.exchangerate.service.impl;

import com.hub.exchangerate.model.entity.ExchangeEntity;
import com.hub.exchangerate.model.mapper.ExchangeMapper;
import com.hub.exchangerate.model.repository.ExchangeRepository;
import com.hub.exchangerate.service.ExchangeService;
import com.hub.exchangerate.model.dto.ExchangeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;

    @Override
    public ExchangeDto.Response getExchange(ExchangeDto.Request request) {

        ExchangeDto.Response response = new ExchangeDto.Response();
        Optional<ExchangeEntity> exchangeEntityOptional = exchangeRepository.findTopByBaseCurrencyAndFinalCurrency(request.getOriginCurrency(), request.getFinalCurrency());

        if (exchangeEntityOptional.isPresent()) {
            ExchangeEntity exchangeEntity = exchangeEntityOptional.get();
            response.setInitialAmount(request.getAmount());
            response.setFinalAmount(request.getAmount() * exchangeEntity.getExchangeType());
            response.setBaseCurrency(exchangeEntity.getBaseCurrency());
            response.setFinalCurrency(exchangeEntity.getFinalCurrency());
            response.setExchangeType(exchangeEntity.getExchangeType());

            return response;
        }

        return null;

    }

    @Override
    public List<ExchangeDto.Exchange> findAll() {

        List <ExchangeEntity> entityList = exchangeRepository.findAll();
        List <ExchangeDto.Exchange> exchangeList = new ArrayList<>();

        for (ExchangeEntity exchangeEntity: entityList){
            exchangeList.add(ExchangeMapper.INSTANCE.toDto(exchangeEntity));
        }

        return exchangeList;

    }

    @Override
    public ExchangeDto.Exchange updateById(Double exchangeType, Integer id) {

        Integer result = exchangeRepository.setExchangeTypeById(exchangeType, id);
        Optional<ExchangeEntity> exchangeEntity = exchangeRepository.findById(id);

        return (result > 0 && exchangeEntity.isPresent() ? ExchangeMapper.INSTANCE.toDto(exchangeEntity.get()) : null );

    }

    @Override
    public ExchangeDto.Exchange updateExchangeRate(ExchangeDto.Exchange exchange) {

        Integer result = exchangeRepository.setExchangeTypeByByBaseCurrencyAndFinalCurrency(exchange.getExchangeType(),
                                                                                                exchange.getBaseCurrency(),
                                                                                                exchange.getFinalCurrency());
        Optional<ExchangeEntity> exchangeEntity = exchangeRepository.findTopByBaseCurrencyAndFinalCurrency(exchange.getBaseCurrency(), exchange.getFinalCurrency());

        return (result > 0 && exchangeEntity.isPresent() ? ExchangeMapper.INSTANCE.toDto(exchangeEntity.get()) : null );

    }

}
