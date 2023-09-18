package edu.sabanciuniv.it592api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sabanciuniv.it592api.entity.User;
import edu.sabanciuniv.it592api.repository.UserRepository;

@Service
public class UserService implements IService<User>{
	
	@Autowired
	private UserRepository userRepo;
	
	
	public User userLogin(String companyId, String password) {
		return userRepo.userLogin(companyId, password);
	}
	
	@Override
	public boolean delete(int prjId) {
		return userRepo.delete(prjId);
	}
	
	@Override
	public List<User> findAll(){
		return userRepo.findAll();
	}
	@Override
	public User findById(int id) {
		return userRepo.findById(id);
	}
	public List<User> findAllManager() {
		return userRepo.findAllManager();
	}
	public List<User> findAllPm() {
		return userRepo.findAllPm();
	}
	public List<User> findAllElectric() {
		return userRepo.findAllElectric();
	}
	public List<User> findAllMechanic() {
		return userRepo.findAllMechanic();
	}
	
	@Override
	public boolean save(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public boolean update(User user) {
		return userRepo.update(user);
	}
	
}
