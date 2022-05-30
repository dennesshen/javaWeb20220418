package jpa.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

import jpa.entity.Person;

@WebServlet("/jpa/person/query")
public class JPAQuerryServlet extends JPABaseServlet {
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Person person1 = jpaService.getPersonByID(1);
		List<Person> personsAll = jpaService.queryAllPerson();
		List<Person> personsByAge = jpaService.queryPersonByAge(10);
		List<Person> personsByNameQuery = jpaService.findAll();
		List<Person> personFindByName = jpaService.findByName("A%");
		List<Person> personFindByName2 = jpaService.findByName("%er");
		List<Person> personFindByName3 = jpaService.findByName("%M%");
		List<Person> personFindByAge = jpaService.findByAgeBetween(10, 30);

		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("get By ID \n"+ person1.toString()+"<p>");
		resp.getWriter().write("query All: \n" + personsAll +"</p>");
		resp.getWriter().write("query By Age: \n" + personsByAge +"</p>");
		
		resp.getWriter().write(personsByNameQuery +"</p>");
		resp.getWriter().write(personFindByName +"</p>");
		resp.getWriter().write(personFindByName2 +"</p>");
		resp.getWriter().write(personFindByName3 +"</p>");
		resp.getWriter().write(personFindByAge +"</p>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

}
