package project.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {
	
    
	private String titleName;
	
	private int openPositionCount; 
	
	private LocalDate createdDate; 
	
	private LocalDate appealDeadline;
	
    private EmployerDto employer;

}
