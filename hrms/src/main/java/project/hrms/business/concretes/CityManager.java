package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CityService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CityDao;
import project.hrms.entities.concretes.City;

@Service("CityManager")
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
	
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public DataResult<City> getCityById(int cityId) {
	
		return new SuccessDataResult<City>(this.cityDao.getOne(cityId));
	}

	@Override
	public Result add(City city) {

		if(!this.isCityExists(city.getName()).isSuccess()) {
			return new ErrorResult("City already exists");
		}
		this.cityDao.save(city);

		return new SuccessResult("City added !");
	}

	@Override
	public Result update(City city) {

		this.cityDao.save(city);

		return new SuccessResult("City updated !");
	}

	@Override
	public Result delete(City city) {

		this.cityDao.delete(city);

		return new SuccessResult("City deleted !");
	}
	
	
	public Result isCityExists(String name) {
		
		if(this.cityDao.findByName(name) != null) {
			return new ErrorResult();
			
		}
		return new SuccessResult();
	}
	
	
}
