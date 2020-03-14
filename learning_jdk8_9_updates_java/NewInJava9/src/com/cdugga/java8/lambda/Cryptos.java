package com.cdugga.java8.lambda;

public class Cryptos {

	private String consensusModel;
	
	private String cryptoName;


	public Cryptos(String consensusModel, String cryptoName) {
		this.consensusModel = consensusModel;
		this.cryptoName = cryptoName;
	}


	public String getConsensusModel() {
		return consensusModel;
	}


	public void setConsensusModel(String consensusModel) {
		this.consensusModel = consensusModel;
	}


	public String getCryptoName() {
		return cryptoName;
	}


	public void setCryptoName(String cryptoName) {
		this.cryptoName = cryptoName;
	}
	
	
}
