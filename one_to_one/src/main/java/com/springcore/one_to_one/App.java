package com.springcore.one_to_one;
import org.hibernate.SessionFactory;
import com.springcore.config.HibernateUtils;

public class App {
	
    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public static void main(String[] args) {
        createAndPrintData.createData(sessionFactory);
        createAndPrintData.printData(sessionFactory);
    }
}
