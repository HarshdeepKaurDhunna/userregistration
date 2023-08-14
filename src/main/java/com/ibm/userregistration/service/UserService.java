/**
 * 
 */
package com.ibm.userregistration.service;
import java.util.UUID;

import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class UserService {
	
	
	public String getRandomId() {
      UUID uuid = UUID.randomUUID();
      return uuid.toString();
    }
}
