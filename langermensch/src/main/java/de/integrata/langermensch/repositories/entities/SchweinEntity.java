package de.integrata.langermensch.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.integrata.langermensch.repositories.entities.Person.PersonBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// JPA
@Entity
@Table(name="tblschweine")
public class SchweinEntity {
	@Id
	@Column(length = 36, nullable = false)
	@NotNull
	@Size(min=36, max=36)
	private String id;
	@NotNull
	@Size(min=2, max=30)
	@Column(length = 30, nullable = true)
	private String name;
	
	@DecimalMin(value="10", inclusive = true)
	private int gewicht;
}
