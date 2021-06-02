package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Skill;

public interface SkillService {

	Result add(Skill skill);
}
