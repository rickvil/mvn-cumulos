//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;


import java.util.List;

import com.softlogia.framework.domain.Role;
import com.softlogia.framework.domain.User;
//import com.softlogia.framework.entity.Usuario;
import com.softlogia.framework.model.SpringUtilLocal;
import com.softlogia.framework.model.dao.RoleDao;
import com.softlogia.framework.model.dao.impl.BaseDaoImpl;
import com.softlogia.framework.model.dao.impl.RoleDaoImpl;
import com.softlogia.framework.model.services.ProyectoServices;

public class Main {
	public static void main(String args[]) {
		/*SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session se = sessionFactory.openSession();
		Transaction tx = se.beginTransaction();
		se.createQuery("from Usuario").list();
		tx.commit();
		System.out.println(se.get(Usuario.class, new Long(1)));
		Usuario user= (Usuario)se.get(Usuario.class, new Long(1));
		se.close();
		Session se2 = sessionFactory.openSession();
		System.out.println(user.getUsuario());
		se2.update(user);
		System.out.println(user.getListaRoles());
		
		Usuario us=new Usuario();
		us.setId(new Long(77));
		us.setPassword("gg");
		us.setUsuario("NUEVO");
		Transaction th= se2.beginTransaction();
		se2.save(us);
		th.commit();
		se2.close();*/
		/*ProyectoServices proy=(ProyectoServices)SpringUtil.contexto.getBean("proyectoServices");
		User user= new User();
		user.setId(new Long(5));
		List<Role> lista =proy.getUserService().getRoleList(user);		
		for (int i=0;i<lista.size();i++){
			//Role rol=lista.get(i);
		//	System.out.println(lista.get(i));
		}
		Role rol= new Role();
		rol.setId(new Long(4));
		System.out.println(proy.getUserService().getRoleList(new User()));*/
		ProyectoServices proy=(ProyectoServices)SpringUtilLocal.contexto.getBean("proyectoServices");
		System.out.println(proy.getUserService().getRoleList(new Long(4)).size());
		proy.getUserService().removeRoleToUser(new Long(142), new Long(7));
		proy.getUserService().addRoleToUser(new Long(142), new Long(7));
		
			
	}
}
