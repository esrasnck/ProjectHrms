package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.EmploymentTypeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.EmploymentType;


@RestController

@RequestMapping("api/employmentTypes")
@CrossOrigin
public class EmploymentTypeController {
	
	private EmploymentTypeService employmentService;

	@Autowired
	public EmploymentTypeController(EmploymentTypeService employmentService) {
		super();
		this.employmentService = employmentService;
	}
	
	
	// not test yet
	
	@GetMapping("/getall")
	public DataResult<List<EmploymentType>> getAll(){
		return this.employmentService.getAll();
	}

	
	@PostMapping("/add")
	public Result add(@RequestBody EmploymentType employmentType) {
		return this.employmentService.add(employmentType);
	}

}
