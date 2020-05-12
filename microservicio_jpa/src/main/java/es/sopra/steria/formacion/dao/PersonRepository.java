package es.sopra.steria.formacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.sopra.steria.formacion.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {

}
