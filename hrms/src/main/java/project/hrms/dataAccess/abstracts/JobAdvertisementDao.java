package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import project.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{

		
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> findByIsActive();
	
	List<JobAdvertisement> findByEmployer_IdAndIsOpenedTrue(int employerId);
	
	JobAdvertisement findById(int jobId);
	
}
