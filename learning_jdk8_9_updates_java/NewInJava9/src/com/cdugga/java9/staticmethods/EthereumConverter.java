package com.cdugga.java9.staticmethods;
/**
 * 
 * @author cdugga
 *
 */
class EthereumConverter implements CryptoConverter{

	static final double ETH_TO_BITCOIN_SATOSHI_VALUATION = 0.086707;
	
	static final double ETH_TO_USD_VALUATION = 834.00;
	
	@Override
	public double usdValue(double currencyHolding) {
		return ETH_TO_BITCOIN_SATOSHI_VALUATION * currencyHolding;
	}

	@Override
	public double btcValue(double currencyHolding) {
		return ETH_TO_USD_VALUATION * currencyHolding;
	}

}
