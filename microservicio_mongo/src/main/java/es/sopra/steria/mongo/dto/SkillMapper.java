package es.sopra.steria.mongo.dto;

import org.springframework.stereotype.Component;

import es.sopra.steria.mongo.entity.SkillEntity;

@Component
public class SkillMapper {

	
	public SkillEntity convertToEntity(SkillDto skillDto) {
		SkillEntity entity = new SkillEntity();
		entity.setDni(skillDto.getDni());
		entity.setSkills(skillDto.getSkills());
		return entity;
	}
	
	public SkillDto convertToDto(SkillEntity skillEntity) {
		
		SkillDto dto= new SkillDto();
		dto.setDni(skillEntity.getDni());
		dto.setSkills(skillEntity.getSkills());
		
		return dto;
	}
}
