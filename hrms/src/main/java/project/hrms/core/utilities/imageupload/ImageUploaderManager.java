package project.hrms.core.utilities.imageupload;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;

@Service
public class ImageUploaderManager implements ImageUploaderService{
 
	
	private Cloudinary cloudinary;

	public ImageUploaderManager() {
		super();
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "wissen",
				"api_key", "793285435792967",
				"api_secret", "fMrGwN65vZoTvCJJni0r7yGJ8sE"
				));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        
		try {
			@SuppressWarnings("unchecked")
			Map<String,String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ErrorDataResult<Map>();
	}
	
}
