package it.epicode.be.segreteriarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.segreteriarest.model.Studente;
import it.epicode.be.segreteriarest.repository.StudenteRepository;

@Service
public class StudenteService {

	@Autowired
	private StudenteRepository studenteRepo;

	public Studente save(Studente studente) {
		studenteRepo.save(studente);
		return studente;
	}

	public void delete(Long id) {
		studenteRepo.deleteById(id);
	}

	public Studente update(Long id, Studente studente) {
		Optional<Studente> studenteResult = studenteRepo.findById(id);
		if (studenteResult.isPresent()) {
			Studente update = studenteResult.get();
			update.setNome(studente.getNome());
			update.setCognome(studente.getCognome());
			update.setCitta(studente.getCitta());
			update.setEmail(studente.getEmail());
			update.setIndirizzo(studente.getIndirizzo());
			update.setDataNascita(studente.getDataNascita());
			update.setMatricola(studente.getMatricola());
			update.setCorsoDiLaurea(studente.getCorsoDiLaurea());
			return studenteRepo.save(update);
		}
		return null; // TODO implementare eccezione relativa.
	}

	public Page<Studente> findAll(Pageable pageable) {
		return studenteRepo.findAll(pageable);
	}

	public List<Studente> findAll() {
		return studenteRepo.findAll();
	}

	public Optional<Studente> findById(Long id) {
		return studenteRepo.findById(id);
	}

}
