package com.hellokoding.restfulapi.stock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/stocks")
@Slf4j
@RequiredArgsConstructor
public class StockAPI {
    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> findAll() {
        return ResponseEntity.ok(stockService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.save(stock));
    }

    @GetMapping("/{stockId}")
    public ResponseEntity<Stock> findById(@PathVariable Long stockId) {
        Optional<Stock> stock = stockService.findById(stockId);
        if (!stock.isPresent()) {
            log.error("StockId " + stockId + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{stockId}")
    public ResponseEntity<Stock> updatePriceOfAStock(@PathVariable Long stockId, @Valid @RequestBody Stock stock) {
        if (!stockService.findById(stockId).isPresent()) {
            log.error("StockId " + stockId + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stockService.save(stock));
    }
}
