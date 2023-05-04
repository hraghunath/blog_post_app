package com.raghunathit.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghunathit.binding.UserDto;
import com.raghunathit.entity.User;
import com.raghunathit.repository.UserRepository;
import com.raghunathit.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void saveRegistration(UserDto userDto) {
		  User user = new User();
	        user.setFname(userDto.getFirstName());
	        user.setLname(userDto.getLastName());
	        user.setEmail(userDto.getEmail());
	        user.setPwd(userDto.getPassword());
	       userRepo.save(user);
		
	}
	
	 
	private UserDto mapToUserDto(User user){
	        UserDto userDto = new UserDto();
	       
	        userDto.setFirstName(user.getFname());
	        userDto.setLastName(user.getLname());
	        userDto.setEmail(user.getEmail());
	        userDto.setPassword(user.getPwd());
	        return userDto;
	    }
	


}
