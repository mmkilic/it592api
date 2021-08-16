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

import edu.sabanciuniv.it592api.entity.ProjectInfo;
import edu.sabanciuniv.it592api.repository.ProjectInfoRepository;

@SpringBootTest
class It592apiApplicationInitialInfo {

	@Autowired
	private ProjectInfoRepository infoRep;
	
	@Test
	void contextLoads() {
		ObjectMapper mapper = JsonMapper.builder()
						.addModule(new ParameterNamesModule())
						.addModule(new Jdk8Module())
						.addModule(new JavaTimeModule())
						.build();
		TypeReference<List<ProjectInfo>> typeReference = new TypeReference<List<ProjectInfo>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/prjInfo.json");
		try {
			List<ProjectInfo> prjInfoAll = mapper.readValue(inputStream, typeReference);
			for (ProjectInfo prjInfo : prjInfoAll) {
				infoRep.save(prjInfo);
				System.out.println("All users have been saved.");
			}
		}catch (Exception e) {
			System.out.println("There was an error while users had been saved!");
		}
	}

}
