package com.repository ;



import java.util.List ;


import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.Persistence ;


import com.entidad.Empleado ;


public class EmpleadoImplement implements EmpleadoInterface
{

				 private final EntityManagerFactory factory ;

				 public EmpleadoImplement ( )
				 {
									factory = Persistence.createEntityManagerFactory("Persist") ;
				 }

				 @ Override
				 public void agregarEmpleado ( Empleado e )
				 {
									EntityManager manager = factory.createEntityManager() ;
									manager.getTransaction().begin() ;
									manager.persist(e) ;
									manager.getTransaction().commit() ;

				 }

				 @ Override
				 public void actualizarEmpleado ( Empleado e )
				 {
									EntityManager manager = factory.createEntityManager() ;
									manager.getTransaction().begin() ;
									manager.merge(e) ;
									manager.getTransaction().commit() ;
				 }

				 @ Override
				 public Empleado obtenerEmpleado ( int id )
				 {
									EntityManager manager = factory.createEntityManager() ;
									return manager.find(Empleado.class, id) ;
				 }

				 @ Override
				 public void eliminarEmpleado ( Empleado e )
				 {

									EntityManager manager = factory.createEntityManager() ;
									Empleado em = manager.find(Empleado.class, e.getIdEmpleado()) ;

									if ( em != null )
									{
													 manager.getTransaction().begin() ;
													 manager.remove(e) ;
													 manager.getTransaction().commit() ;
									}
				 }

				 @ Override
				 public List<Empleado> listarEmpleados ( )
				 {
									EntityManager manager = factory.createEntityManager() ;

									return manager.createQuery("Select e from Empleado e",Empleado.class).getResultList() ;
				 }

}
