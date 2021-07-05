package com.nt.saurabh.consumer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nt.saurabh.model.StockQuote;
import com.nt.saurabh.service.MessageStoreService;
import com.nt.saurabh.util.JsonUtil;

@Component
public class ConsumerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsumerService.class);
	
	@Autowired
	private MessageStoreService service;

	@Autowired
	private JsonUtil util;

	@KafkaListener(topics = "${my.app.tpcName}",groupId = "groupId")
	public void readData(String message) {
		LOG.info("DATA AT CONSUMER {}",message);
		StockQuote sq =  util.fromJson(message);
		sq.setServiceDate(new Date());
		service.addStockData(sq);
	}
}
