package de.integrata.langermensch.services.models;

import de.integrata.langermensch.repositories.entities.SchweinEntity;
import de.integrata.langermensch.repositories.entities.SchweinEntity.SchweinEntityBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schwein {

	@Setter(value = AccessLevel.PRIVATE)
	private String id;
	private String name;
	@Setter(value = AccessLevel.PRIVATE)
	private int gewicht;
	
	public void fressen() {
		setGewicht(getGewicht() + 1); 
	}
}
