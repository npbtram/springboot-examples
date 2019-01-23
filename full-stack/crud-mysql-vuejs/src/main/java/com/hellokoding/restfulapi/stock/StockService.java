package com.hellokoding.restfulapi.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class StockService {
    private final StockRespository stockRespository;

    public List<Stock> findAll() {
        return stockRespository.findAll();
    }

    public Optional<Stock> findById(Long id) {
        return stockRespository.findById(id);
    }

    public Stock save(Stock stock) {
        return stockRespository.save(stock);
    }
}
