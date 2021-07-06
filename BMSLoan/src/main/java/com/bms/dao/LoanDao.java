package com.bms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.model.Loan;
@Repository
public interface LoanDao extends JpaRepository<Loan, String> {

}
