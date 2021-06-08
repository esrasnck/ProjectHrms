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
	public Result registerCandidate(@RequestBody Candidate candidate,String confirmPassword) {
		
		return this.authService.registerCandidate(candidate, confirmPassword);
		
	}
	
	@PostMapping("/registerEmployer")
	public Result registerCandidate(@RequestBody Employer employer,String confirmPassword) {
		
		return this.authService.registerEmployer(employer, confirmPassword);
		
	}
	
	@GetMapping("/verify")
	public Result verify(int userId, String verificationCode) {
		
		return this.authService.verifyEmail(userId, verificationCode);
	}
}
