package project.hrms.core.utilities.imageupload;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploaderManager implements ImageUploaderService{
 
	
	private Cloudinary cloudinary;

	@Autowired // beanden alıyor buraya yapıştırıyor.
	public ImageUploaderManager(Cloudinary cloudinary) {
         
		this.cloudinary =cloudinary;
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        
		try {
			@SuppressWarnings("unchecked")
			Map<String,String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return new ErrorDataResult<Map>("Cannot added !");
	}
	
}
