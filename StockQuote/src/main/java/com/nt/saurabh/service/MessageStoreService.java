package com.nt.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.saurabh.model.StockQuote;
import com.nt.saurabh.repo.StockQuoteRepository;

@Service
public class MessageStoreService {

	@Autowired
	private StockQuoteRepository repository;
	
	public void addStockData(StockQuote sq) {
		repository.save(sq);
	}
	
	public List<StockQuote> getAllStockQuotes() {
		return repository.findAll();
	}
}