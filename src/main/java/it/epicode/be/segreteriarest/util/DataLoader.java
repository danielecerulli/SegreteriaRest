package it.epicode.be.segreteriarest.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteriarest.model.ArchivioDati;
import it.epicode.be.segreteriarest.model.CorsoDiLaurea;
import it.epicode.be.segreteriarest.model.Docente;
import it.epicode.be.segreteriarest.model.Libretto;
import it.epicode.be.segreteriarest.model.Studente;
import it.epicode.be.segreteriarest.repository.CorsoLaureaRepository;
import it.epicode.be.segreteriarest.repository.DocenteRepository;
import it.epicode.be.segreteriarest.repository.LibrettoRepository;
import it.epicode.be.segreteriarest.repository.StudenteRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

	@Autowired
	StudenteRepository studenteRepo;

	@Autowired
	CorsoLaureaRepository corsoRepo;

	@Autowired
	DocenteRepository docenteRepo;

	@Autowired
	LibrettoRepository librettoRepo;

	@Override
	public void run(String... args) throws Exception {
		
		// CORSI
		CorsoDiLaurea corso = new CorsoDiLaurea();
		corso.setCodice("A234");
		corso.setNome("Informatica");
		corso.setIndirizzo("Tecnologie per il Web");
		corso.setNumeroEsami(20);
		
		CorsoDiLaurea corso1 = new CorsoDiLaurea();
		corso1.setCodice("D457");
		corso1.setNome("Fisica");
		corso1.setIndirizzo("Studia le interazioni fisiche");
		corso1.setNumeroEsami(18);
		
		List<CorsoDiLaurea> corsiDocente = new ArrayList<>();
		corsiDocente.add(corso);
		
		List<CorsoDiLaurea> corsiDocente1 = new ArrayList<>();
		corsiDocente.add(corso1);
		
		// DOCENTI
		Docente docente = new Docente();
		docente.setNome("Gianni");
		docente.setCognome("Morandi");
		//docente.setCorsiDiLaurea(corsiDocente);
		//docenteRepo.save(docente);
		
		Docente docente1 = new Docente();
		docente1.setNome("Giorgio");
		docente1.setCognome("Giorgioni");
		//docente1.setCorsiDiLaurea(corsiDocente1);
		//docenteRepo.save(docente1);
		
		
		// STUDENTI
		Studente studente = new Studente();
		studente.setMatricola("BA345");
		studente.setNome("Mario");
		studente.setCognome("Rossi");
		studente.setDataNascita(LocalDate.parse("1999-12-21"));
		studente.setIndirizzo("Via Nazionale, 35");
		studente.setCitta("Roma");
		studente.setEmail("m.rossi@email.em");
		studente.setCorsoDiLaurea(corso);
		studente.setDocente(docente);
		
		log.info("Saved studente: " + studente.toString());
		//studenteRepo.save(studente);

		Studente studente1 = new Studente();
		studente1.setMatricola("AT281");
		studente1.setNome("Gianni");
		studente1.setCognome("Verdi");
		studente1.setDataNascita(LocalDate.parse("2001-10-11"));
		studente1.setIndirizzo("Via Canne, 5");
		studente1.setCitta("Latina");
		studente1.setEmail("g.verdi@email.em");
		studente1.setCorsoDiLaurea(corso1);
		studente1.setDocente(docente1);
		
		log.info("Saved studente: " + studente1.toString());
		//studenteRepo.save(studente1);
		
		// LIBRETTO
		Libretto libretto = new Libretto();
		libretto.setCodiceLibretto("ABC123ZZ");
		libretto.setStudente(studente);
		librettoRepo.save(libretto);
		log.info("Saved Libretto: " + libretto.toString());
		
		Libretto libretto1 = new Libretto();
		libretto1.setCodiceLibretto("DEF456ZZ");
		libretto1.setStudente(studente1);
		librettoRepo.save(libretto1);
		log.info("Saved Libretto: " + libretto1.toString());
	}
	
}
