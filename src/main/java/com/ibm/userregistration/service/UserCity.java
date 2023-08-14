package com.ibm.userregistration.service;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.userregistration.dto.GeolocationDetail;


public class UserCity {
	
	public static void main(String[] args) {
		String url = "http://ip-api.com/json/24.48.0.1";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);
	   System.out.print(result);
	    ObjectMapper map = new ObjectMapper();
	    GeolocationDetail orderObj;
		try {
			orderObj = map.readValue(result, GeolocationDetail.class);
			 System.out.println("printing output-11->" + orderObj);
		     System.out.println("printing output-->" + orderObj.toString());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

       
	    
	}
	
}
