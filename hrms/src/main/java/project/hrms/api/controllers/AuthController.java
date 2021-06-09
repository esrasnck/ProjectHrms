package project.hrms.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.AuthService;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.dtos.RegisterForCandidateDto;
import project.hrms.entities.dtos.RegisterForEmployerDto;

@RestController
@CrossOrigin
@RequestMapping("api/auth")
public class AuthController {

	private AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate(@RequestBody RegisterForCandidateDto registerForCandidateDto) {
		
		return this.authService.registerCandidate(registerForCandidateDto);
		
	}
	
	@PostMapping("/registerEmployer")
	public Result registerCandidate(@RequestBody RegisterForEmployerDto registerForEmployerDto) {
		
		return this.authService.registerEmployer(registerForEmployerDto);
		
	}
	
	@GetMapping("/verify")   // hatalı :(
	public Result verify(int userId, String verificationCode) {
		
		return this.authService.verifyEmail(userId, verificationCode);
	}
}
