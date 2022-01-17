package com.calpha.hospital.model;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
*
* @author CAlpha
*/

@Entity
@Table(name = "roles")
public class Role {

   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private Long roleId;

    @Column(name = "roleName")
    private String roleName;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Collection<Users> users;
    
    @ManyToMany
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Role(final String roleName) {
        super();
        this.roleName = roleName;
    }
    
    
    public Role(Long roleId, String roleName, Collection<Users> users, Collection<Privilege> privileges) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.users = users;
		this.privileges = privileges;
	}


	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}


	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
	 * @return the users
	 */
	public Collection<Users> getUsers() {
		return users;
	}


	/**
	 * @param users the users to set
	 */
	public void setUsers(Collection<Users> users) {
		this.users = users;
	}


	/**
	 * @return the privileges
	 */
	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	/**
	 * @param privileges the privileges to set
	 */
	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        return result;
  
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(roleName, other.roleName);
	}


	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + ", privileges=" + privileges
				+ "]";
	}


	
    
    

   
}
