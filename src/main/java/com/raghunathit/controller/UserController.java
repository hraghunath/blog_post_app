package com.raghunathit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.raghunathit.binding.UserDto;
import com.raghunathit.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	 // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "registration";
    }
 // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserDto userDto,
                               
                         Model model){
        

        userService.saveRegistration(userDto);
        return "redirect:/register?success";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login2";
    }

}
