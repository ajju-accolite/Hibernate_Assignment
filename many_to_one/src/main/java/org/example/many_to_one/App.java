package org.example.many_to_one;

import org.example.config.HibernateUtils;
import org.hibernate.SessionFactory;

public class App {
	private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    public static void main(String[] args) {
      	
    	createAndPrintData.createData(sessionFactory);
    	createAndPrintData.printData(sessionFactory);
    }
}
