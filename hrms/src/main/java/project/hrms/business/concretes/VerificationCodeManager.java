package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.VerificationCodeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.VerificationCodeDao;
import project.hrms.entities.concretes.VerificationCode;

@Service("VerificationCodeManager")
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao =verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code added !");
	}

	@Override
	public DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode) {
		
		// TODO bu isimlendirmele uymazsam SQL query'si yazmam gerekiyor
		
		
		return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.findByUserIdAndVerificationCode(userId, verificationCode));
	}

	@Override
	public Result update(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code updated !");
	}
}
