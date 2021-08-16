package edu.sabanciuniv.it592api;

import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import edu.sabanciuniv.it592api.entity.ProjectNumber;
import edu.sabanciuniv.it592api.repository.ProjectNumberRepository;

@SpringBootTest
class It592apiApplicationInitialNumber {

	@Autowired
	private ProjectNumberRepository repository;
	
	@Test
	void contextLoads() {
		ObjectMapper mapper = JsonMapper.builder()
						.addModule(new ParameterNamesModule())
						.addModule(new Jdk8Module())
						.addModule(new JavaTimeModule())
						.build();
		TypeReference<List<ProjectNumber>> typeReference = new TypeReference<List<ProjectNumber>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/prjNumber.json");
		try {
			List<ProjectNumber> prjNums = mapper.readValue(inputStream, typeReference);
			for (ProjectNumber prjNum : prjNums) {
				repository.save(prjNum);
				System.out.println("All users have been saved.");
			}
		}catch (Exception e) {
			System.out.println("There was an error while users had been saved!");
		}
	}

}
