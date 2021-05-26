package project.hrms.business.abstracts;


import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Employer;

public interface AuthService {

   Result registerEmployer(Employer employer, String confirmedPassword);
   
   Result registerCandidate(Candidate candidate, String confirmedPassword);
   
   Result verifyEmail(int user_id, String activationCode);
	  
}
