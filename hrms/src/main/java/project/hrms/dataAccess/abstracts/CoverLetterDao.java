package project.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

}
