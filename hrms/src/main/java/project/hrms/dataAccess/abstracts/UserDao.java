package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.User;

public interface UserDao  extends JpaRepository<User, Integer>{

 User findUserByEmail(String email);
 
 User findById(int id);
}
