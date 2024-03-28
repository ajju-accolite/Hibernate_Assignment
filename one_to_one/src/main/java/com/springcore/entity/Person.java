package com.springcore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person_info")
public class Person {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        
    @Column(name = "personid")
    private int personid;

    @Column(name = "personname")
    private String personname;
    
    @Column(name="personemail")
    private String personemail;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passportid")
    
    private Passport passportdetail;

	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getPersonemail() {
		return personemail;
	}
	public void setPersonemail(String personemail) {
		this.personemail = personemail;
	}

	public Passport getPassportdetail() {
		return passportdetail;
	}
	public void setPassportdetail(Passport passportdetail) {
		this.passportdetail = passportdetail;
	}

	@Override
	public String toString() {
		return "Person [Person ID: " + personid + ", Person Name: " + personname + ", Person Email: " + personemail
				+ ", Passport ID: " + passportdetail.getPassportid() + "]";
	}  
}