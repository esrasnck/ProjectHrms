package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.School;
import java.util.*;

public interface SchoolService {

	Result add(School school);
	
	DataResult<List<School>> getAllByCandidateIdOrderByGraduationYear(int candidateId);

	DataResult<List<School>> getAllByCandidateId(int candidateId);
}
