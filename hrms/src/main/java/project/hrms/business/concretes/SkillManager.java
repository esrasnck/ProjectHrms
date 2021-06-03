package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.SkillService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.dataAccess.abstracts.SkillDao;
import project.hrms.entities.concretes.Skill;

@Service("SkillManager")
public class SkillManager implements SkillService {

	
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return null;
	}

	@Override
	public DataResult<List<Skill>> getAllByCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAllByCandidate_Id(candidateId));
	}
	
	
}
