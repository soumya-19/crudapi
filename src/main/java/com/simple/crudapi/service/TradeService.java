package com.simple.crudapi.service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.simple.crudapi.dto.Trade;
import com.simple.crudapi.resource.TradesResource;

@Service
public class TradeService {

	public Trade addTrade(Trade trade) {
		try {
			// Validating Maturity Date
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date inputDate = sdf.parse(trade.getMaturityDate());
			Date currentDate = sdf.parse(java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			int result = inputDate.compareTo(currentDate);
			if (result >= 0) {
				int index = -1;
				int maxVersion = -1;
				for (int i = 0; i <= TradesResource.singleton().alTrades.size() - 1; i++) {
					if (TradesResource.singleton().alTrades.get(i).getTradeId().equals(trade.getTradeId())) {
						if (TradesResource.singleton().alTrades.get(i).getVersion() > maxVersion) {
							maxVersion = TradesResource.singleton().alTrades.get(i).getVersion();
							index = i;
						}
					}
				}
				if (maxVersion == trade.getVersion()) {
					TradesResource.singleton().alTrades.get(index).setVersion(trade.getVersion());
					TradesResource.singleton().alTrades.get(index).setCounterParty(trade.getCounterParty());
					TradesResource.singleton().alTrades.get(index).setBookId(trade.getBookId());
					TradesResource.singleton().alTrades.get(index).setMaturityDate(trade.getMaturityDate());
					TradesResource.singleton().alTrades.get(index).setCreatedDate(trade.getMaturityDate());
					TradesResource.singleton().alTrades.get(index).setExpired(trade.getExpired());
					TradesResource.singleton().alTrades.get(index).setTradeId(trade.getTradeId());
				} else if ((maxVersion < trade.getVersion()) || index == -1 || maxVersion == -1) {
					TradesResource.singleton().alTrades.add(trade);
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return trade;
	}

	public ArrayList<Trade> getTrades() {
		return TradesResource.singleton().alTrades;
	}

}
