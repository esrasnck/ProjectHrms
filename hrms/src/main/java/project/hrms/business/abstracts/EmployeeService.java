package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();
	
	DataResult<Employee> getById(int employeeId);
	
	Result add(Employee employee);
	
	Result update(Employee employee);
	
	Result delete(Employee employee);
	
}
