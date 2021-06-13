package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_advertisements")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer","city","jobTitle"})
public class JobAdvertisement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="open_position_count")
	private int openPositionCount;
	

	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	

	@Column(name="appeal_deadline")
	private LocalDate appealDeadline;
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createdDate=LocalDate.now();
	
	@Column(name="is_verified_by_employee",columnDefinition="boolean default false")
	private Boolean isVerifiedByEmployee=false;
	
	@Column(name="is_remote",columnDefinition="boolean default false")
	private Boolean isRemote=false;
	
	@Column(name="is_active",columnDefinition = "boolean default true")
	@JsonIgnore
	private Boolean isActive =true;
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isDeleted=false;
	
	@Column(name="is_opened",columnDefinition = "boolean default true")
	private Boolean isOpened=true;
	
	// relational properties
	
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name="employment_type_id")
	private EmploymentType employmentType;
	


	
}
