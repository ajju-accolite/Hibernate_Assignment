package org.example.many_to_many;
import java.util.ArrayList;
import java.util.List;
import org.example.config.HibernateUtils;
import org.example.entity.Course;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App{
	public static void main(String[] args){
	
	Student student1 = new Student();
	student1.setRegistrationNumber(425);
	student1.setStudentName("Ajay Karode");
	student1.setStream("PCM");
	student1.setContactNumber(2378932479L);
    
    Student student2 = new Student();
    student2.setRegistrationNumber(430);
    student2.setStudentName("Himanshu Kumar");
    student2.setStream("Commerce");
    student2.setContactNumber(2385719903L);
		
	List<Student> studentList1 = new ArrayList<>();
	List<Student> studentList2 = new ArrayList<>();
	List<Student> studentList3 = new ArrayList<>();
	
	studentList1.add(student1);
    studentList2.add(student2);
    studentList3.add(student1);
    studentList3.add(student2);
       
    Course m1 = new Course();
    m1.setCourseId("GS231");
    m1.setCourseName("React for Beginners");
    m1.setCoursePrice(6000);

    Course m2 = new Course();
    m2.setCourseId("WS422");
    m2.setCourseName("Angular Development");
    m2.setCoursePrice(9000);
       
    Course m3 = new Course();
    m3.setCourseId("DB351");
    m3.setCourseName("Hibernate");
    m3.setCoursePrice(4000);
 
    List<Course> courseList1 = new ArrayList<>();
    List<Course> courseList2 = new ArrayList<>();
    
    courseList1.add(m1);
    courseList1.add(m3);  
    courseList2.add(m2);
    courseList2.add(m3);

    student1.setCourse(courseList1);
    student2.setCourse(courseList2);
  
    m1.setStudent(studentList1);
    m2.setStudent(studentList2);
    m3.setStudent(studentList3);
     
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    session.persist(student1);
    session.persist(student2);
    session.persist(m1);
    session.persist(m2);
    session.persist(m3);
    session.getTransaction().commit();

    System.out.println("Student :  ");
    Student studentData1 = session.get(Student.class, 1L);
    System.out.println(studentData1);

    Student studentData2 = session.get(Student.class, 2L);
    System.out.println(studentData2);

    System.out.println("Course :  ");
    Course c1 = session.get(Course.class, 1L);
    System.out.println(c1);

    Course c2 = session.get(Course.class, 2L);
    System.out.println(c2);
        
    Course c3 = session.get(Course.class, 3L);
    System.out.println(c3);

    session.close();
	}
}