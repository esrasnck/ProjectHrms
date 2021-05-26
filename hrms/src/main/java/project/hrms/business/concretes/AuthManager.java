package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.AuthService;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.business.abstracts.VerificationCodeService;
import project.hrms.core.utilities.adapters.mernis.UserCheckService;

import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.core.utilities.verification.VerificationService;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.VerificationCode;

@Service("AuthManager")
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private EmployerService employerService;
	private VerificationCodeService codeService;
	private VerificationService verificationService;

	@Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService, VerificationCodeService codeService, VerificationService verificationService) {

		this.candidateService = candidateService;

		this.employerService = employerService;
		
		this.codeService= codeService;
		
		this.verificationService = verificationService;

	}

	@Override
	public Result registerEmployer(Employer employer, String confirmedPassword) {
        
       if(!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(),confirmedPassword)) {
			
			return new ErrorResult("Passwords do not match !");
		}
		
		var result = this.employerService.add(employer);
		
         if(result.isSuccess()) {
        	 
        	 
         // TODO metot içine sok... 
         // TODO Yarın buradan devam et... !
        	 String code = this.verificationService.codeGenerator(); // verification code ürettim
 			this.verificationService.sendVerificationCode(code);  // gönderdim
 			
 			VerificationCode umut = new VerificationCode(employer.getId(),code,LocalDate.now().plusDays(1));
 			this.codeService.add(umut);  // veri tabanına ekledim.
        	 
		   return new SuccessResult("Employer Registered !");
		   
           }
          return new ErrorResult("something's gone wrong... Please try again.");
	
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmedPassword) {

		if(!checkIfEqualPasswordAndConfirmPassword(candidate.getPassword(),confirmedPassword)) {
			
			return new ErrorResult("Passwords do not match !");
		}
		
		var result = this.candidateService.add(candidate);
		
		if(result.isSuccess()) {
			
			String code = this.verificationService.codeGenerator(); // verification code ürettim
			this.verificationService.sendVerificationCode(code);  // gönderdim
			
			VerificationCode umut = new VerificationCode(candidate.getId(),code,LocalDate.now().plusDays(1));
			this.codeService.add(umut);  // veri tabanına ekledim.
			
			return new SuccessResult("Candidate Registered !");
		
		}
		return new ErrorResult("something's gone wrong... Please try again.");
		
	}
	
	// confirmed password
	
	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}

	@Override
	public Result verifyEmail(int user_id, String activationCode) {
		
		var result = this.codeService.getByUserIdAndVerificationCode(user_id, activationCode);
		
	    if(result.getData() ==null) {
	    	
	    	return new ErrorResult("Verification Code is wrong !");
	    }
	    
	    if(result.getData().getIsActivate()) {
	    	return new ErrorResult("Verification Code is already active");
	    }
	    
	    if(result.getData().getExpiredDate().isBefore(LocalDate.now())){
	 
	    	return new ErrorResult("Verification Code is Expired");
	    }
	   
	    // TODO: abla intihar etmeden önce  --- aha umut gör :P 
	  
	    
	    VerificationCode verificationCode = result.getData();
	    
	    verificationCode.setConfirmedDate(LocalDate.now());
	    verificationCode.setIsActivate(true);
	    this.codeService.update(verificationCode);
	   
	    return new SuccessResult("Verified !");

	}
	
	
}
