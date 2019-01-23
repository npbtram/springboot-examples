package com.hellokoding.restfulapi.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRespository extends JpaRepository<Stock, Long> {
}
