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
	public DataResult<List<JobExperience>> getAllByCandidateIdOrderByResignationTimeDesc(int candidateId) {
	
		return new SuccessDataResult<List<JobExperience>>(this.jobExperineceDao.findAllByCandidate_IdOrderByResignationTimeDesc(candidateId));
	}



	@Override
	public DataResult<List<JobExperience>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperineceDao.findAllByCandidate_Id(candidateId));
	}

  
	

	@Override
	public DataResult<List<JobExperience>> getAll() {
	
		return new SuccessDataResult<List<JobExperience>>(this.jobExperineceDao.findAll());
	}



	@Override
	public DataResult<JobExperience> getById(int id) {
	
		return new SuccessDataResult<JobExperience>(this.jobExperineceDao.findById(id).orElseGet(null));
	}



	@Override
	public Result update(JobExperience jobExperinence) {
		this.jobExperineceDao.save(jobExperinence);
		return new SuccessResult("Job Experience updated !");
	}



	@Override
	public Result delete(JobExperience jobExperinence) {
	this.jobExperineceDao.delete(jobExperinence);
		return  new SuccessResult("Job Experience deleted !");
	}

}
