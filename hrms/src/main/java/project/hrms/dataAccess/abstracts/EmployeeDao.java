package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
