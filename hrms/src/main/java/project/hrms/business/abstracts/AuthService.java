package project.hrms.business.abstracts;


import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.dtos.RegisterForCandidateDto;
import project.hrms.entities.dtos.RegisterForEmployerDto;

public interface AuthService {

   Result registerEmployer(RegisterForEmployerDto registerForEmployerDto);
   
   Result registerCandidate(RegisterForCandidateDto registerForCandidateDto);
   
   Result verifyEmail(int user_id, String activationCode);
	  
}
