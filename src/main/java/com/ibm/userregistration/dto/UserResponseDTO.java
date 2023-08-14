package com.ibm.userregistration.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "User registartion response details")
public class UserResponseDTO {
	
	@Schema(description = "welcome message")
	private String welcomeMsg;
	
	@Schema(description = "Random UUID")
	private String uuid;

	/**
	 * @return the welcomeMsg
	 */
	public String getWelcomeMsg() {
		return welcomeMsg;
	}

	/**
	 * @param welcomeMsg the welcomeMsg to set
	 */
	public void setWelcomeMsg(String welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	
	


}
