package com.softlogia.framework.model.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.softlogia.framework.domain.Role;
import com.softlogia.framework.domain.User;
import com.softlogia.framework.model.dao.RoleDao;
import com.softlogia.framework.model.dao.UserDao;

/**
 * Servicios disponibles para usuarios
 * 
 * @author Pablo Marquez
 * 
 */
public class UserService {
	private UserDao userDao;
	private RoleDao roleDao;

	/**
	 * Retorna la lista de usuarios con los criterios del usuarios enviado por
	 * parametro no se consideran los roles.
	 * 
	 * @param usuario
	 * @return
	 */
	public List<User> getUserList(User usuario) {
		return userDao.searchUsers(usuario);
	}

	/**
	 * Retorna lista de usuarios que cumplan con un rol determinado
	 * 
	 * @param rol
	 * @return
	 */
	public List<User> getUserList(Role rol) {
		return userDao.getUsersList(rol);
	}

	public User login(User user){
		User us;
		List<User> list=this.userDao.searchUsers(user);
		if (list.size()>0){
			us=list.get(0);
			return us;
		}else{
			return null;
		}
		
	}
	
	/**
	 * Agrega un rol a un usuario
	 * 
	 * @param idUser
	 * @param idRol
	 */
	public void addRoleToUser(Long idUser, Long idRol) {
		User user = new User();
		user.setId(idUser);
		List<Role> list = this.getRoleList(user);
		Role role = new Role();
		role.setId(idRol);
		list.add(role);
		Set<Role> setRoles = this.getRoleSetRich(list);
		user = this.getUserById(idUser);
		user.setRoleList(setRoles);
		this.updateUser(user);
	}

	/**
	 * Quita un rol a un usuario
	 * 
	 * @param idUser
	 * @param idRol
	 */
	public void removeRoleToUser(Long idUser, Long idRol) {
		User user = new User();
		user.setId(idUser);
		List<Role> list = this.getRoleList(user);
		Role role = new Role();
		role.setId(idRol);
		List<Role> newList=this.removeRol(idRol, list);
		Set<Role> setRoles = this.getRoleSetRich(newList);
		user = this.getUserById(idUser);
		user.setRoleList(setRoles);
		this.updateUser(user);
	}

	/**
	 * Retoma la lista de roles que el usuario no poseËÉé
	 * 
	 * @param idUser
	 * @return
	 */
	private List<Role> removeRol(Long idRol,List<Role> roles) {				
		List<Role> finalList = new ArrayList<Role>();
		for (int i = 0; i < roles.size(); i++) {
			if (roles.get(i).getId()!=null && (roles.get(i).getId()-idRol)!=0) {
				System.out.println(roles.get(i).getId());
				finalList.add(roles.get(i));
			}
		}
		return finalList;
	}
	
	/**
	 * Retoma la lista de roles que el usuario no pose�
	 * 
	 * @param idUser
	 * @return
	 */
	public List<Role> getUserRoleListNot(Long idUser) {
		List<Role> roles = this.roleDao.searchRoles(new Role());
		User user = new User();
		user.setId(idUser);
		List<Role> assignedRole = this.roleDao.searchRoles(user);
		List<Role> finalList = new ArrayList<Role>();
		for (int i = 0; i < roles.size(); i++) {
			if (!isInList(assignedRole, roles.get(i).getName())) {
				finalList.add(roles.get(i));
			}
		}
		return finalList;
	}

	private Boolean isInList(List<Role> listSource, String roleName) {
		for (int i = 0; i < listSource.size(); i++) {
			if (listSource.get(i).getName() != null
					&& listSource.get(i).getName().equalsIgnoreCase(roleName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna el usuario con el id especificado
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(Long id) {
		User user = new User();
		user.setId(id);
		List<User> listUser = userDao.searchUsers(user);
		if (listUser.size() > 0) {
			user = listUser.get(0);
		} else {
			user = null;
		}
		return user;
	}

	/**
	 * Almacena el usuario
	 * 
	 * @param usuario
	 * @return
	 */
	public int saveUser(User usuario) {
		userDao.save(usuario);
		return 0;
	}

	/**
	 * Actualiza el usuario
	 * 
	 * @param usuario
	 * @return
	 */
	public int updateUser(User usuario) {
		userDao.update(usuario);

		return 0;
	}

	/**
	 * Borra el usuario
	 * 
	 * @param usuario
	 * @return
	 */
	public int deleteUser(User usuario) {
		userDao.delete(usuario);
		return 0;
	}

	/**
	 * Retorna la lista de roles que cumplan con las caracteristicas del rol
	 * solo se considera el nombre del rol y los permisos
	 * 
	 * @param rol
	 * @return
	 */
	public List<Role> getRoleList(Role rol) {
		return roleDao.searchRoles(rol);
	}

	/**
	 * Returna la lista de roles de un usuario, se considera solamente el id del
	 * usuario.
	 * 
	 * @param user
	 * @return
	 */
	public List<Role> getRoleList(User user) {
		return this.roleDao.searchRoles(user);
	}

	/**
	 * Returna el Set de roles de un usuario, se considera solamente el id del
	 * usuario.
	 * 
	 * @param user
	 * @return
	 */
	public Set<Role> getRoleList(Long idUser) {
		User user = new User();
		user.setId(idUser);
		List<Role> lista = this.roleDao.searchRoles(user);
		Set<Role> set = new HashSet<Role>();
		for (int i = 0; i < lista.size(); i++) {
			set.add(lista.get(i));
		}
		return set;
	}
/**
 * Metodo para implemetacion con Primefaces
 * @param list
 * @return
 */
	public Set<Role> getRoleSet(List<Role> list) {
		Set<Role> set = new HashSet<Role>();
		for (int i = 0; i < list.size(); i++) {
			Role rol = new Role();
			Object valor = (Object) list.get(i);
			String texto = (String) valor;
			rol.setId(Long.parseLong(texto));
			set.add(rol);
		}
		return set;
	}
	/**
	 * Metodo para implementacion con richFaces
	 * @param list
	 * @return
	 */
	public Set<Role> getRoleSetRich(List<Role> list) {
		Set<Role> set = new HashSet<Role>();
		for (int i = 0; i < list.size(); i++) {
			Role rol = new Role();
			rol.setId(list.get(i).getId());
			set.add(rol);
		}
		return set;
	}

	/**
	 * Almacena el rol
	 * 
	 * @param rol
	 * @return
	 */
	public int saveRol(Role rol) {
		roleDao.save(rol);
		return 0;
	}

	/**
	 * Actualiza el rol
	 * 
	 * @param rol
	 * @return
	 */
	public int updateRol(Role rol) {
		roleDao.update(rol);
		return 0;
	}

	/**
	 * Elimina el rol
	 * 
	 * @param rol
	 * @return
	 */
	public int deleteRol(Role rol) {
		roleDao.delete(rol);
		return 0;
	}

	// METODOS GETTER Y SETTER PARA DAOs
	/**
	 * Accede al dao, no se recomienda su uso. Empleado para inyecci�n de
	 * dependencias con Spring Framework
	 * 
	 * @return
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * Accede al dao, no se recomienda su uso. Empleado para inyecci�n de
	 * dependencias con Spring Framework
	 * 
	 * @return
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * Accede al dao, no se recomienda su uso. Empleado para inyecci�n de
	 * dependencias con Spring Framework
	 * 
	 * @param userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * Accede al dao, no se recomienda su uso. Empleado para inyecci�n de
	 * dependencias con Spring Framework
	 * 
	 * @param rolDao
	 */
	public void setRoleDao(RoleDao rolDao) {
		this.roleDao = rolDao;
	}

}
