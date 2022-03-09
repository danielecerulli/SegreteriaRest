package it.epicode.be.segreteriarest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Libretto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codiceLibretto;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // TOGLIERE i Cascades dalle relazioni per fare i save singoli
	@JoinColumn(name = "studente_id", referencedColumnName = "id")
	private Studente studente;

}
