package edu.sabanciuniv.it592api;

import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.sabanciuniv.it592api.entity.User;
import edu.sabanciuniv.it592api.repository.UserRepository;

@SpringBootTest
class It592apiApplicationInitialUsers {

	@Autowired
	private UserRepository userRep;
	
	@Test
	void contextLoads() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
		try {
			List<User> users = mapper.readValue(inputStream, typeReference);
			for (User user : users) {
				userRep.save(user);
				System.out.println("All users have been saved.");
			}
		}catch (Exception e) {
			System.out.println("There was an error while users had been saved!");
		}
	}

}
