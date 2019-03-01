package it.nasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.nasa.model.Meta;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Integer> {

}
