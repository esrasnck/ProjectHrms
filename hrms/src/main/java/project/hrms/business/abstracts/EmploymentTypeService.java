package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.EmploymentType;
import java.util.*;

public interface EmploymentTypeService {

	Result add(EmploymentType employmentType);
	DataResult<List<EmploymentType>> getAll();
}
