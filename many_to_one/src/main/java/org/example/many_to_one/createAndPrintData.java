package org.example.many_to_one;

import org.example.entity.Category;
import org.example.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;

public class createAndPrintData {
    public static void createData(SessionFactory sessionFactory) {
    	try (Session session = sessionFactory.openSession()){
    		
    		session.beginTransaction();
    		
    		Category p1 = new Category();
            p1.setCategorycode("ELEC1290");
            p1.setName("Electronics");

            List<Product> list = new ArrayList<>();

            Product add1 = new Product();
            add1.setProductcode("P198");
            add1.setProductname("Galaxy S21");
            add1.setProductprice(121000);
            add1.setProductbrand("Samsung");
            list.add(add1);

            Product add2 = new Product();
            add2.setProductcode("T123");
            add2.setProductname("QLed-2.0 4k TV");
            add2.setProductprice(60000);
            add2.setProductbrand("LG");
            list.add(add2);

            add1.setCategory(p1);
            add2.setCategory(p1);
            p1.setProducts(list);
            
            session.persist(p1);
            session.getTransaction().commit();           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printData(SessionFactory sessionFactory) {
    	try (Session session = sessionFactory.openSession()){
  	
            System.out.println("Category Details :  ");
            Category savedCategory = session.get(Category.class, 1L);
            System.out.println(savedCategory);
            System.out.println("Products Details :  ");
            List<Product> products = savedCategory.getProducts();
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
