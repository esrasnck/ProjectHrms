package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import java.util.*;
import project.hrms.entities.concretes.Language;

public interface LanguageService {

	Result add(Language language);
	
	DataResult<List<Language>> getAllByCandidateId(int candidateId);
}
