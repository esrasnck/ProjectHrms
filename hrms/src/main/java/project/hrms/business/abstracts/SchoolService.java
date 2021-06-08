package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.School;
import java.util.*;

public interface SchoolService {

	DataResult<List<School>> getAllByCandidateIdOrderByGraduationYear(int candidateId);

	DataResult<List<School>> getAllByCandidateId(int candidateId);
	
	Result add(School school);
	
	Result update(School school);
	
	Result delete(School school);
}
