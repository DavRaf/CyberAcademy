package it.nasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.nasa.model.CapoProgetto;

@Repository
public interface CapoProgettoRepository extends JpaRepository<CapoProgetto, Integer> {

}
