package com.scp.hibernatemappings.onetoonebidirectpkjoincolumn;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.scp.hibernatemappings.onetoonebidirectpkjoincolumn.Address;
import com.scp.hibernatemappings.onetoonebidirectpkjoincolumn.HibernateUtil;
import com.scp.hibernatemappings.onetoonebidirectpkjoincolumn.Student;

public class Testonetoonebidirectpkjoincolumn
{
	public static void main(String[] args)
	{
		Student student1 = new Student("Mamesh", "MCA");
		Address address1 = new Address("SB road", "Pune", "India");
		
		/* ??
		address1.setAddressId(student1.getStudentId());
		student1.setStudentAddress(address1);
		*/
		
		
		/*SessionFactory sessionFactory1 = HibernateUtil.getSessionFactory();
		Session session1 = sessionFactory1.openSession();*/
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction1 = session1.beginTransaction();
		
		session1.persist(student1);
		
		address1.setAddressId(student1.getStudentId());
		student1.setStudentAddress(address1);
		session1.save(student1);
		//session1.save(address1);
		 
		
		transaction1.commit();
		session1.close();
		HibernateUtil.closeSessionFactory();
		
	}

}
