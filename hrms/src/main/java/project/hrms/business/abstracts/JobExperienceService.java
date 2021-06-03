package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	Result add(JobExperience jobExperinence);
	
	DataResult<List<JobExperience>> getAllByCandidateIdOrderByResignationTimeDesc(int candidateId);
	
	DataResult<List<JobExperience>> getAllByCandidateId(int candidateId);
}
