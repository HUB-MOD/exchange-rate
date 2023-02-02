package com.hub.exchangerate.model.repository;

import com.hub.exchangerate.model.entity.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRepository extends JpaRepository <ExchangeEntity, Integer> {

    Optional<ExchangeEntity> findTopByBaseCurrencyAndFinalCurrency(String baseCurrency, String finalCurrency);

    @Modifying
    @Query("UPDATE ExchangeEntity ee SET ee.exchangeType = ?1 WHERE ee.baseCurrency = ?2 AND ee.finalCurrency = ?3")
    Integer setExchangeTypeByByBaseCurrencyAndFinalCurrency(Double exchangeType, String baseCurrency, String finalCurrency);

    @Modifying
    @Query("UPDATE ExchangeEntity ee SET ee.exchangeType = ?1 where ee.id = ?2")
    Integer setExchangeTypeById(Double exchangeType, Integer id);

}
