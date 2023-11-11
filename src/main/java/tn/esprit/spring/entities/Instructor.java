package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long numInstructor;
	String firstName;
	String lastName;
	Date dateOfHire;
	@OneToMany
	Set<Course> courses;
	
	public Instructor() {
		super();
	}
	public Instructor(String firstName, String lastName, Date dateOfHire, Set<Course> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfHire = dateOfHire;
		this.courses = courses;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Long getNumInstructor() {
		return numInstructor;
	}
	public void setNumInstructor(Long numInstructor) {
		this.numInstructor = numInstructor;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfHire() {
		return dateOfHire;
	}
	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}
	
}
