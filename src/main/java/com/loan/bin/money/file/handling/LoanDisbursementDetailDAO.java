package com.loan.bin.money.file.handling;

import java.io.IOException;
import java.util.List;

import com.loan.bin.money.core.LoanDisbursementDetail;
import com.loan.bin.money.customer.Customer;
import com.loan.bin.money.exception.ProcessingException;

public interface LoanDisbursementDetailDAO {

	public LoanDisbursementDetail getLoanDetails(Customer customer);
    public List<LoanDisbursementDetail> getAllLoanDetails() throws IOException, ProcessingException;
    public void writeAccount(LoanDisbursementDetail detail);
    public void updateAccount(LoanDisbursementDetail existingDetail, LoanDisbursementDetail newDetail);
}
