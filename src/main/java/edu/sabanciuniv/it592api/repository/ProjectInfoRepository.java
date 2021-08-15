package edu.sabanciuniv.it592api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sabanciuniv.it592api.entity.ProjectInfo;

@Repository
public class ProjectInfoRepository implements IRepository<ProjectInfo>{
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public boolean delete(int prjInfoId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Query q = currentSession.createQuery("delete from ProjectInfo pi where pi.id=:id");
			q.setParameter("id", prjInfoId);
			q.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<ProjectInfo> findAll() {
		return entityManager.createQuery("Select pi from ProjectInfo pi", ProjectInfo.class).getResultList();
	}
	@Override
	public ProjectInfo findById(int id) {
		return entityManager.find(ProjectInfo.class, id);
	}
	
	@Override
	@Transactional
	public boolean save(ProjectInfo prjInfo) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.save(prjInfo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	@Transactional
	public boolean update(ProjectInfo prjInfo) {
		if(prjInfo.getId() == 0)
			return false;
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.update(prjInfo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
