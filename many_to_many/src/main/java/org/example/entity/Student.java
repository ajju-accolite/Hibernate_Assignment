package org.example.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int registrationNumber;
    private String studentName;
    private String Stream;
    private long contactNumber;   

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Course> course;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getStudentName() {
		return studentName;
	}	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStream() {
		return Stream;
	}
	public void setStream(String stream) {
		Stream = stream;
	}

	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public List<Course> getCourse() {
        return course;
    }
    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Student: [" +
                "id - " + id +
                ", Student Name - " + studentName +
                ", Registration Number - " + registrationNumber +
                ", Stream - " + Stream +
                ", Contact Number - " + contactNumber +
                ", Course - ");

        for(Course c : getCourse()){
        	output.append(c.getCourseId()).append(" - ").append(c.getCourseName()).append(", ");
        }
        output.append("]");
        return output.toString();
    }
}