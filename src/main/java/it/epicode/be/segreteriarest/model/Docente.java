package it.epicode.be.segreteriarest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	
	/*@ManyToMany
	@JoinTable(name = "docente_corso", 
					joinColumns = @JoinColumn(name = "docente_id"),
					inverseJoinColumns = @JoinColumn(name = "corso_id")
			  )
	private List<CorsoDiLaurea> corsiDiLaurea;*/ // SCOMMENTA PER FARE I SAVE SINGOLARMENTE
	
	@OneToMany(mappedBy = "docente")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private List<Studente> studenti; // COMMENTA PER FARE I SAVE SINGOLARMENTE
}
