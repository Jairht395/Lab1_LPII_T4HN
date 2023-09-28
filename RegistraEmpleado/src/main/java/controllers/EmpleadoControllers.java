package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;
public class EmpleadoControllers {

	public String createEmpleado(String apellidos, String nombres, int edad, String sexo, double salario) 
	{
		SessionFactory sessionFactory = new Configuration().configure("empleado.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try 
		{
			Empleado empleado = new Empleado(apellidos,nombres,edad,sexo,salario);
			
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado creado";
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "Error al registrar empleado";
	}

	public String deleteEmpleado(int idempleado)
	{
		SessionFactory sessionFactory = new Configuration().configure("empleado.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			session.delete(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado eliminado correctamente";
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return "Error al eliminar empleado";
	}

	public String updateEmpleado(int idempleado, String apellidos) 
	{
		SessionFactory sessionFactory = new Configuration().configure("empleado.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			
			empleado.setApellido(apellidos);
			session.update(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Empleado actualizado correctamente";
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return "Error al actualizar empleado";
	}

	//Obtener o Leer empleado
	public String getEmpleado(int idempleado) 
	{
		SessionFactory sessionFactory = new Configuration().configure("empleado.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		try {
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado encontrado";
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return "Empleado no encontrado";
	}
}