package it.epicode.be.segreteriarest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.segreteriarest.model.CorsoDiLaurea;
import it.epicode.be.segreteriarest.model.Studente;
import it.epicode.be.segreteriarest.repository.CorsoLaureaRepository;

@Service
public class CorsoDiLaureaService {
	
	
	@Autowired
	private CorsoLaureaRepository corsoRepo;
	
	
	public CorsoDiLaurea save(CorsoDiLaurea corso) {
		corsoRepo.save(corso);
		return corso;
	}
	
	public void delete(Long id) {
		corsoRepo.deleteById(id);
	}
	
	public CorsoDiLaurea update(Long id, CorsoDiLaurea corso) {
		Optional<CorsoDiLaurea> corsoResult = corsoRepo.findById(id);
		if (corsoResult.isPresent()) {
			CorsoDiLaurea update = corsoResult.get();
			update.setNome(corso.getNome());
			update.setCodice(corso.getCodice());
			update.setIndirizzo(corso.getIndirizzo());
			update.setNumeroEsami(corso.getNumeroEsami());
			update.setNumeroEsami(corso.getNumeroEsami());			
			return corsoRepo.save(update);
		}		
		return null; // TODO implementare eccezione relativa.
	}
	
	public Page<CorsoDiLaurea> findAll(Pageable pageable) {
		return corsoRepo.findAll(pageable);
	}
	
	public Optional<CorsoDiLaurea> findById(Long id) {
		return corsoRepo.findById(id);
	}

}
