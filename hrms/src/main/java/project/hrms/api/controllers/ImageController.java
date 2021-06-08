package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.ImageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Image;


@RestController
@RequestMapping("/api/images")
@CrossOrigin
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
	
	//TODO test edilmedi
	
	@PostMapping("/update")
	public Result update(@RequestBody Image image) {
		return this.imageService.update(image);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Image image) {
		
		return this.imageService.delete(image);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Image> getById(@RequestParam("id") int id){
		
		return this.imageService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){
		return this.imageService.getAll();
	}
	
	@GetMapping("getbycandidateId")
	public DataResult<Image> getByCandidateId(@RequestParam int id){
		return this.imageService.getByCandidateId(id);
	}

}
