package com.scalableservices.loan_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="loan")
@Data
public class Loan {

    @Id
	@Column(name="id")
    private int id;

	@Column(name="user_id")
    private int userId;

	@Column(name="loan_amount")
    private int loanAmount;
}
