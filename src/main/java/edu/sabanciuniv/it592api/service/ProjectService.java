package edu.sabanciuniv.it592api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sabanciuniv.it592api.entity.Project;
import edu.sabanciuniv.it592api.repository.ProjectRepository;

@Service
public class ProjectService implements IService<Project>{
	
	@Autowired
	private ProjectRepository projectRepo;
	
	
	@Override
	public boolean delete(int prjId) {
		return projectRepo.delete(prjId);
	}
	
	@Override
	public List<Project> findAll(){
		return projectRepo.findAll();
	}
	@Override
	public Project findById(int id) {
		return projectRepo.findById(id);
	}
	public Project findByProjectNumber(int prjNbrId) {
		return projectRepo.findByProjectNumber(prjNbrId);
	}
	public List<Project> findByCreateYear(int year) {
		return projectRepo.findByCreateYear(year);
	}
	public List<Project> findByUser(int userId) {
		return projectRepo.findByUser(userId);
	}
	
	@Override
	public boolean save(Project prj) {
		return projectRepo.save(prj);
	}
	
	@Override
	public boolean update(Project prj) {
		return projectRepo.update(prj);
	}
}
