package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobExperienceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobExperienceDao;
import project.hrms.entities.concretes.JobExperience;

@Service("JobExperienceManager")
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperineceDao;
	
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperineceDao) {
		super();
		this.jobExperineceDao = jobExperineceDao;
	}



	@Override
	public Result add(JobExperience jobExperinence) {
		this.jobExperineceDao.save(jobExperinence);
		return new SuccessResult("Job Experience added !");
	}



	@Override
	public DataResult<List<JobExperience>> findAllByCandidateIdOrderByResignationTimeDesc(int candidateId) {
	
		return new SuccessDataResult<List<JobExperience>>(this.jobExperineceDao.findAllByCandidate_IdOrderByResignationTimeDesc(candidateId));
	}

}
