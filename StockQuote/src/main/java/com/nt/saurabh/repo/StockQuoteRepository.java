package com.nt.saurabh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.saurabh.model.StockQuote;

public interface StockQuoteRepository extends JpaRepository<StockQuote, Integer> {

}
