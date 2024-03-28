package org.example.entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String courseCode;
    private String courseName;
    private int coursePrice;
      
    @ManyToMany(mappedBy = "course")
    private List<Student> student;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseCode;
	}
	public void setCourseId(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
    public String toString() {
        StringBuilder output = new StringBuilder("Course : [ " +
                "id - " + id + ", courseCode - " + courseCode + ", courseName - " + courseName +
                ", coursePrice - " + coursePrice +
                ", Student - ");

        for(Student stu : getStudent()){
        	output.append(stu.getStudentName()).append("-").append(stu.getRegistrationNumber()).append(", ");
        }
        output.append("]");
        return output.toString();
    }	
}