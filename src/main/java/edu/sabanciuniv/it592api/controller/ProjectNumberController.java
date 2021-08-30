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

import edu.sabanciuniv.it592api.entity.ProjectNumber;
import edu.sabanciuniv.it592api.service.ProjectNumberService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProjectNumberController {

	@Autowired
	private ProjectNumberService prjNumService;
	
	
	@PostMapping("/nbr")
	public boolean addPrjNumber(@RequestBody ProjectNumber prjNbr) {
		return prjNumService.save(prjNbr);
	}
	
	@DeleteMapping("/nbr/{nbrId}")
	public boolean deletePrjNumber(@PathVariable int prjNbrId) {
		return prjNumService.delete(prjNbrId);
	}
	
	@GetMapping("/nbr")
	public List<ProjectNumber> getPrjNumberAll() {
		return prjNumService.findAll();
	}
	@GetMapping("/nbr/prj/{nbrId}")
	public ProjectNumber getPrjNumberWithId(@PathVariable int nbrId) {
		return prjNumService.findById(nbrId);
	}
	@GetMapping("/nbr/sub/{mainPrjId}")
	public List<ProjectNumber> getPrjNumbersWithMainId(@PathVariable int mainPrjId) {
		return prjNumService.findByMainProject(mainPrjId);
	}
	
	@PutMapping("/nbr")
	public boolean updatePrjNumber(@RequestBody ProjectNumber prjNbr) {
		return prjNumService.update(prjNbr);
	}
	
}
