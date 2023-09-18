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

import edu.sabanciuniv.it592api.entity.Project;
import edu.sabanciuniv.it592api.entity.ProjectInfo;
import edu.sabanciuniv.it592api.entity.ProjectNumber;
import edu.sabanciuniv.it592api.entity.User;
import edu.sabanciuniv.it592api.repository.IProjectNumberRepository;
import edu.sabanciuniv.it592api.repository.ProjectInfoRepository;
import edu.sabanciuniv.it592api.repository.ProjectRepository;
import edu.sabanciuniv.it592api.repository.UserRepository;

@SpringBootTest
class It592apiApplicationInitialization {

	private ObjectMapper mapper;
	
	@Autowired
	private UserRepository userRep;
	@Autowired
	private ProjectInfoRepository infoRep;
	@Autowired
	private IProjectNumberRepository numberRep;
	@Autowired
	private ProjectRepository prjRep;
	
	@Test
	void contextLoads() {
		mapper = JsonMapper.builder()
						.addModule(new ParameterNamesModule())
						.addModule(new Jdk8Module())
						.addModule(new JavaTimeModule())
						.build();
		
		prjUserInitialization("/json/users.json");
		prjNumberInitialization("/json/prjNumber.json");
		prjInfoInitialization("/json/prjInfo.json");
		prjInitialization("/json/project.json");
		
	}
	
	
	void prjUserInitialization(String jsonFile) {
		TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFile);
		try {
			List<User> users = mapper.readValue(inputStream, typeReference);
			for (User user : users) {
				userRep.save(user);
				System.out.println("All users have been saved.");
			}
		}catch (Exception e) {
			System.out.println("There was an error while recording!");
		}
	}
	void prjNumberInitialization(String jsonFile) {
		TypeReference<List<ProjectNumber>> typeReference = new TypeReference<List<ProjectNumber>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFile);
		try {
			List<ProjectNumber> prjNums = mapper.readValue(inputStream, typeReference);
			for (ProjectNumber prjNum : prjNums) {
				numberRep.save(prjNum);
				System.out.println("All project numbers have been saved.");
			}
		}catch (Exception e) {
			System.out.println("There was an error while recording!");
		}
	}
	void prjInfoInitialization(String jsonFile) {
		TypeReference<List<ProjectInfo>> typeReference = new TypeReference<List<ProjectInfo>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFile);
		try {
			List<ProjectInfo> prjInfoAll = mapper.readValue(inputStream, typeReference);
			for (ProjectInfo prjInfo : prjInfoAll) {
				infoRep.save(prjInfo);
				System.out.println("All project info has been saved.");
			}
		}catch (Exception e) {
			System.out.println("There was an error while recording!");
		}
	}
	void prjInitialization(String jsonFile) {
		TypeReference<List<Project>> typeReference = new TypeReference<List<Project>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFile);
		try {
			List<Project> prjAll = mapper.readValue(inputStream, typeReference);
			for (Project prj : prjAll) {
				prjRep.save(prj);
				System.out.println("All projects have been saved.");
			}
		}catch (Exception e) {
			System.out.println("There was an error while recording!");
		}
	}

}
