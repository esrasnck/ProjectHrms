package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.SkillService;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Skill;

@RestController
@CrossOrigin
@RequestMapping("api/skills")
public class SkillController {

	private SkillService skillService;

	@Autowired
	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Skill skill) {
		
		return this.skillService.add(skill);
	}
	//TODO test edilecek
	
	@PostMapping("/update")
	public Result update(@RequestBody Skill skill) {
		
		return this.skillService.update(skill);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Skill skill) {
		
		return this.skillService.delete(skill);
	}
}
