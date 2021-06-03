package project.hrms.core.utilities.imageupload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import project.hrms.core.utilities.results.DataResult;

public interface ImageUploaderService {

	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
