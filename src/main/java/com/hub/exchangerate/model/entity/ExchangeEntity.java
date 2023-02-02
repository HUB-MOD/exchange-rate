package com.hub.exchangerate.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="exchanges")
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeEntity {
    @Id
    private Integer id;
    @Column(name="base_currency")
    private String baseCurrency;
    @Column(name="final_currency")
    private String finalCurrency;
    @Column(name="exchange_type")
    private Double exchangeType;
}
