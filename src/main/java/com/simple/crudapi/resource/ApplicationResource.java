package com.simple.crudapi.resource;

import org.springframework.stereotype.Component;
import com.simple.crudapi.dto.Trade;
import com.simple.crudapi.processor.TradeProcessor;
import com.simple.crudapi.service.TradeService;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@Component
public class ApplicationResource extends RouteBuilder {

	@Autowired
	private TradeService service;

	@BeanInject
	private TradeProcessor addTradeProcessor;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		rest().get("/democrud").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.setBody(constant("Welcome to Soumya's first REST API Project")).endRest();
		restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);
		rest().put("/addTrade").consumes(MediaType.APPLICATION_JSON_VALUE).type(Trade.class).outType(Trade.class)
				.route().process(addTradeProcessor).endRest();
		rest().get("/getTrades").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(() -> service.getTrades())
				.endRest();
	}

}
