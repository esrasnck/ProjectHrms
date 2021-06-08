package project.hrms.dataAccess.abstracts;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

	List<CoverLetter> findAllByCandidate_Id(int candidateId);
	
	CoverLetter findById(int id);
}
