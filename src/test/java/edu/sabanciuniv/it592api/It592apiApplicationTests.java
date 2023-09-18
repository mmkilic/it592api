package edu.sabanciuniv.it592api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sabanciuniv.it592api.entity.User;
import edu.sabanciuniv.it592api.enums.Departments;
import edu.sabanciuniv.it592api.enums.Roles;
import edu.sabanciuniv.it592api.repository.UserRepository;

@SpringBootTest
class It592apiApplicationTests {

	@Autowired
	private UserRepository userCont;
	
	@Test
	void contextLoads() {
		User u = new User();
		
		u.setDepartment(Departments.ENGINEERING);
		u.setCompanyId("MMK400100");
		u.setEmail(u.getCompanyId() + "@mmk.com");
		u.setFirstName("Berk");
		u.setLastName("Gökçen");
		u.setPassword("1234");
		u.setRole(Roles.MANAGER);
		
		userCont.save(u);
	}

}
