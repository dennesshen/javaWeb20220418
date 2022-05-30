package jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
@NamedQueries({
	@NamedQuery(name="Person.findAll", query = "select p from Person p"),
	@NamedQuery(name="Person.findByName", query = "select p from Person p where p.name like :name"),
	@NamedQuery(name="Person.findByAgeBetween", query = "select p from Person p where p.age between :min and :max"),
})
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@Column(name = "name", nullable = false, length = 50, unique = true )
	private String name;
	
	@Column(name = "age")
	private int age;
	
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
