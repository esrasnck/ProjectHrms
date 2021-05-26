package project.hrms.entities.concretes;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)  // miras verdiği sınıfa ozelliklerini aktarır?

public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) //bunu vermeyince, hep api hem de pg adminden değişiklik yapmamıza izin veriyor. bunu koymadığımıza id'ler çakışıyor. ya veritabanı üzerinden ya da api üzerinden ekleme yapabiliyoruz.
	@Column(name="id")
	private int id;

	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="is_active",columnDefinition = "boolean default true") // default'u true der
	private Boolean isActive=true;
	
	@Column(name="created_date",columnDefinition = "Date defult CURRENT_DATE")
	private LocalDate createdDate=LocalDate.now();
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	private Boolean isDeleted= false;
	
}
