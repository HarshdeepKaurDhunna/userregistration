package com.ibm.userregistration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.userregistration.dto.UserDTO;

@SpringBootTest(properties = "spring.main.lazy-initialization=true",
classes = {UserDTO.class})

class UserregistrationApplicationTests {

	@Test
	void contextLoads() {
	}

}
