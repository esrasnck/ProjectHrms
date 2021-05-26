package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode code);
	
	DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode);
	
	Result update(VerificationCode code);
}
