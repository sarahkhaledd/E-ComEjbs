package com.service;

import java.util.Objects;
import javax.ejb.MessageDriven;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ejbs.Course;
import com.ejbs.Student;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;

@MessageDriven(messageListenerInterface = MessageListener.class, activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "nsm/service"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")})

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageDrivenService implements MessageListener{//implements MyServiceInterface
	@PersistenceContext(unitName="hello")
    private EntityManager entityManager;
	@EJB//is injected into this bean
	StudentService s;
	String name;
	
	public String register(Course course)
	{
	   
		//System.out.println("lllllllllllllllllllllll"+name);
		TypedQuery<Student> query= entityManager.createQuery("SELECT s FROM Student s WHERE s.username = :name", Student.class);
		query.setParameter("name",  s.name);
		Student student1 = query.getSingleResult();
		if(course.getacademic_year()==student1.getAcademic_year())
		{
			student1.getList().add(course);
			entityManager.merge(student1);
			return "Registered Successfully. ";
		}
		System.out.println(Objects.nonNull(entityManager));
		return "fail. ";
	}

	@Override
	public void onMessage(Message message)
	{
		ObjectMessage objectMessage = (ObjectMessage) message;
		try {
			Course course = (Course) objectMessage.getObject();
			register(course);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
