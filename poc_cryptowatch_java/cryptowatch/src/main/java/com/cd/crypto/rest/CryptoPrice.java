package com.cd.crypto.rest;

public class CryptoPrice {

	private double euroValueOfHolding;
	
	public double getEuroValueOfHolding() {
		return this.eur_price * this.getHoldings();
	}

	private String symbol;
	
	private double btc_price;
	
	private double eur_price;
	
	private double holdings;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getBtc_price() {
		return btc_price;
	}

	public void setBtc_price(double btc_price) {
		this.btc_price = btc_price;
	}

	public double getEur_price() {
		return eur_price;
	}

	public void setEur_price(double eur_price) {
		this.eur_price = eur_price;
	}

	public double getHoldings() {
		return holdings;
	}

	public void setHoldings(double holdings) {
		this.holdings = holdings;
	}
	
	
}
