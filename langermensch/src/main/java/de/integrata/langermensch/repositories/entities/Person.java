package de.integrata.langermensch.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// JPA
@Entity
@Table(name="tblpersonen")
public class Person {
	
	@Id
	@Column(length = 36, nullable = false)
	private String id;
	@Column(length = 30, nullable = true)
	private String vorname;
	@Column(length = 30, nullable = false)
	private String nachname;
	

}
