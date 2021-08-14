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
	
	
	@Override
	public boolean add(User user) {
		return userRepo.add(user);
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
	
	@Override
	public boolean update(User user) {
		return userRepo.update(user);
	}
	
}
