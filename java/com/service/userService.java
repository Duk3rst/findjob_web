package com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
@Component(value = "userService")
public class userService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Transactional
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
    @Transactional
    public void deleteUser(int theId) {
        userRepository.deleteById(theId);
    }
    
    @Transactional
    public void saveUser(User theuser) {
        userRepository.save(theuser);
    }
    
    
    public User findByEmail2 (String email) {
    	return userRepository.findByEmail(email);
    }
    
    public User findByIdUser (Integer id) {
    	return userRepository.findById(id).get();
    }
    
	@Transactional
	public void updateUser(int userId,String email,String fullName,String address,String phone,String descript) {
		Optional<User> result = userRepository.findById(userId);
		if (result.isPresent()) {
			User user = result.get();
			user.setEmail(email);
			user.setFullname(fullName);
			user.setAddress(address);
			user.setPhone(phone);
			user.setDescript(descript);
			
			userRepository.save(user);
			System.out.println("Update user successfully");
		}
	}
}
