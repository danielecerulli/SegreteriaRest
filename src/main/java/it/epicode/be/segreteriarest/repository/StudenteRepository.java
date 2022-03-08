package it.epicode.be.segreteriarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.segreteriarest.model.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Long> {

}
