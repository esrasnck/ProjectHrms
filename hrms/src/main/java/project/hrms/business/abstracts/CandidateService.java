package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.dtos.CandidateCvDto;

public interface CandidateService {

	DataResult<Candidate> getByNationalId(String nationalId);
	
	DataResult<Candidate> getByEmail(String email);
	
	DataResult<List<Candidate>> getAll();
	
	DataResult<Candidate> getById(int candidateId);
	
	DataResult<CandidateCvDto> getDtoById(int candidateId);
	
	Result add(Candidate candidate);
	
	Result update(Candidate candidate);
	
	Result delete(Candidate candidate);
}
