package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	DataResult<List<JobExperience>> getAllByCandidateIdOrderByResignationTimeDesc(int candidateId);
	
	DataResult<List<JobExperience>> getAllByCandidateId(int candidateId);
	
	DataResult<List<JobExperience>> getAll();
	
	DataResult<JobExperience> getById(int id);
	
	Result add(JobExperience jobExperinence);
	
	Result update(JobExperience jobExperinence);
	
	Result delete(JobExperience jobExperinence);
}
