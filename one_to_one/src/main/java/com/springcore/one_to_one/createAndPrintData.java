package com.springcore.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springcore.entity.Passport;
import com.springcore.entity.Person;

public class createAndPrintData {
	
    public static void createData(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            
        	session.beginTransaction();

            Person person1 = new Person();
            person1.setPersonname("Ajay Karode");
            person1.setPersonemail("ajay.karode1212@accolite.com");
            
            Passport passport1 = new Passport();
            passport1.setPassportnumber("AK121212");
            passport1.setPerson(person1);
            person1.setPassportdetail(passport1);

            session.persist(person1);
            
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void printData(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            System.out.println("Person Details :");
            Person getPerson = session.get(Person.class, 1);
            System.out.println(getPerson);
            System.out.println("Passport Details : ");
            Passport getPassport = session.get(Passport.class, 1);
            System.out.println(getPassport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

