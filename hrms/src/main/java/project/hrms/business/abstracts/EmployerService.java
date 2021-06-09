package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	DataResult<Employer> getByEmail(String email);
	
	DataResult<Employer> getById(int id);
	
	Result add(Employer employer);
	
	Result update(Employer employer);
	
	Result delete(Employer employer);
}
