/**
 * 
 */
package com.calpha.hospital;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.calpha.hospital.model.Users;
import com.calpha.hospital.repository.UserRepository;

/** 
 * @author CAlpha
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {
	 
	 @Autowired
	  private TestEntityManager entityManager;
	
	 @Autowired
	  UserRepository repository;
	 

	 @Test
	  public void should_find_no_users_if_repository_is_empty() {
	    Iterable<Users> users = repository.findAll();

	    assertThat(users).isEmpty();
	  }

	  @Test
	  public void should_store_a_user() {
		  Users users = repository.save(new Users("Okoro", "Johnson","okoro@gmail.com","08030008791","okorojohnson","okoro@1234",true,"Patient"));

	    assertThat(users).hasFieldOrPropertyWithValue("firstName", "Okoro");
	    assertThat(users).hasFieldOrPropertyWithValue("lastName", "Johnson");
	    assertThat(users).hasFieldOrPropertyWithValue("email", "okoro@gmail.com");
	    assertThat(users).hasFieldOrPropertyWithValue("phoneNo", "08030008791");
	    assertThat(users).hasFieldOrPropertyWithValue("username", "okorojohnson");
	    assertThat(users).hasFieldOrPropertyWithValue("password", "okoro@1234");
	    assertThat(users).hasFieldOrPropertyWithValue("active", true);
	    assertThat(users).hasFieldOrPropertyWithValue("roleName", "Patient");
	  
	  }

	  @Test
	  public void should_find_all_users() {
	    Users user1 = new Users("Austin", "Bello","bello@gmail.com","08000000001","Austino","ustin1@#1", true,"Doctor");
	    entityManager.persist(user1);

	    Users user2 = new  Users("Chisom", "Joy","chisom@gmail.com","08200000001","chijoy","chi@#1", true,"Nurse");
	    entityManager.persist(user2);

	    Users user3 = new Users("Antony", "Collins","anto@gmail.com","09000000001","Anto4567","12345678", true,"Doctor");
	    entityManager.persist(user3);

	    Iterable<Users> users = repository.findAll();

	    assertThat(users).hasSize(3).contains(user1, user2, user3);
	  }

	  @Test
	  public void should_find_tutorial_by_id() {
	    Users user1 = new Users("AustinJon", "BelloC","belloC@gmail.com","08200030001","AustinoC","Austin1@#1", false,"Doctor");
	    entityManager.persist(user1);

	    Users user2 = new Users("Cola", "Adebola","cola@gmail.com","08212310004","cola","cola@#1",true,"Doctor");
	    entityManager.persist(user2);

	   Users foundUser = repository.findById(user2.getId()).get();

	    assertThat(foundUser).isEqualTo(user2);
	  }

	  @Test
	  public void should_find_active_users() {
		  Users user1 = new Users("Samson", "Paulson","samson@gmail.com","07012345670","sam","sam@#1", true,"Nurse");
	    entityManager.persist(user1);

	    Users user2 = new Users("Samuel", "Jonson","samuel@gmail.com","09012330000","samjohn","samjohn@#1", true,"Doctor");
	    entityManager.persist(user2);

	    Users user3 = new Users("Nelson", "Isabela","nelson@gmail.com","07212310004","isanelson","nelson@#1", true,"Doctor");
	    entityManager.persist(user3);

	    Iterable<Users> users = repository.findByActive(true);

	    assertThat(users).hasSize(2).contains(user1, user3);
	  }

	  @Test
	  public void should_find_users_by_firstName_containing_string() {
	    Users user1 = new Users("Ada", "Paul","ada@gmail.com","07032345670","adapaul","sam@#1", true,"Nurse");
	    entityManager.persist(user1);

	    Users user2 = new Users("Clinton", "Kingson","clinton@gmail.com","08212345670","clinton1","sam@#1", true,"Nurse");
	    entityManager.persist(user2);

	    Users user3 = new Users("Samuelson", "Paulin","samu@gmail.com","09012345670","samuel","sam@#1", true,"Nurse");
	    entityManager.persist(user3);

	    Iterable<Users> users = repository.findByFirstNameIgnoreCaseContaining("Samuelson");

	    assertThat(users).hasSize(2).contains(user1, user3);
	  }

	  @Test
	  public void should_update_user_by_id() {
		  Users user1 = new Users("Samson", "Paulson","samson@gmail.com","04032345670","sam","sam@#1", true,"Nurse");
	    entityManager.persist(user1);

	    Users user2 = new Users("Santus", "Dominum","santus@gmail.com","07072345670","dom","dom@#1", true,"Patient");
	    entityManager.persist(user2);

	    Users updatedUser = new Users("Chanon", "Patrick","chanon@gmail.com","02012345670","chanonPat","chanon@#1", true,"Doctor");

	    Users user = repository.findById(user2.getId()).get();
	    user.setFirstname(updatedUser.getFirstName());
	    user.setLastname(updatedUser.getLastName());
	    user.setUsername(updatedUser.getUsername());
	    user.setEmail(updatedUser.getEmail());
	    user.setPhoneNo(updatedUser.getPhoneNo());
	    user.setRoleName(updatedUser.getRoleName());
	    user.setActive(updatedUser.isActive());
	    repository.save(user);

	    Users checkUser = repository.findById(user2.getId()).get();
	    
	    assertThat(checkUser.getId()).isEqualTo(user2.getId());
	    assertThat(checkUser.getFirstName()).isEqualTo(updatedUser.getFirstName());
	    assertThat(checkUser.getLastName()).isEqualTo(updatedUser.getLastName());
	    assertThat(checkUser.getUsername()).isEqualTo(updatedUser.getUsername());
	    assertThat(checkUser.getEmail()).isEqualTo(updatedUser.getEmail());
	    assertThat(checkUser.getPhoneNo()).isEqualTo(updatedUser.getPhoneNo());
	    assertThat(checkUser.getRoleName()).isEqualTo(updatedUser.getRoleName());
	    assertThat(checkUser.isActive()).isEqualTo(updatedUser.isActive());
	  }

	  @Test
	  public void should_delete_tutorial_by_id() {
		  Users user1 = new Users("Cahil", "Sise","cahil@gmail.com","01012675670","calsise","cahil@#1", true,"Nurse");
	    entityManager.persist(user1);

	    Users user2 = new Users("Cahil", "Sise","cahil@gmail.com","01012675670","calsise","cahil@#1", true,"Nurse");
	    entityManager.persist(user2);

	    Users user3 = new Users("Cahil", "Sise","cahil@gmail.com","01012675670","calsise","cahil@#1", true,"Nurse");
	    entityManager.persist(user3);

	    repository.deleteById(user2.getId());

	    Iterable<Users> users = repository.findAll();

	    assertThat(users).hasSize(2).contains(user1, user3);
	  }

	  @Test
	  public void should_delete_all_users() {
	    entityManager.persist(new Users("Cahil2", "Sise","cahil@gmail.com","01012675670","calsise","cahil@#1", true,"Nurse"));
	    entityManager.persist(new Users("Smith", "Wilson","Smith@gmail.com","08012675670","calsise","smith@#1", true,"Doctor"));

	    repository.deleteAll();

	    assertThat(repository.findAll()).isEmpty();
	  }

}
