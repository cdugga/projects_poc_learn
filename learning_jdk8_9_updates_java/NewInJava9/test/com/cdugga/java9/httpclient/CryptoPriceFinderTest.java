package com.cdugga.java9.httpclient;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

/**
 * Running test with following params $--add-modules jdk.incubator.httpclient
 * @author cdugga
 *
 */
public class CryptoPriceFinderTest {

	//ETH,BTC,XMR,LTC,XRP,MAID,FCT,SC,SJCX,GNT&tsyms=BTC,EUR"))
	
	@Test
	public void synchronousGetPrices() throws URISyntaxException, IOException, InterruptedException {
		
		CryptoPriceFinder finder = new CryptoPriceFinder();
		String price = finder.synchronousGetPrice("ETH,BTC");
		System.out.println("Synchronous result: " + price);
		assertNotNull(price);
	}
	
	@Test
	public void asynchronousGetPrices() throws URISyntaxException, IOException, InterruptedException, ExecutionException {
		
		CryptoPriceFinder finder = new CryptoPriceFinder();
		String price = finder.asynchronousGetPrice("XRB,SUB");
		System.out.println("Asynchronous result: " +price);
		assertNotNull(price);
	}
	
	@Test
	public void asynchronousMultiGetPrices() throws URISyntaxException, IOException, InterruptedException, ExecutionException {
		
		CryptoPriceFinder finder = new CryptoPriceFinder();
		List<CompletableFuture<File>> responses = finder.asynchronousMultiRequestGetPrice("POE,PRL","ETC,NEO");
		
		for(CompletableFuture<File> response : responses) {
			File f = response.get();
			assertNotNull(f.length() > 0);
		}
		
		
	}
	
	
	
}
