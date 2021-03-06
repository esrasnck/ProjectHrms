package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cover_letters")

public class CoverLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@JsonIgnore
	@Column(name="is_active",columnDefinition = "boolean default true")
	private Boolean isActive =true;
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createdDate=LocalDate.now();
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isDeleted=false;
	
	
	// relational Properties

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
}
