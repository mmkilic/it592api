package edu.sabanciuniv.it592api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sabanciuniv.it592api.entity.Project;
import edu.sabanciuniv.it592api.service.ProjectService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	
	@PostMapping("/prj")
	public boolean addProject(@RequestBody Project project) {
		
		return projectService.save(project);
	}
	
	@DeleteMapping("/prj/{projectId}")
	public boolean deleteProject(@PathVariable int projectId) {
		
		return projectService.delete(projectId);
	}
	
	@GetMapping("/prj")
	public List<Project> getProjectAll() {
		
		return projectService.findAll();
	}
	@GetMapping("/prj/{projectId}")
	public Project getProjectWithId(@PathVariable int projectId) {
		
		return projectService.findById(projectId);
	}
	@GetMapping("/prj/nbr/{prjNumId}")
	public Project getProjectWithProjectNumber(@PathVariable int prjNumId) {
		
		return projectService.findByProjectNumber(prjNumId);
	}
	
	@PutMapping("/prj")
	public boolean updateProject(@RequestBody Project project) {
		
		return projectService.update(project);
	}
	
}
