package project.hrms.business.abstracts;

import java.util.*;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	
	DataResult<City> getCityById(int cityId);
}
