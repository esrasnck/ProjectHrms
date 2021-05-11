package project.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_titles")
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // arastir tam olarak.
	@Column(name="id")
	private int id;
	
	@Column(name="title_name")
	private String titleName;
	
	public JobTitle (){}
	
	public JobTitle(int id, String titleName) {
		super();
		this.id = id;
		this.titleName = titleName;
	}

	
}
