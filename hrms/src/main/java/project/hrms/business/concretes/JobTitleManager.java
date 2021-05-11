package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobTitleService;
import project.hrms.dataAccess.abstracts.JobTitleDao;
import project.hrms.entities.concretes.JobTitle;


@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobtitleDao;
	
    @Autowired
	public JobTitleManager(JobTitleDao jobtitleDao) {
		super();
		this.jobtitleDao = jobtitleDao;
	}


	@Override
	public List<JobTitle> getAll() {
		// TODO Auto-generated method stub
		return this.jobtitleDao.findAll();
	}

}
