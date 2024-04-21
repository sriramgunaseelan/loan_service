package com.scalableservices.loan_service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scalableservices.loan_service.model.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan,Integer> {

    @Query("select userId from Loan where userId=:userId")
    String findByUserId(@Param("userId") int userId);

}
