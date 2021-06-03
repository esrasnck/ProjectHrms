package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link,Integer> {

	List<Link> findAllByCandidate_Id(int candidateId);
}
