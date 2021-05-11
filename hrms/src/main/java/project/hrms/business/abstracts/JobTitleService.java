package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	List<JobTitle> getAll();
}
