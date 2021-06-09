package project.hrms.entities.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForEmployerDto {

	
    private String webSite;
    private String phoneNumber;
    private String companyName;
    private String email;
    private String password;
    private String confirmPassword;
}
