package com.calpha.hospital.controllers;



import com.calpha.hospital.model.Privilege;
import com.calpha.hospital.model.Role;
import com.calpha.hospital.model.Users;
import com.calpha.hospital.events.OnRegistrationCompleteEvent;
import com.calpha.hospital.dto.UserDto;
import com.calpha.hospital.util.GeneralResponse;
import com.calpha.hospital.service.UsersService;


import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.context.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.controller.String;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;



@Controller
public class RegistrationController {
	
	 private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private final UsersService userService;
	
	 @Autowired
	 private MessageSource messages;

    
    public RegistrationController(UsersService userService) {
        this.userService = userService;
    }

	

	    @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public String createNewUser(@Valid Users user,
	                                BindingResult bindingResult,
	                                ModelMap model) {

	        if (userService.findByEmail(user.getEmail()).isPresent()) {
	            bindingResult
	                    .rejectValue("email", "error.user",
	                            "There is already a user registered with the email provided");
	        }
	        if (userService.findByUsername(user.getUsername()).isPresent()) {
	            bindingResult
	                    .rejectValue("username", "error.user",
	                            "There is already a user registered with the username provided");
	        }

	        if (!bindingResult.hasErrors()) {
	            
	            userService.saveUser(user);

	            model.addAttribute("successMessage", "User has been registered successfully");
	            model.addAttribute("user", new Users());
	        }

	        return "/registration";
	    }
	    
	    
	    @GetMapping("/registrationConfirm")
	    public ModelAndView confirmRegistration(final HttpServletRequest request, final ModelMap model, @RequestParam("token") final String token) throws UnsupportedEncodingException {
	        Locale locale = request.getLocale();
	        model.addAttribute("lang", locale.getLanguage());
	        final String result = userService.validateVerificationToken(token);
	        if (result.equals("valid")) {
	            final Users user = userService.getUser(token);
	            // if (user.isUsing2FA()) {
	            // model.addAttribute("qr", userService.generateQRUrl(user));
	            // return "redirect:/qrcode.html?lang=" + locale.getLanguage();
	            // }
	            authWithoutPassword(user);
	            model.addAttribute("messageKey", "message.accountVerified");
	            return new ModelAndView("redirect:/console", model);
	        }

	        model.addAttribute("messageKey", "auth.message." + result);
	        model.addAttribute("expired", "expired".equals(result));
	        model.addAttribute("token", token);
	        return new ModelAndView("redirect:/badUser", model);
	    }

	    @GetMapping("/console")
	    public ModelAndView console(final HttpServletRequest request, final ModelMap model, @RequestParam("messageKey") final Optional<String> messageKey) {

	        Locale locale = request.getLocale();
	        messageKey.ifPresent( key -> {
	                    String message = messages.getMessage(key, null, locale);
	                    model.addAttribute("message", message);
	                }
	        );

	        return new ModelAndView("console", model);
	    }

	    @GetMapping("/badUser")
	    public ModelAndView badUser(final HttpServletRequest request, final ModelMap model, @RequestParam("messageKey" ) final Optional<String> messageKey, @RequestParam("expired" ) final Optional<String> expired, @RequestParam("token" ) final Optional<String> token) {

	        Locale locale = request.getLocale();
	        messageKey.ifPresent( key -> {
	                    String message = messages.getMessage(key, null, locale);
	                    model.addAttribute("message", message);
	                }
	        );

	        expired.ifPresent( e -> model.addAttribute("expired", e));
	        token.ifPresent( t -> model.addAttribute("token", t));

	        return new ModelAndView("badUser", model);
	    }

	    @GetMapping("/user/changePassword")
	    public ModelAndView showChangePasswordPage(final ModelMap model, @RequestParam("token") final String token) {
	        final String result = securityUserService.validatePasswordResetToken(token);

	        if(result != null) {
	            String messageKey = "auth.message." + result;
	            model.addAttribute("messageKey", messageKey);
	            return new ModelAndView("redirect:/login", model);
	        } else {
	            model.addAttribute("token", token);
	            return new ModelAndView("redirect:/updatePassword");
	        }
	    }

	    @GetMapping("/updatePassword")
	    public ModelAndView updatePassword(final HttpServletRequest request, final ModelMap model, @RequestParam("messageKey" ) final Optional<String> messageKey) {
	        Locale locale = request.getLocale();
	        model.addAttribute("lang", locale.getLanguage());
	        messageKey.ifPresent( key -> {
	                    String message = messages.getMessage(key, null, locale);
	                    model.addAttribute("message", message);
	                }
	        );

	        return new ModelAndView("updatePassword", model);
	    }

	    @GetMapping("/login")
	    public ModelAndView login(final HttpServletRequest request, final ModelMap model, @RequestParam("messageKey" ) final Optional<String> messageKey, @RequestParam("error" ) final Optional<String> error) {
	        Locale locale = request.getLocale();
	        model.addAttribute("lang", locale.getLanguage());
	        messageKey.ifPresent( key -> {
	                    String message = messages.getMessage(key, null, locale);
	                    model.addAttribute("message", message);
	                }
	        );

	        error.ifPresent( e ->  model.addAttribute("error", e));

	        return new ModelAndView("login", model);
	    }
    
	    
	 // ============== NON AUTH-API ============

	    public void authWithoutPassword(Users user) {

	        List<Privilege> privileges = user.getRoles()
	                .stream()
	                .map(Role::getPrivileges)
	                .flatMap(Collection::stream)
	                .distinct()
	                .collect(Collectors.toList());

	        List<GrantedAuthority> authorities = privileges.stream()
	                .map(p -> new SimpleGrantedAuthority(p.getName()))
	                .collect(Collectors.toList());

	        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	    }

	     /**
	     * used to get the application URL 
	     * **/
	    private String getAppUrl(HttpServletRequest request) {
	        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	    }

	    /**
	     * to be used later to get  user IP Address
	     * **/
	    private final String getClientIP(HttpServletRequest request) {
	        final String xfHeader = request.getHeader("X-Forwarded-For");
	        if (xfHeader == null) {
	            return request.getRemoteAddr();
	        }
	        return xfHeader.split(",")[0];
	    }


}
