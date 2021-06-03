package project.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobAdvertisementDao;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDto;

@Service("JobAdvertisementManager")
public class JobAdvertisementManager implements JobAdvertisementService{

	
	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapper modelMapper;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		return new SuccessResult("Job Advertisement added !");  
	
	}
	
	
	// teşekkürler yakup :)
	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActive(),"All active advertisement listed !");
		
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate() {
	
		Sort sort = Sort.by(Sort.Direction.DESC,"appealDeadline");
				
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
		
	}
	

	@Override
	public DataResult<List<JobAdvertisement>>getAllByEmployerId(int employerId) {
		 
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployer_IdAndIsOpenedTrue(employerId));
	}
	
	

	
	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Advertisement updated !");
	}
	
	

	

	@Override
	public Result toggleActive(int jobId) {
		
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(jobId);
		if(!IsJobAdvertisementExists(jobAdvertisement)) {
			
			return new ErrorResult("Job Advertisement doesn't exists");

		}
		
		jobAdvertisement.setIsActive(!jobAdvertisement.getIsActive());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Toggled") ;
	}
	
	
	
	private boolean IsJobAdvertisementExists(JobAdvertisement jobAdvertisement) {
		
		if(jobAdvertisement == null) {
			return false;
		}
		return true;
	}
	
	
	// mapping system is disabled.
	private List<JobAdvertisementDto> dtoGenerator(List<JobAdvertisement> advertisement){
		List<JobAdvertisementDto> jobAdvertisementDtos= new ArrayList<JobAdvertisementDto>(); 
		advertisement.forEach(item -> {
			JobAdvertisementDto dto=modelMapper.map(item, JobAdvertisementDto.class);
			dto.setCompanyName(item.getEmployer().getCompanyName());
			jobAdvertisementDtos.add(dto);
		});
		return jobAdvertisementDtos;
	
	}

	
}
