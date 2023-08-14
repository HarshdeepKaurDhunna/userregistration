/**
 * 
 */
package com.ibm.userregistration.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;


@Schema(description = "User registartion request details")
public class UserDTO {
	
	@Schema(description = "User User Name for Registartion")
	@NotEmpty(message = "The username is required.")
	private String userName;
	
	@Schema(description = "Password for registration")
	@NotEmpty(message = "The password is required.")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[_#$%]).{8,}$", message = "Password must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, contains special characters_#$%.")
	private String password;
	
	@Schema(description = "IP Address for registartion")
	@NotEmpty(message = "The ipAddress is required.")
	private String ipAddress;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	


}
