package com.scalableservices.loan_service.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scalableservices.loan_service.model.Loan;
import com.scalableservices.loan_service.repository.LoanRepository;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    private boolean VerifyCreditScore(int userId) {
        final String uri = "http://localhost:8079/verify/credit_score?userId="
		 + userId;
		RestTemplate restTemplate = new RestTemplate();
        boolean result = restTemplate.getForObject(uri, boolean.class);
        return result;
    }

    public String applyLoan(int userId, int loanAmount, int annualIncome) {
        if (loanAmount > 10 * annualIncome) {
            return "Request! This loan request is not eligible to sanction";
        }
        String id = loanRepository.findByUserId(userId);
        if (id != null) {
            return "Rejected! This user had already taken loan";
        }
        if (!VerifyCreditScore(userId)) {
            return "Rejected! This user credit score is not sufficient to request loan";
        }
        Random rand = new Random();
        Loan loan = new Loan();
        loan.setId(rand.nextInt(1000));
        loan.setLoanAmount(loanAmount);
        loan.setUserId(userId);
        loanRepository.save(loan);
        return "Loan request accepted successfully";
    }

}
