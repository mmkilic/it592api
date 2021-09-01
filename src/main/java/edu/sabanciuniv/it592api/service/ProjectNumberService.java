package edu.sabanciuniv.it592api.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sabanciuniv.it592api.entity.ProjectNumber;
import edu.sabanciuniv.it592api.repository.ProjectNumberRepository;

@Service
public class ProjectNumberService implements IService<ProjectNumber>{
	
	@Autowired
	private ProjectNumberRepository prjNumberRepository;
	
	
	@Override
	public boolean delete(int prjNumId) {
		try {
			prjNumberRepository.delete(prjNumId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<ProjectNumber> findAll(){
		return prjNumberRepository.findAll();
	}
	@Override
	public ProjectNumber findById(int id) {
		return prjNumberRepository.findById(id);
	}
	public List<ProjectNumber> findByMainProject(int mainPrjId){
		return prjNumberRepository.findByMainProject(mainPrjId);
	}
	
	public boolean saveAll(Set<ProjectNumber> numbers) {
		return prjNumberRepository.saveAll(numbers);
	}
	
	@Override
	public boolean save(ProjectNumber prjNum) {
		return prjNumberRepository.save(prjNum);
	}
	
	@Override
	public boolean update(ProjectNumber prjNum) {
		try {
			if(prjNum.getId() == 0) 
				return false;
			prjNumberRepository.update(prjNum);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
