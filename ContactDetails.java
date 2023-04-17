package com.monocept.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ContactDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactDetailsId;
	
	@Enumerated(EnumType.STRING)
	private NEType type;
	
	@ManyToOne
	@JoinColumn(name = "contact_id", nullable = false)
	private Contact contact;
	

}
