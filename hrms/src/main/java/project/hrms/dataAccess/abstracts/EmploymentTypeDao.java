package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.EmploymentType;

public interface EmploymentTypeDao extends JpaRepository<EmploymentType, Integer> {

}
