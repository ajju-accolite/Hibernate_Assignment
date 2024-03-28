package Hibernate_Session.Hibernate_session;

import entity.Employee;
//import many_to_many.Course;
//import many_to_many.Student;
//import many_to_one.Category;
//import many_to_one.Product;
//import one_to_many.Player;
//import one_to_many.Team;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import configurations.HibernateUtils;

public class App 
{
    public static void main( String[] args )
    {
        Employee employee = new Employee();
        employee.setEmpName("Ajay Karode");
        employee.setEmpEmail("ajay.karode@accolitedigital.com");

        Employee employee2 = new Employee();       
        employee2.setEmpName("Nitin Gurjar");
        employee2.setEmpEmail("nitin.gurjar@accolitedigital.com");
        
        Employee employee3  = new Employee();
        employee3.setEmpName("Abhi Yadav");
        employee3.setEmpEmail("abhi.yadav@accolitedigital.com");

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(employee);
        session.persist(employee2);
        session.persist(employee3);

        session.getTransaction().commit();

        System.out.println("After Commiting : ");
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        session.close();
        
        System.out.println("---------------------------------------------------------------");
        System.out.println("Session 2: ");
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        	
        //read
        Employee empData = session2.get(Employee.class, 1L);
        System.out.println(empData);

        //update
        empData.setEmpEmail("ajay.karode1212@accolitedigital.com");
        session2.merge(empData);

        session2.createQuery("from Employee", Employee.class).list().forEach(System.out::println);

        //delete
        Employee emp = session2.get(Employee.class, 2L);
        System.out.println("Deleting Employee : " + emp.getEmpName());
        session2.remove(emp);
        session2.getTransaction().commit();        
        session2.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        session2.close();
        
        System.out.println("---------------------------------------------------------------");
        
     // Creating sample data
        Session session3 = sessionFactory.openSession();
        session3.beginTransaction();
      
    }
}










