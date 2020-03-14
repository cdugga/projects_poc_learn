package com.cd.infinite.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author cduggan 10/12/2017
 *
 */
@RestController
public class ListProcessorEndpoint {

	@Value("${bridge.members.txt}")
	private String bridgeMembersFile;
	
	@RequestMapping("/members")
	public List<BridgePlayer> getMemberNamesAndNumber() throws JSONException, URISyntaxException, IOException {
		return fetchMembersDetails();
	}

	private List<BridgePlayer> fetchMembersDetails() throws JSONException, URISyntaxException, IOException {
		return processInputFile(bridgeMembersFile);
	}
	
	private List<BridgePlayer> processInputFile(String inputFilePath) {
	    List<BridgePlayer> inputList = new ArrayList<BridgePlayer>();
	    try{
	      File inputF = new File(inputFilePath);
	      InputStream inputFS = new FileInputStream(inputF);
	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	      // skip the header of the csv
	      inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
	      br.close();
	    } catch ( IOException e) {
	    }
	    return inputList ;
	}
	
	private Function<String, BridgePlayer> mapToItem = (line) -> {
		  
		  BridgePlayer item = new BridgePlayer();
		  if(null != line) {
			  
			  String curatedLines = line.replace("\"", "");
			  String[] p = curatedLines.split(",");// a txt has comma separated lines
			  
			  if(p.length > 1) {
				  item.setItemNumber(p[0]);
				  item.setFirstName(p[1]);
				  item.setSecondName(p[2]);
				  item.setPlayerID(p[17]);
				  System.out.println(" Name:" +  item.getPlayerName() +" Player Id: " +  item.getPlayerID());//<-- this is the first column in the csv file
			  }
		  }
		  return item;
	};

}
