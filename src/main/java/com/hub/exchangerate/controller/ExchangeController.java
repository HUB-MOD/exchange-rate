package com.hub.exchangerate.controller;

import com.hub.exchangerate.service.ExchangeService;
import com.hub.exchangerate.model.dto.ExchangeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange")
public class ExchangeController {

    @Autowired
    private final ExchangeService exchangeService;

    @GetMapping(value = "/currency", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ExchangeDto.Response>>  getExchange(@RequestBody ExchangeDto.Request request) {
        return ResponseEntity.ok(Optional.ofNullable(exchangeService.getExchange(request)));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<List<ExchangeDto.Exchange>>> getAll() {
        return ResponseEntity.ok(Optional.ofNullable(exchangeService.findAll()));
    }

    @PutMapping(value = "/update/{id}/{exchangeType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ExchangeDto.Exchange>> updateExchangeRate(@PathVariable(name = "id") Integer id,
                                                                            @PathVariable(name = "exchangeType") Double exchangeType) {
        return ResponseEntity.ok(Optional.ofNullable(exchangeService.updateById(exchangeType, id)));
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ExchangeDto.Exchange>> updateExchangeRate(@RequestBody ExchangeDto.Exchange exchange) {
        return ResponseEntity.ok(Optional.ofNullable(exchangeService.updateExchangeRate(exchange)));
    }
}
