package com.nt.saurabh.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.saurabh.model.StockQuote;

@Component 
public class JsonUtil {

	public String toJson(StockQuote sq) {
		try {
			return new ObjectMapper().writeValueAsString(sq);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public StockQuote fromJson(String json) {
		try {
			return new ObjectMapper().readValue(json, StockQuote.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
