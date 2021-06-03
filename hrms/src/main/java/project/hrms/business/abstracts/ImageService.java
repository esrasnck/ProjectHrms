package project.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Image;

public interface ImageService {

	Result add(Image image,  MultipartFile imageFile);
	
	DataResult<Image> getByCandidateId(int candidateId);
}
