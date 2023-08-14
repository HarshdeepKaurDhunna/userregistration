/**
 * 
 */
package com.ibm.userregistration.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.userregistration.dto.GeolocationDetail;
import com.ibm.userregistration.dto.UserDTO;
import com.ibm.userregistration.dto.UserResponseDTO;

/**
 * 
 */
@Service
public class UserService {

	@Value("${user.geolocation.url}")
	private String devUrl;

	private String getRandomId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public UserResponseDTO getUserDetails(UserDTO userDTO) {
		GeolocationDetail geolocationDetail = this.getUserCity(userDTO);
		UserResponseDTO UserResponseDTO = null;
		if (geolocationDetail != null) {
			return UserResponseDTO = (geolocationDetail.getCountry().equalsIgnoreCase("Canada")
					&& geolocationDetail.getStatus().equalsIgnoreCase("success"))
							? new UserResponseDTO(this.getWelcomeText(userDTO, geolocationDetail), this.getRandomId())
							: new UserResponseDTO(this.getErrorMsg(userDTO, geolocationDetail));
		}
		return UserResponseDTO;
	}

	/**
	 * 
	 * @param userDTO get the request value
	 * @return return response
	 */
	private GeolocationDetail getUserCity(UserDTO userDTO) {

		String url = devUrl + userDTO.getIpAddress();
		RestTemplate restTemplate = new RestTemplate();
		String ipResult = restTemplate.getForObject(url, String.class);

		ObjectMapper map = new ObjectMapper();
		GeolocationDetail geolocationDetail = null;

		try {
			geolocationDetail = map.readValue(ipResult, GeolocationDetail.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return geolocationDetail;

	}

	private String getWelcomeText(UserDTO userDTO, GeolocationDetail geolocationDetail) {
		return "Hey " + userDTO.getUserName() + " from " + geolocationDetail.getCity()
				+ "! Welcome, you have registered succesfully";
	}

	private String getErrorMsg(UserDTO userDTO, GeolocationDetail geolocationDetail) {
		return "Hey " + userDTO.getUserName() + ", So Sorry!! Only Canadians users are allowed to register";
	}
}
