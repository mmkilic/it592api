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

import edu.sabanciuniv.it592api.entity.ProjectInfo;
import edu.sabanciuniv.it592api.service.ProjectInfoService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProjectInfoController {

	@Autowired
	private ProjectInfoService prjInfoService;
	
	
	@PostMapping("/info")
	public boolean addPrjNumber(@RequestBody ProjectInfo prjInfo) {
		return prjInfoService.save(prjInfo);
	}
	@GetMapping("/info")
	public List<ProjectInfo> getPrjNumberAll() {
		return prjInfoService.findAll();
	}
	@PutMapping("/info")
	public boolean updatePrjNumber(@RequestBody ProjectInfo prjInfo) {
		return prjInfoService.update(prjInfo);
	}
	
	@GetMapping("/info/{infoId}")
	public ProjectInfo getPrjNumberWithId(@PathVariable int prjInfoId) {
		return prjInfoService.findById(prjInfoId);
	}
	@DeleteMapping("/info/{nbrId}")
	public boolean deletePrjNumber(@PathVariable int prjInfoId) {
		if(prjInfoId == 0)
			return false;
		return prjInfoService.delete(prjInfoId);
	}
}
