package com.calpha.hospital.serviceImpl;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.calpha.hospital.model.Users;
import com.calpha.hospital.dto.UserDto;
import com.calpha.hospital.model.PasswordResetToken;
import com.calpha.hospital.model.VerificationToken;
import com.calpha.hospital.exception.UserAlreadyExistException;
import com.calpha.hospital.repository.UserRepository;
import com.calpha.hospital.repository.VerificationTokenRepository;
import com.calpha.hospital.repository.RoleRepository;
import com.calpha.hospital.service.UsersService;
import com.calpha.hospital.service.IUserService;
import com.calpha.hospital.repository.PasswordResetTokenRepository;

@Service
@Transactional
public class UserServiceImpl implements UsersService,IUserService {
	
		@Autowired
		private SessionRegistry sessionRegistry;
		
		@Autowired
	    private VerificationTokenRepository tokenRepository;


		@Autowired
	    private PasswordResetTokenRepository passwordTokenRepository;

		@Autowired
	    private RoleRepository roleRepository;
	
		@Autowired
		private PasswordEncoder passwordEncoder;
	
		@Autowired
	    private UserRepository userRepository;
		
		@Autowired
	    private Environment env;

	    public static final String TOKEN_INVALID = "invalidToken";
	    public static final String TOKEN_EXPIRED = "expired";
	    public static final String TOKEN_VALID = "valid";

	    @Override
	    public List <Users> getAllUsers() {
	        return userRepository.findAll();
	    }

	    @Override
	    public void saveUser(Users user) {
	    	
	    	if (user.getId() == null) {
	            user.setPassword(passwordEncoder.encode(user.getPassword()));
	            user.setActive(Boolean.TRUE);
	        }
	        userRepository.save(user);
	      
	    }

	    @Override
	    public Users getUserById(long id) {
	        Optional <Users> optional = userRepository.findById(id);
	        Users user = null;
	        if (optional.isPresent()) {
	            user = optional.get();
	        } else {
	            throw new RuntimeException(" User not found for id :: " + id);
	        }
	        return user;
	    }

	    @Override
	    public void deleteUserById(long id) {
	        this.userRepository.deleteById(id);
	    }

		@Override
		public Optional<Users> findByEmail(String email) {
		return this.userRepository.findByEmail(email);
			
		}

		@Override
		public Optional<Users> findByUsername(String username) {
			return this.userRepository.findByUsername(username);
		}
		
		public Iterable<Users> findByActive(boolean active){
			
			return this.userRepository.findByActive(active);
		}

		@Override
		public Page<Users> searchByTerm(String name, Pageable pageable) {
			return userRepository.searchByTerm(name, pageable);
		}

		@Override
		public Page<Users> listUsers(Pageable pageable) {
			return userRepository.findAll(pageable);
		}
		
		
		@Override
	    public List<Users> searchBy(String keyword, String criteria) {
	        if ("firstName".equals(criteria)) {
	            return userRepository.findByFirstNameIgnoreCaseContaining(keyword);
	        } else if ("lastName".equals(criteria)) {
	            return userRepository.findByLastNameIgnoreCaseContaining(keyword);
	        } else if ("email".equals(criteria)) {
	            return userRepository.findByEmailIgnoreCaseContaining(keyword);
	        }
	        return new ArrayList<>();

	    }

		@Override
		public Users registerNewUser(UserDto userDto){
			
			if (emailExists(userDto.getEmail())) {
	            throw new UserAlreadyExistException("There is an account with that email address: "+ userDto.getEmail());
	        }
	        final Users user = new Users();

	        user.setFirstName(userDto.getFirstName());
	        user.setLastName(userDto.getLastName());
	        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
	        user.setEmail(userDto.getEmail());
	        user.setUsing2FA(userDto.isUsing2FA());
	        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
	        //user.setUsername(userDto);
	       
	        return userRepository.save(user);
		}

		@Override
		public Users getUser(String verificationToken) {
			
			final VerificationToken token = tokenRepository.findByToken(verificationToken);
	        if (token != null) {
	            return token.getUser();
	        }
	        return null;
		}

		@Override
		public void saveRegisteredUser(Users user) {
			// TODO Auto-generated method stub
			userRepository.save(user);
		}

		@Override
		public void deleteUser(Users user) {
			// TODO Auto-generated method stub
			 final VerificationToken verificationToken = tokenRepository.findByUser(user);
			 if (verificationToken != null) {
		            tokenRepository.delete(verificationToken);
		        }

		        final PasswordResetToken passwordToken = passwordTokenRepository.findByUser(user);

		        if (passwordToken != null) {
		            passwordTokenRepository.delete(passwordToken);
		        }

		        userRepository.delete(user);
		}

		@Override
		public void createVerificationTokenForUser(Users user, String token) {
			
			final VerificationToken myToken = new VerificationToken(token, user);
	        tokenRepository.save(myToken);
		}

		@Override
		public VerificationToken getVerificationToken(String VerificationToken) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
			
			VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
	        vToken.updateToken(UUID.randomUUID()
	        .toString());
	        vToken = tokenRepository.save(vToken);
	        return vToken;
		}

		@Override
		public void createPasswordResetTokenForUser(Users user, String token) {
			
			final PasswordResetToken myToken = new PasswordResetToken(token, user);
	        passwordTokenRepository.save(myToken);
			
		}

		 private boolean emailExists(final String email) {
		        return userRepository.findByEmail(email) != null;
		    }
		
		@Override
		public Users findUserByEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PasswordResetToken getPasswordResetToken(String token) {
			// TODO Auto-generated method stub
			return passwordTokenRepository.findByToken(token);
		}

		@Override
		public Optional<Users> getUserByPasswordResetToken(String token) {
			// TODO Auto-generated method stub
			return Optional.ofNullable(passwordTokenRepository.findByToken(token) .getUser());
		}

		@Override
		public Optional<Users> getUserByID(long id) {
			// TODO Auto-generated method stub
			 return userRepository.findById(id);
		}

		@Override
		public void changeUserPassword(Users user, String password) {
			// TODO Auto-generated method stub
			user.setPassword(passwordEncoder.encode(password));
	        userRepository.save(user);
			
		}

		@Override
		public boolean checkIfValidOldPassword(Users user, String oldPassword) {
			// TODO Auto-generated method stub
			return passwordEncoder.matches(oldPassword, user.getPassword());
		}

		@Override
		public String validateVerificationToken(String token) {
			// TODO Auto-generated method stub
			final VerificationToken verificationToken = tokenRepository.findByToken(token);
	        if (verificationToken == null) {
	            return TOKEN_INVALID;
	        }

	        final Users user = verificationToken.getUser();
	        final Calendar cal = Calendar.getInstance();
	        if ((verificationToken.getExpiryDate()
	            .getTime() - cal.getTime()
	            .getTime()) <= 0) {
	            tokenRepository.delete(verificationToken);
	            return TOKEN_EXPIRED;
	        }

	        user.setEnabled(true);
	     
	        userRepository.save(user);
	        return TOKEN_VALID;
		}

		@Override
		public String generateQRUrl(Users user) throws UnsupportedEncodingException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Users updateUser2FA(boolean use2fa) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<String> getUsersFromSessionRegistry() {
			// TODO Auto-generated method stub
			return sessionRegistry.getAllPrincipals()
		            .stream()
		            .filter((u) -> !sessionRegistry.getAllSessions(u, false)
		                .isEmpty())
		            .map(o -> {
		                if (o instanceof Users) {
		                    return ((Users) o).getEmail();
		                } else {
		                    return o.toString()
		            ;
		                }
		            }).collect(Collectors.toList());
		}

		@Override
		public void addUserLocation(Users user, String ip) {
			// TODO Auto-generated method stub
			
		}

}
