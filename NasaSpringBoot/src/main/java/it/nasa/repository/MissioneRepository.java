package it.nasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.nasa.model.Missione;

@Repository
public interface MissioneRepository extends JpaRepository<Missione, Integer> {

}
