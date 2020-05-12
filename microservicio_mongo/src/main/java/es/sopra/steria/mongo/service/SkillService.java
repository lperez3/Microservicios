package es.sopra.steria.mongo.service;

import java.util.Collection;

import es.sopra.steria.mongo.dto.SkillDto;

public interface SkillService {


	public void deleteSkill(String id) throws Exception;

	public void updateSkill(SkillDto skillDto, String id) throws Exception;

	public Collection<SkillDto> getAllSkills();

	public SkillDto getSkillById(String id) throws Exception;

	public SkillDto createSkill(SkillDto skillDto);

}
