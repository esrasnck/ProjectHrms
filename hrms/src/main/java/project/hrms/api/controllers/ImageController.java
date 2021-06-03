package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.ImageService;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Image;


@RestController
@RequestMapping("/api/images")
public class ImageController {
	
	private ImageService imageService;
	private CandidateService candidateService;
	
	@Autowired
	public ImageController(ImageService imageService, CandidateService candidateService) {
		super();
		this.imageService = imageService;
		this.candidateService = candidateService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile){
		Candidate candidate = this.candidateService.getById(id).getData();
		Image image = new Image();
		image.setCandidate(candidate);
		return this.imageService.add(image, imageFile);
		
	}

}
