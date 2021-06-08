package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobTitleService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.City;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.JobTitle;

@RestController

@RequestMapping("api/jobtitles")
@CrossOrigin
public class JobTitlesController {
	
	
	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {  
		super();
		this.jobTitleService = jobTitleService;
	}
	

	@GetMapping("/getall")
	
	public DataResult<List<JobTitle>> getAll(){
		
		return this.jobTitleService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result registerCandidate(@RequestBody JobTitle jobTitle) {
		
		return this.jobTitleService.add(jobTitle);
				
	}
	
	
	@GetMapping("/getByJobTitleId")
	public DataResult<JobTitle> getByCityId(@RequestParam("jobTitleId") int jobTitleId){
		return this.jobTitleService.getJobTitleById(jobTitleId);
	}
	
	//TODO test edilecek
	
	@PostMapping("/update")
	public Result update(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.update(jobTitle);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.delete(jobTitle);
	}
}
