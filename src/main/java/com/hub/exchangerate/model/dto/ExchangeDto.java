package com.hub.exchangerate.model.dto;

import lombok.*;

public interface ExchangeDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Exchange {
        private Integer id;
        private String baseCurrency;
        private String finalCurrency;
        private Double exchangeType;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Request {
        private Double amount;
        private String originCurrency;
        private String finalCurrency;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Response {
        private Double InitialAmount;
        private Double finalAmount;

        private String baseCurrency;
        private String finalCurrency;
        private Double exchangeType;
    }
}
