package project.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="candidates")
@EqualsAndHashCode(callSuper=false) 
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")

public class Candidate extends User {

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="is_verified_by_email")
	private Boolean isEmailVerified;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createdDate=LocalDate.now();
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isDeleted=false;
	
	
   // relational Properties
	
	@JsonIgnore
	@OneToMany(mappedBy ="candidate")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<Link> links;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<Skill> skills;
	
	@OneToOne(mappedBy="candidate",optional=false, fetch=FetchType.LAZY)
	private Image image;
}
