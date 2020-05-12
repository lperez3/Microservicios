package es.sopra.steria.mongo.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sopra.steria.mongo.dao.SkillRepository;
import es.sopra.steria.mongo.dto.SkillDto;
import es.sopra.steria.mongo.dto.SkillMapper;
import es.sopra.steria.mongo.entity.SkillEntity;
import es.sopra.steria.mongo.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private SkillMapper skillMapper;


	@Override
	public void deleteSkill(String id) throws Exception {
		skillRepository.findById(id).orElseThrow(Exception::new);
		skillRepository.deleteById(id);
	}

	@Override
	public void updateSkill(SkillDto skillDto, String id) throws Exception {
		if (!(skillDto.getDni().equalsIgnoreCase(id))) {
			System.out.println(!(skillDto.getDni().equalsIgnoreCase(id)));
			throw new Exception();
		}
		skillRepository.save(skillMapper.convertToEntity(skillDto));
	}

	@Override
	public Collection<SkillDto> getAllSkills() {
		List<SkillEntity> entities = skillRepository.findAll();
		return entities.stream()
				.map(skillMapper::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	public SkillDto getSkillById(String id) throws Exception {
		return skillRepository.findById(id)
				.map(skillMapper::convertToDto)
				.orElseThrow(Exception::new);
	}

	@Override
	public SkillDto createSkill(SkillDto skillDto) {
		skillRepository.findById(skillDto.getDni()).ifPresent((a) -> {throw new RuntimeException("Error creando skill");});
		return skillMapper.convertToDto(skillRepository.save(skillMapper.convertToEntity(skillDto)));
		
	}


}
