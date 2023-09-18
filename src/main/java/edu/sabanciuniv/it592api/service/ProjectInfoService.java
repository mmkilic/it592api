package edu.sabanciuniv.it592api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sabanciuniv.it592api.entity.ProjectInfo;
import edu.sabanciuniv.it592api.repository.ProjectInfoRepository;

@Service
public class ProjectInfoService implements IService<ProjectInfo>{
	
	@Autowired
	private ProjectInfoRepository prjInfoRepository;
	
	
	@Override
	public boolean delete(int prjInfoId) {
		try {
			prjInfoRepository.delete(prjInfoId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<ProjectInfo> findAll(){
		return prjInfoRepository.findAll();
	}
	@Override
	public ProjectInfo findById(int id) {
		return prjInfoRepository.findById(id);
	}
	
	@Override
	public boolean save(ProjectInfo prjInfo) {
		try {
			prjInfoRepository.save(prjInfo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(ProjectInfo prjInfo) {
		try {
			if(prjInfo.getId() == 0) 
				return false;
			prjInfoRepository.update(prjInfo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
