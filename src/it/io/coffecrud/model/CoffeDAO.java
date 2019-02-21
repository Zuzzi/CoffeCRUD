package it.io.coffecrud.model;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.io.coffecrud.entity.Coffees;



public class CoffeDAO {

	public static EntityManager entitymanager;
	public static EntityManagerFactory emfactory;

	protected static void initEntityManager() {

		if (entitymanager == null) {
			emfactory = Persistence.createEntityManagerFactory("CoffeCRUDjpa");

		}

	}

	public static int save(Coffees coffe) {

		initEntityManager();
		entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(coffe);
		entitymanager.getTransaction().commit();
		entitymanager.close();

		return 1;
	}

	public static int update(Coffees e) {

		initEntityManager();
		entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Coffees eInTable = entitymanager.find(Coffees.class, e.getCofName());

		eInTable.setSupId(e.getSupId());
		eInTable.setPrice(e.getPrice());
		eInTable.setSales(e.getSales());
		eInTable.setTotal(e.getTotal());
		entitymanager.persist(eInTable);
		entitymanager.getTransaction().commit();
		entitymanager.close();


		return 1;
	}

	public static int delete(String cofName) {

		initEntityManager();
		entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Coffees coffeToDelete = entitymanager.find(Coffees.class, cofName);

		entitymanager.remove(coffeToDelete);
		entitymanager.getTransaction().commit();
		entitymanager.close();


		return 1;
	}

	public static List<Coffees> getAllCoffees() {

		initEntityManager();
		entitymanager = emfactory.createEntityManager();
		//entitymanager.getTransaction().begin();
		TypedQuery<Coffees> query = entitymanager.createQuery("SELECT c FROM Coffees c", Coffees.class);
		List<Coffees> list = query.getResultList();
		//entitymanager.getTransaction().commit();
		entitymanager.close();


		return list;

	}
}