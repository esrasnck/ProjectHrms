package project.hrms.core.utilities.genericmapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jdi.Method;

public class GenericModelMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public <E,T> List<T> convert(List<E> entityList,Class<T> dto) {
		return entityList.stream().map(entity->this.modelMapper.map(entityList, dto)).collect(Collectors.toList());
	}
	
	public <E,T> List<T> convertSpecial(List<E> entityList, Class<T> dto , List<Method> methodDto, List<Method> methodsEntity){
		List<T> dtosResult=new ArrayList<T>();
		entityList.forEach(entity->{
			try {
				T itemDto= dto.newInstance();
				methodDto.forEach(itemMethod ->{
					try {
						methodsEntity.get(methodDto.indexOf(itemMethod));
						itemDto.getClass().getDeclaredMethod(itemMethod.name()).invoke(this);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| NoSuchMethodException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		return null;
	}
	

}



/*
 * 
 * 	
	private List<JobAdvertisementDto> dtoGenerator(List<JobAdvertisement> advertisement){
		List<JobAdvertisementDto> jobAdvertisementDtos= new ArrayList<JobAdvertisementDto>(); 
		advertisement.forEach(item -> {
			JobAdvertisementDto dto=modelMapper.map(item, JobAdvertisementDto.class);
			dto.setCompanyName(item.getEmployer().getCompanyName());
			jobAdvertisementDtos.add(dto);
		});
		return jobAdvertisementDtos;
	
	}
 * 
 * 
 * 
 * 
 * */
 