package com.nt.saurabh.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.nt.saurabh.model.StockQuote;
import com.nt.saurabh.util.JsonUtil;

@Component
public class ProducerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProducerService.class);
	
	@Value("${my.app.tpcName}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, String> template;
	
	@Autowired
	private JsonUtil util;

	public void sendData(StockQuote sq) {
		String message = util.toJson(sq);
		LOG.info("AT PRODUCER RECEIVED {}",message);
		template.send(topic, message);
	}
}
