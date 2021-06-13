package project.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.AuthService;
import project.hrms.core.utilities.results.ErrorDataResult;
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
	
	@GetMapping("/verify") 
	public Result verify(int userId, String verificationCode) {
		
		return this.authService.verifyEmail(userId, verificationCode);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");

        return errors;

    }
}
