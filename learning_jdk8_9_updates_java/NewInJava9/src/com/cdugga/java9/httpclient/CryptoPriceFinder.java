package com.cdugga.java9.httpclient;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import jdk.incubator.http.HttpResponse.BodyHandler;

/**
 * 
 * @author cdugga
 *
 */
public class CryptoPriceFinder {

	public String synchronousGetPrice(final String argToken)
			throws URISyntaxException, IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("https://min-api.cryptocompare.com/data/pricemulti?fsyms=" + argToken + "&tsyms=BTC,EUR")) // ETH,BTC,XMR,LTC,XRP,MAID,FCT,SC,SJCX,GNT&tsyms=BTC,EUR"))
				.GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());
		return response.body().toString();
	}

	public String asynchronousGetPrice(final String argToken)
			throws URISyntaxException, IOException, InterruptedException, ExecutionException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("https://min-api.cryptocompare.com/data/pricemulti?fsyms=" + argToken + "&tsyms=BTC,EUR")) // ETH,BTC,XMR,LTC,XRP,MAID,FCT,SC,SJCX,GNT&tsyms=BTC,EUR"))
				.GET().build();

		CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(request,
				HttpResponse.BodyHandler.asString());
		return futureResponse.get().body().toString();
	}

	public List<CompletableFuture<File>> asynchronousMultiRequestGetPrice(final String argTokenString1, String argTokenString2)
			throws URISyntaxException {

		List<URI> targets = Arrays.asList(
				new URI("https://min-api.cryptocompare.com/data/pricemulti?fsyms=" + argTokenString1
						+ "&tsyms=BTC,EUR"),
				new URI("https://min-api.cryptocompare.com/data/pricemulti?fsyms=" + argTokenString2
						+ "&tsyms=BTC,EUR"));

		HttpClient client = HttpClient.newHttpClient();

		List<CompletableFuture<File>> futures = targets.stream()
				.map(target -> client
						.sendAsync(
								HttpRequest.newBuilder(target)
									.GET().build(),
								BodyHandler.asFile(Paths.get("results", target.getPath())))
				.thenApply(response -> response.body()).thenApply(path -> path.toFile()))
				.collect(Collectors.toList());

		return futures;
	}

}
