package project.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {

	Candidate findByIdentificationNumber(String identificationNumber);
	
	//Optional<> Araştır
	Candidate findByEmail(String email);
	
	Candidate findById(int id);
}
