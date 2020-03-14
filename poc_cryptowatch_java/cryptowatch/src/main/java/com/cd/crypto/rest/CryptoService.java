package com.cd.crypto.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CryptoService {

	@Value("${cryptoPrice.endpoint}")
	private String cryptoPriceEndpoint;

	@RequestMapping("/prices")
	public List<CryptoPrice> greeting(@RequestParam(value = "name", defaultValue = "World") String name)
			throws JSONException {

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(cryptoPriceEndpoint, String.class);
		JSONObject jsonObj = new JSONObject(result);

		Iterator<?> iterator = jsonObj.keys();
		List<CryptoPrice> prices = new ArrayList<CryptoPrice>();
		Map<String, Double> allocations = allocations();
		
		while( iterator.hasNext() ) {
		    String key = (String)iterator.next();
		    if ( jsonObj.get(key) instanceof JSONObject ) {
		    	CryptoPrice tempPrice = new CryptoPrice();
		    	JSONObject tempObj = (JSONObject) jsonObj.get(key);
		    	
		    	double holdings = allocations.get(key);
		    	
		    	tempPrice.setSymbol(key);
		    	tempPrice.setHoldings(holdings);
		    	tempPrice.setBtc_price(Double.parseDouble(tempObj.get("BTC").toString()));
		    	tempPrice.setEur_price(Double.parseDouble(tempObj.get("EUR").toString()));
		    	prices.add(tempPrice);
		    }
		}
		

		System.out.println(jsonObj);

		return prices;
	}

	private Map<String, Double> allocations(){
		return new HashMap<String, Double>(){{
			put("BTC", 0.0); 
			put("ETH", 12.8);
		     put("LTC", 5.5);
		     put("XMR", 5.39);
		     put("SJCX", 37.943);
		     put("XRP", 129.67);
		     put("SC", 1097.25);
		     put("MAID", 118.2);
		     put("GNT", 149.6);
		     put("FCT", 4.38);
		}};
		
	}
	
}
