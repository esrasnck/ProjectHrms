package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.*;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Language;

@RestController
@RequestMapping("api/controller")
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService ) {
		super();
		this.languageService = languageService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		
		return this.languageService.add(language);
	}
}
