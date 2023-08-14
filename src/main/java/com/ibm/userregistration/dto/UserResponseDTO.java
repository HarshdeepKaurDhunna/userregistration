package com.ibm.userregistration.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "User registartion response details")
public class UserResponseDTO {
	
	@Schema(description = "response message")
	private String responseMsg;
	
	@Schema(description = "Random UUID")
	private String uuid;
	
    public UserResponseDTO(String responseMsg, String uuid) {
    	this.responseMsg = responseMsg;
    	this.uuid = uuid;
	}
    
    public UserResponseDTO(String responseMsg) {
    	this.responseMsg = responseMsg;
	}
	/**
	 * @return the welcomeMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}
	
	/**
	 * @param welcomeMsg the welcomeMsg to set
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
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
