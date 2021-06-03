package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

	List<Language> findAllByCandidate_Id(int candidateId);
}
