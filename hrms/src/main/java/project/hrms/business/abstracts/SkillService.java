package project.hrms.business.abstracts;

import java.util.*;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Skill;

public interface SkillService {

	Result add(Skill skill);
	
	DataResult<List<Skill>> getAllByCandidateId(int candidateId);
}
