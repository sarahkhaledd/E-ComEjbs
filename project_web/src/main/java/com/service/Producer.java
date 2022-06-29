package com.service;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.persistence.TypedQuery;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.ejbs.Course;
import com.ejbs.Student;

@Path("/ProducerServices")
public class Producer
{
	@Resource(lookup = "java:/nsm/service")
	private Queue queue;
	@Resource(lookup = "java:jboss/DefaultJMSConnectionFactory")
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @POST
	@Path("/services")
	public String services(Course course)
	{
    	JMSContext context = connectionFactory.createContext();
        context.createProducer().send(queue, (Serializable) course);
        context.close();
		return "ok";
	}
}