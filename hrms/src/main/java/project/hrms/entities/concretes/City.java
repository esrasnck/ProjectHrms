package project.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
		
	@Column(name="created_date",columnDefinition = "Date default CURRENT_DATE")
	private LocalDate createdDate=LocalDate.now();
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	private Boolean isDeleted=false;
	
	@Column(name="is_opened")
	private Boolean isOpened;
	
	// relational properties
	
	@OneToMany(mappedBy="city")
	private List<JobAdvertisement> jobAdvertisements;
	
	
}
