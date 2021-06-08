package project.hrms.business.abstracts;

import java.util.*;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	
	DataResult<City> getCityById(int cityId);
	
	Result add(City city);
	
	Result update(City city);
	
	Result delete(City city);
}
