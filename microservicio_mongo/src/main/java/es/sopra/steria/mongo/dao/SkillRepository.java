package es.sopra.steria.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.sopra.steria.mongo.entity.SkillEntity;

@Repository
public interface SkillRepository extends MongoRepository<SkillEntity,String>{

}
