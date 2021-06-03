package project.hrms.entities.dtos;

import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.CoverLetter;
import project.hrms.entities.concretes.Image;
import project.hrms.entities.concretes.JobExperience;
import project.hrms.entities.concretes.Language;
import project.hrms.entities.concretes.Link;
import project.hrms.entities.concretes.School;
import project.hrms.entities.concretes.Skill;

import java.util.*;

public class CandidateCvDto {
	
	public Candidate candidate;
	
	public List<School> schools;
	
	public List<Skill> skills;
	
	public List<Link> links;
	
	public List<Language> languages;
	
	public List<JobExperience> jobExperiences;
	
	public List<CoverLetter> coverLetters;
	
	public Image image;

}
