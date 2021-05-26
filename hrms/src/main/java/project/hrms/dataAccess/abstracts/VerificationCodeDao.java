package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode,Integer> {

	VerificationCode findByUserIdAndVerificationCode(int userId, String verificationCode);   //  mapleme isimlendirme ile yapıyor.
}
