package com.scalableservices.loan_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scalableservices.loan_service.service.LoanService;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/loan/request")
    public String applyLoan(@RequestParam("userId") String userId, @RequestParam("loanAmount") String loanAmount, @RequestParam("annualIncome") String annualIncome) {
        return loanService.applyLoan(Integer.valueOf(userId), Integer.valueOf(loanAmount), Integer.valueOf(annualIncome));
    }
}
