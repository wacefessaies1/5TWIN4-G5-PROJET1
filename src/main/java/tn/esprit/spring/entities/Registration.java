package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Registration implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long numRegistration;
	int numWeek;

	@JsonIgnore
	@ManyToOne
    Skier skier;
	@JsonIgnore
	@ManyToOne
	Course course;
	
	public Long getNumRegistration() {
		return numRegistration;
	}
	public void setNumRegistration(Long numRegistration) {
		this.numRegistration = numRegistration;
	}
	public int getNumWeek() {
		return numWeek;
	}
	public void setSkier(Skier skier) {
		this.skier = skier;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void setNumWeek(int numWeek) {
		this.numWeek = numWeek;
	}
	public Skier getSkier() {
		return skier;
	}
	public Course getCourse() {
		return course;
	}
}
