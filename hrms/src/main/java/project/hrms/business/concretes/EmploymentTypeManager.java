package project.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EmploymentTypeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmploymentTypeDao;
import project.hrms.entities.concretes.EmploymentType;


@Service("EmploymentTypeManager")
public class EmploymentTypeManager implements EmploymentTypeService {

	private EmploymentTypeDao employmentDao;
	
	public EmploymentTypeManager(EmploymentTypeDao employmentDao) {
		super();
		this.employmentDao = employmentDao;
	}

	@Override
	public Result add(EmploymentType employmentType) {
		this.employmentDao.save(employmentType);
		return new SuccessResult("Employment Type Added !");
	}

	@Override
	public DataResult<List<EmploymentType>> getAll() {
		
		
		return new SuccessDataResult<List<EmploymentType>>(this.employmentDao.findAll(),"Types are listed !");
	}

}
