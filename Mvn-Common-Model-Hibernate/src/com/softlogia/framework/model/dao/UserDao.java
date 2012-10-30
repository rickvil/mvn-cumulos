package com.softlogia.framework.model.dao;

import java.util.List;

import com.softlogia.framework.domain.Role;
import com.softlogia.framework.domain.User;
/**
 * 
 * @author Pablo Marquez
 *
 */
public interface UserDao extends BaseDao<User>{
	/**
	 * Devuelve la lista de usuarios que cumplan con los criterios de user
	 * @param usuario
	 * @return
	 */
	public List<User> searchUsers(User usuario);
	/**
	 * Devuelve la ista de usuarios que cumplan con un rol 
	 * @param rol
	 * @return
	 */
	public List<User> getUsersList(Role rol);
}
