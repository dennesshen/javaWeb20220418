package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.entity.Person;

public class JPAService {
	private static EntityManagerFactory entityManagerFactory;
	protected  EntityManager entityManager;
	
	
	public JPAService() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("demo");
		}
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void addPerson(Person person) {
		
		synchronized (entityManager) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin(); // 事務處理開始
			entityManager.persist(person);
			entityTransaction.commit();
		}
	}
	
	public Person getPersonByID(Integer id) {
		
		return entityManager.find(Person.class, id);
		
	}
	
	public List<Person> queryAllPerson(){
		Query query = entityManager.createQuery("Select p from Person p"); //JPQL 語法
		List<Person> persons = query.getResultList();
		return persons;
	}
	
	public List<Person> queryPersonByAge(Integer age){
		Query query = entityManager.createQuery("Select p from Person p WHERE p.age= :age");
		query.setParameter("age", age);
		List<Person> persons = query.getResultList();
		return persons;
	}
	
	public List<Person> findAll(){
		return entityManager.createNamedQuery("Person.findAll").getResultList();
	}
	
	public List<Person> findByName(String name){
		return entityManager.createNamedQuery("Person.findByName")
							.setParameter("name", name)
							.getResultList();
	}
	
	public List<Person> findByAgeBetween(int min, int max){
		return entityManager.createNamedQuery("Person.findByAgeBetween")
							.setParameter("min", min)
							.setParameter("max", max)
							.getResultList();
	}
	
	
	
	
	
	
	
	
	
}
