package project.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")

@EqualsAndHashCode(callSuper=false) 
public class Employer extends User {
    
	@NotBlank
	@NotNull
	@Column(name="web_site")
	private String webSite;
	
	@NotBlank
	@NotNull
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	@NotBlank
	@NotNull
    @Column(name="company_name")
    private String companyName;
    
	@JsonIgnore
	@Nullable
    @Column(name="is_email_verified",columnDefinition = "boolean default false")
	private Boolean isEmailVerified;
    
	@Nullable
	@JsonIgnore
    @Column(name="is_verified_by_emlopyee",columnDefinition = "boolean default false")
	private Boolean isVerifiedByEmlopyee;

    
    
    // relational properties
    
     @JsonIgnore
     @OneToMany(mappedBy="employer")
     private List<JobAdvertisement> jobAdvertisements;
}

