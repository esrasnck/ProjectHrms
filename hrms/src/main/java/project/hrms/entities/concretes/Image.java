package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="images")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidate"})
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;

	
	@Column(name = "url")
	private String url;	
	
	@Column(name= "created_date")
	@JsonIgnore
	private LocalDate createdAt = LocalDate.now();
	

	@Column(name= "is_active", columnDefinition = "boolean default true")
	private Boolean isActive = true;
	

	@Column(name= "is_deleted", columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isDeleted = false;

	
	// relational properties
	
	 @OneToOne(optional=false,fetch=FetchType.LAZY)  // şuna ihtiyac yok sanki.. Cerenimoya sor
	 private Candidate candidate;
}
