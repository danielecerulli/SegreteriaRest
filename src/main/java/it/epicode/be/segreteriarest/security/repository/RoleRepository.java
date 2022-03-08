package it.epicode.be.segreteriarest.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.segreteriarest.security.model.Role;
import it.epicode.be.segreteriarest.security.model.Roles;


public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByRoleName(Roles role);
}
