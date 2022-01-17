package com.calpha.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.calpha.hospital.model.RoleNames;
import com.calpha.hospital.model.Users;
import com.calpha.hospital.service.UsersService;

import java.util.Optional;

import javax.annotation.PostConstruct;

@Component
public class InitialSetup {

    @Autowired
    private UsersService userService;

    @Value("${admin.first.name}")
    private String firstName;

    @Value("${admin.last.name}")
    private String lastName;

    @Value("${admin.email.address}")
    private String emailAddress;
    
    @Value("${admin.phone.number}")
    private String phoneNumber;
    
    @Value("${admin.user.name}")
    private String username;

    @Value("${admin.password}")
    private String password;



    @PostConstruct
    public void initIt() throws Exception {

        Optional<Users> dbUser = userService.findByEmail(emailAddress);

        if (dbUser == null) {
            Users user = new Users();
            user.setFirstname(firstName);
            user.setLastname(lastName);
            user.setEmail(emailAddress);
            user.setPassword(password);
            user.setActive(Boolean.TRUE);
            user.setRoleName(RoleNames.ADMIN.name());
            userService.saveUser(user);
        }
        loadUsers();
    }



    private void loadUsers() {
        Users user1 = new Users("johnpaul", "john", "john@doe.com", "1234567891",
        		"johnpaul", "johnpaul", Boolean.TRUE, RoleNames.ADMIN.name());
        userService.saveUser(user1);

        
    }
}