/**
 * 
 */
package com.ibm.userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.userregistration.dto.UserDTO;
import com.ibm.userregistration.dto.UserResponseDTO;
import com.ibm.userregistration.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * 
 */
@Tag(name = "UserRegistartion", description = "User Registartion APIs")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@Operation(summary = "Validate User", tags = { "UserRegistartion", "post" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = UserResponseDTO.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }), })
	@PostMapping("/userRegistration")
	public ResponseEntity<UserResponseDTO> validateUser(@Valid @RequestBody UserDTO userDTO) {
		
		UserResponseDTO userResponseDTO = userService.getUserDetails(userDTO);

		if (userResponseDTO != null) {
			return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
