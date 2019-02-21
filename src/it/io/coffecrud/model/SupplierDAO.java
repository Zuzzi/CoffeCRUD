package it.io.coffecrud.model;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.io.coffecrud.entity.Supplier;

public class SupplierDAO {

	public static EntityManager entitymanager;
	public static EntityManagerFactory emfactory;

	protected static void initEntityManager() {

		if (entitymanager == null) {
			emfactory = Persistence.createEntityManagerFactory("CoffeCRUDjpa");

		}

	}

	public static int save(Supplier s) {

		initEntityManager();
		entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(s);
		entitymanager.getTransaction().commit();
		entitymanager.close();

		return 1;
	}
	
	

	public static int update(Supplier s) {

		initEntityManager();
		entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Supplier sInTable = entitymanager.find(Supplier.class, s.getId());

		sInTable.setId(s.getId());
		sInTable.setName(s.getName());
		sInTable.setCountry(s.getCountry());
		entitymanager.persist(sInTable);
		entitymanager.getTransaction().commit();
		entitymanager.close();


		return 1;
	}
	
	

	public static int delete(String id) {

		initEntityManager();
		entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Supplier supplierToDelete = entitymanager.find(Supplier.class, Integer.parseInt(id));

		entitymanager.remove(supplierToDelete);
		entitymanager.getTransaction().commit();
		entitymanager.close();


		return 1;
	}
	
	
	

	public static List<Supplier> getAllSuppliers() {

		initEntityManager();
		entitymanager = emfactory.createEntityManager();
		//entitymanager.getTransaction().begin();
		TypedQuery<Supplier> query = entitymanager.createQuery("SELECT s FROM Supplier s", Supplier.class);
		List<Supplier> list = query.getResultList();
		//entitymanager.getTransaction().commit();
		entitymanager.close();


		return list;

	}
}