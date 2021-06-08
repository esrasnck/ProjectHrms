package project.hrms.api.controllers;

import java.util.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.*;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Language;

@RestController
@RequestMapping("api/controller")
@CrossOrigin
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService ) {
		super();
		this.languageService = languageService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid Language language ) {
		
		return this.languageService.add(language);
	}
	
	//TODO test edilecek
	
	@PostMapping("/update")
	public Result update(@RequestBody Language language) {
		return this.languageService.update(language);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Language language) {
		return this.languageService.delete(language);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Language>> getall(@RequestParam int candidateId){
		return this.languageService.getAllByCandidateId(candidateId);
	}
}
