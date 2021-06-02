package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill,Integer>{

}
