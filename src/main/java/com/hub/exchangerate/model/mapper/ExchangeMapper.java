package com.hub.exchangerate.model.mapper;

import com.hub.exchangerate.model.entity.ExchangeEntity;
import com.hub.exchangerate.model.dto.ExchangeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeMapper {

    ExchangeMapper INSTANCE = Mappers.getMapper(ExchangeMapper.class);

    ExchangeDto.Exchange toDto(ExchangeEntity exchangeEntity);
}
