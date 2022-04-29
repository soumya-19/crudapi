package com.simple.crudapi.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Trade {

//	Trade Id, Version, CounterParty, BookID,MaturityDate, Created Date, Expired
//	T1, 1, CP-1, B1, 20/05/2020, sysdate, N

	private String tradeId;
	private int version;
	private String counterParty;
	private String bookId;
	private String maturityDate;
	private String createdDate;
	private String Expired;

	public Trade(String tradeId, int version, String counterParty, String bookId, String maturityDate, String createdDate,
			String Expired) {
		this.tradeId = tradeId;
		this.version = version;
		this.counterParty = counterParty;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.Expired = Expired;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getExpired() {
		return Expired;
	}

	public void setExpired(String Expired) {
		this.Expired = Expired;
		;
	}

}
