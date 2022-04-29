package com.simple.crudapi.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.crudapi.dto.Trade;
import com.simple.crudapi.service.TradeService;

@Service
public class TradeProcessor implements Processor {

	@Autowired
	private TradeService service;

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		service.addTrade(exchange.getIn().getBody(Trade.class));
	}

}