package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobTitleService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobTitleDao;
import project.hrms.entities.concretes.JobTitle;


@Service("JobTitleManager")

public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobtitleDao;
	
    @Autowired
	public JobTitleManager(JobTitleDao jobtitleDao) {
		super();
		this.jobtitleDao = jobtitleDao;
	}


	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>> (this.jobtitleDao.findAll());
	}


	@Override
	public Result add(JobTitle jobTitle) {
		if(!this.isTitleExist(jobTitle.getTitleName())) {
			
			return new ErrorResult("Job title Exist !");
		}
		
		this.jobtitleDao.save(jobTitle);
		return new SuccessResult("JobTitle Added !");
	}
	
	
	private boolean isTitleExist(String titleName) {
		if(this.jobtitleDao.findByTitleName(titleName) != null) {
			return false;
		}
		return true;
		
	}

	
}
