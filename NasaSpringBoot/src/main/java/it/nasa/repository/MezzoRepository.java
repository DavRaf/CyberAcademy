package it.nasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.nasa.model.Mezzo;

@Repository
public interface MezzoRepository extends JpaRepository<Mezzo, Integer> {

}
