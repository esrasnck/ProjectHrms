package project.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.hrms.business.abstracts.ImageService;
import project.hrms.core.utilities.imageupload.ImageUploaderService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.entities.concretes.Image;

import project.hrms.dataAccess.abstracts.*;

@Service("ImageManager")
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private ImageUploaderService imageUploderService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploaderService imageUploaderService) {
		super();
		this.imageDao = imageDao;
		this.imageUploderService = imageUploaderService;
				
	}



	@Override
	public Result add(Image image,  MultipartFile imageFile) {
		Map<String,String> uploadImage = this.imageUploderService.uploadImageFile(imageFile).getData();
		image.setUrl(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Image has been added.");
	}



	@Override
	public DataResult<Image> getByCandidateId(int candidateId) {

		return new SuccessDataResult<Image>(this.imageDao.findByCandidate_Id(candidateId));
	}

}
