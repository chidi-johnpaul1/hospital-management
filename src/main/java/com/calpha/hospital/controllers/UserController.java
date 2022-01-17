package com.calpha.hospital.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.calpha.hospital.model.Users;
import com.calpha.hospital.service.UsersService;

@Controller
public class UserController {

	 @Autowired
	    private UsersService userService;

	    // display list of users
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        model.addAttribute("listUsers", userService.getAllUsers());
	        return "index";
	    }

	    @GetMapping("/showNewUserForm")
	    public String showNewEmployeeForm(Model model) {
	        // create model attribute to bind form data
	        Users user = new Users();
	        model.addAttribute("user", user);
	        return "new_user";
	    }

	    @PostMapping("/saveUser")
	    public String saveUser(@ModelAttribute("user") Users user) {
	        // save user to database
	        userService.saveUser(user);
	        return "redirect:/";
	    }

	    @GetMapping("/showUserUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

	        // get user from the service
	        Users user = userService.getUserById(id);

	        // set user as a model attribute to pre-populate the form
	        model.addAttribute("user", user);
	        return "update_user";
	    }

	    @GetMapping("/deleteUser/{id}")
	    public String deleteUser(@PathVariable(value = "id") long id) {

	        // call delete user method 
	        this.userService.deleteUserById(id);
	        return "redirect:/";
	    }
}
