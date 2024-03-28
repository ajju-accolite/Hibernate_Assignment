package com.springcore.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "passport_info")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "passportid")
    private int passportid;
    @Column(name = "passportnumber")
    private String passportnumber;
    @OneToOne(mappedBy = "passportdetail", cascade = CascadeType.ALL)
     
    private Person person;
    
	public int getPassportid() {
		return passportid;
	}
	public void setPassportid(int passportid) {
		this.passportid = passportid;
	}

	public String getPassportnumber() {
		return passportnumber;
	}
	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [Passport ID: " + passportid + ", Passport Number :" + passportnumber + ", Person Name :" + person.getPersonname() + "]";
	}
    
    

	
	
}