package project.hrms.business.abstracts;

import java.util.*;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getByIsActive();

	DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate();

	DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);

	Result update(JobAdvertisement jobAdvertisement);
	
	Result toggleActive(int jobId);
	
	
}



 