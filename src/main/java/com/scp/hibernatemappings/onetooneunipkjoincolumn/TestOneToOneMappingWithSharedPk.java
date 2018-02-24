//one to one unidirectional mapping with shared primary key using @PrimaryKeyJoinColumn

package com.scp.hibernatemappings.onetooneunipkjoincolumn;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestOneToOneMappingWithSharedPk
{
	public static void main(String[] args)
	{
		
		/*
		 * First create student object.(student id is automatically generated. Here student address is null.)
		 * Then create address object(address id is null.)
		 * Then set address id = student id(Here address object becomes complete object, means all fields are initialized.)
		 * Now assign address object to student object.
		 * 
		 * This is called one to one mapping with shared primary key.
		 * This is done by using  @PrimaryKeyJoinColumn  annotation.
		 * 
		 */
		
		
		Student student1 = new Student("Mamesh", "MCA");
		Address address1 = new Address("SB road", "Pune", "India");
		
		 
		/*address1.setAddressId(student1.getStudentId());
		student1.setStudentAddress(address1);*/
		
		
		
		/*SessionFactory sessionFactory1 = HibernateUtil.getSessionFactory();
		Session session1 = sessionFactory1.openSession();*/
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction1 = session1.beginTransaction();
		
		session1.persist(student1);
		//session1.persist(address1);
		
		address1.setAddressId(student1.getStudentId());
		student1.setStudentAddress(address1);
		session1.save(student1);
		//session1.save(address1);
		 
		
		
		transaction1.commit();
		session1.close();
		HibernateUtil.closeSessionFactory();
	}

}
