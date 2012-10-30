package com.softlogia.framework.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Pablo Marquez
 *
 */
public class Role  extends BaseDomain{


     private Long id;
     private String name;
     private String permissions;
     private Set<User> usersList=new HashSet<User>(0);
     

    public Role() {
    }

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Set<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(Set<User> usersList) {
		this.usersList = usersList;
	}

	
	public void setUserList(List<User> lista){
		
	}
public List<User> getUserList(List<User> lista){
		return new ArrayList<User>();
	}
	

}


