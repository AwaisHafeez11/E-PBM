package com.example.EPBMapplication.Model.Forms;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "financialForm")
public class FinancialForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String LastName;
	@Column(nullable = false)
	private Long cnic;
	@Column(nullable = false)
	private long contact;
	
	private String fatherName;
	private Long fatherCnic;
	
	private Integer applicantAge;
    private String CurrentAddress;
    private String permanentAddress;
    private boolean MaritalStatus;
    private String email;
    
    private String ApplicationType;
    private String description;
    
	
	
	
	

}
