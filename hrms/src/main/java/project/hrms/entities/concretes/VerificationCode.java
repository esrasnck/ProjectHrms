package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verification_codes")
public class VerificationCode {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="verification_code")
	private String verificationCode;  // TODO emailVerificationCode diye değiştir.
	
	@Column(name="created_date")
	private LocalDate createdDate=LocalDate.now();
	
	@Column(name="expired_date")  // ?
	private LocalDate expiredDate;
	
	@Column(name="is_activate",columnDefinition = "boolean default false") 
	private Boolean isActivate;
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isDeleted=false;
	
	@Column(name="confirmed_date")  //  ?
	private LocalDate confirmedDate;

	public VerificationCode(int userId, String verificationCode, LocalDate expiredDate) {
		super();
		this.userId = userId;
		this.verificationCode = verificationCode;
		this.expiredDate = expiredDate;
	}
	
	
}
