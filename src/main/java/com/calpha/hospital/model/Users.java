package com.calpha.hospital.model;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import org.apache.commons.codec.binary.Base32;
import org.jboss.aerogear.security.otp.api.Base32;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;

/**
*
* @author CAlpha
*/

@Entity
@Table(name = "users")
@Builder
public class Users {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "firstname")
	    private String firstName;

	    @Column(name = "lastname")
	    private String lastName;

	    @Column(name = "email", unique = true, nullable = false)
	    private String email;
	    
	    @Column(name = "phoneNo", nullable = false)
	    private String phoneNo;

	    
	    @Column(name = "username", nullable = false)
	    private String username;
	    
	    @Column(name = "password",length = 60, nullable = false)
	    @JsonIgnore
	    private String password;
	    
	    @Column(name = "RoleName")
	    private String roleName;
	    
	    @Column(name = "using2FA")
	    private boolean isUsing2FA;

	    @Column(name = "secretCode")
	    private String secret;
	    
	    @Column(name = "active", nullable =false)
	    private boolean isActive;

	   
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"))
	    private Collection<Role> roles;
	   

	
	  
	    @Column(name = "enabled", nullable =false)
	    private boolean enabled;
	 
	    public Users() { 
	    	
	    	super();
	        this.secret = Base32.random();
	        this.enabled = false;
	    }

		public Users(Long id, String firstName, String lastName, String email, String phoneNo, String username,
				String password, String roleName, boolean isUsing2FA, String secret, boolean isActive,
				Collection<Role> roles, boolean enabled) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNo = phoneNo;
			this.username = username;
			this.password = password;
			this.roleName = roleName;
			this.isUsing2FA = isUsing2FA;
			this.secret = secret;
			this.isActive = isActive;
			this.roles = roles;
			this.enabled = enabled;
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the phoneNo
		 */
		public String getPhoneNo() {
			return phoneNo;
		}

		/**
		 * @param phoneNo the phoneNo to set
		 */
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}

		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}

		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * @return the roleName
		 */
		public String getRoleName() {
			return roleName;
		}

		/**
		 * @param roleName the roleName to set
		 */
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

		/**
		 * @return the isUsing2FA
		 */
		public boolean isUsing2FA() {
			return isUsing2FA;
		}

		/**
		 * @param isUsing2FA the isUsing2FA to set
		 */
		public void setUsing2FA(boolean isUsing2FA) {
			this.isUsing2FA = isUsing2FA;
		}

		/**
		 * @return the secret
		 */
		public String getSecret() {
			return secret;
		}

		/**
		 * @param secret the secret to set
		 */
		public void setSecret(String secret) {
			this.secret = secret;
		}

		/**
		 * @return the isActive
		 */
		public boolean isActive() {
			return isActive;
		}

		/**
		 * @param isActive the isActive to set
		 */
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		/**
		 * @return the roles
		 */
		public Collection<Role> getRoles() {
			return roles;
		}

		/**
		 * @param roles the roles to set
		 */
		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
		}

		/**
		 * @return the enabled
		 */
		public boolean isEnabled() {
			return enabled;
		}

		/**
		 * @param enabled the enabled to set
		 */
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		@Override
		public int hashCode() {
			return Objects.hash(email);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Users other = (Users) obj;
			return Objects.equals(email, other.email);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Users [id=");
			builder.append(id);
			builder.append(", firstName=");
			builder.append(firstName);
			builder.append(", lastName=");
			builder.append(lastName);
			builder.append(", email=");
			builder.append(email);
			builder.append(", phoneNo=");
			builder.append(phoneNo);
			builder.append(", username=");
			builder.append(username);
			builder.append(", password=");
			builder.append(password);
			builder.append(", roleName=");
			builder.append(roleName);
			builder.append(", isUsing2FA=");
			builder.append(isUsing2FA);
			builder.append(", secret=");
			builder.append(secret);
			builder.append(", isActive=");
			builder.append(isActive);
			builder.append(", roles=");
			builder.append(roles);
			builder.append(", enabled=");
			builder.append(enabled);
			builder.append("]");
			return builder.toString();
		}
		
		
	    
	    
	   

}