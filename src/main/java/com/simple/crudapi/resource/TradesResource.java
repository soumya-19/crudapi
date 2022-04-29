package com.simple.crudapi.resource;

import java.util.ArrayList;

import com.simple.crudapi.dto.Trade;

public class TradesResource {

	private static TradesResource tradesResource = null;
	public ArrayList<Trade> alTrades;

	private TradesResource() {
		alTrades = new ArrayList<>();
	}

	public static TradesResource singleton() {
		if (tradesResource == null)
			tradesResource = new TradesResource();
		return tradesResource;

	}
}
