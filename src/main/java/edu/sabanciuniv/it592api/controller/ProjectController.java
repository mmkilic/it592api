package edu.sabanciuniv.it592api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sabanciuniv.it592api.entity.Project;
import edu.sabanciuniv.it592api.entity.User;
import edu.sabanciuniv.it592api.enums.Roles;
import edu.sabanciuniv.it592api.enums.Statuses;
import edu.sabanciuniv.it592api.service.ProjectService;
import edu.sabanciuniv.it592api.service.UserService;

//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/prj")
	public boolean addProject(@RequestBody Project project) {
		project.setStatus(Statuses.ACTIVE);
		return projectService.save(project);
	}
	@GetMapping("/prj")
	public List<Project> getProjectAll() {
		return projectService.findAll();
	}
	@PutMapping("/prj")
	public boolean updateProject(@RequestBody Project project) {
		return projectService.update(project);
	}
	@GetMapping("/prj/{projectId}")
	public Project getProjectWithId(@PathVariable int projectId) {
		return projectService.findById(projectId);
	}
	@DeleteMapping("/prj/{projectId}")
	public boolean deleteProject(@PathVariable int projectId) {
		if(projectId == 0)
			return false;
		return projectService.delete(projectId);
	}

	@GetMapping("/prj/year/{year}")
	public List<Project> getProjectWithYear(@PathVariable int year) {
		return projectService.findByCreateYear(year);
	}
	
	@GetMapping("/prj/nbr/{prjNumId}")
	public Project getProjectWithProjectNumber(@PathVariable int prjNumId) {
		return projectService.findByProjectNumber(prjNumId);
	}
	@GetMapping("/prj/user/{userId}")
	public List<Project> getOngoingProjectWithUserId(@PathVariable int userId) {
		List<Project> prj = new ArrayList<Project>();
		List<Project> userPrj = projectService.findByUser(userId);
		if(userPrj.size() == 0) return prj;
		
		User user = userService.findById(userId);
		if(user.getRole() == Roles.ELECTRIC) {
			for (Project p : userPrj) {
				if(p.getGaElectActual() == null || p.getBomElectActual() == null)
					prj.add(p);
			}
		}
		if(user.getRole() == Roles.MECHANIC) {
			for (Project p : userPrj) {
				if(p.getGaMechActual() == null || p.getBomMechActual() == null)
					prj.add(p);
			}
		}
		return prj;
	}
}
