package com.cdugga.java9.staticmethods;
/**
 * 
 * @author cdugga
 *
 */
class NANOConverter implements CryptoConverter{

	static final double NANO_TO_BITCOIN_SATOSHI_VALUATION = 0.0012251;
	
	static final double NANO_TO_USD_VALUATION = 11.71;
	
	@Override
	public double usdValue(double currencyHolding) {
		return NANO_TO_BITCOIN_SATOSHI_VALUATION * currencyHolding;
	}

	@Override
	public double btcValue(double currencyHolding) {
		return NANO_TO_USD_VALUATION * currencyHolding;
	}

}
