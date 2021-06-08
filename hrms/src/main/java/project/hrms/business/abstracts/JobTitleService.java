package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
	
	DataResult<JobTitle> getJobTitleById(int jobTitleId);
	
	Result add(JobTitle jobTitle);
	
	Result update(JobTitle jobTitle);
	
	Result delete(JobTitle jobTitle);
}
