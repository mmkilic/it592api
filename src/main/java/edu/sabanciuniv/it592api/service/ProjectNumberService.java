package edu.sabanciuniv.it592api.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sabanciuniv.it592api.entity.ProjectNumber;
import edu.sabanciuniv.it592api.repository.IProjectNumberRepository;

@Service
public class ProjectNumberService implements IService<ProjectNumber>{
	
	@Autowired
	private IProjectNumberRepository prjNumberRepository;
	
	
	@Override
	public boolean delete(int prjNumId) {
		try {
			prjNumberRepository.deleteById(prjNumId);
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
		return prjNumberRepository.findById(id).get();
	}
	public List<ProjectNumber> findByMainProject(int mainPrjId){
		return prjNumberRepository.findByMainProject(mainPrjId);
	}
	
	public boolean saveAll(Set<ProjectNumber> numbers) {
		try {
			prjNumberRepository.saveAll(numbers);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean save(ProjectNumber prjNum) {
		try {
			prjNumberRepository.save(prjNum);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(ProjectNumber prjNum) {
		try {
			if(prjNum.getId() == 0) 
				return false;
			prjNumberRepository.save(prjNum);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
