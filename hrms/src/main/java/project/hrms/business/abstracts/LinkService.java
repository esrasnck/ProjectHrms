package project.hrms.business.abstracts;

import java.util.*;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Link;

public interface LinkService {

	Result add(Link link);
	
	DataResult<List<Link>> getAllByCandidateId(int candidateId);
}
