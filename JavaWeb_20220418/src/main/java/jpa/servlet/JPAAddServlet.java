package jpa.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

import jpa.entity.Person;

@WebServlet("/jpa/person/add")
public class JPAAddServlet extends JPABaseServlet {
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = new Faker().name().fullName();
		int age = new Random().nextInt(30)+10;
		
		Person person = new Person(name, age);
		jpaService.addPerson(person);
		
		resp.getWriter().write(person.toString());
		
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
