package project.hrms.business.abstracts;

import java.util.*;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisementDto>> getByIsActive();
	
	DataResult<List<JobAdvertisementDto>> getAllSortedByReleaseDate();

	DataResult<List<JobAdvertisementDto>> getAllByEmployerId(int employerId);

	Result update(JobAdvertisement jobAdvertisement);
	
	Result toggleActive(int jobId);
	
	
}



 