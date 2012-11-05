/**
 * Copyright Softlogia S.R.L.
 */
package com.softlogia.framework.domain;



import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Pablo Marquez
 *
 */
public class User  extends BaseDomain{


     private Long id;     
     private String user;
     private String password;
     private Set<Role> roleList = new HashSet<Role>(0);

	public User() {
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	
    public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


