package com.loan.bin.money.file.handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.loan.bin.money.core.LoanDisbursementDetail;
import com.loan.bin.money.customer.Customer;
import com.loan.bin.money.customer.PrivateCustomer;
import com.loan.bin.money.exception.FileHandlingException;
import com.loan.bin.money.exception.IncorrectLoanDetailException;
import com.loan.bin.money.exception.MissingLoanDetailException;
import com.loan.bin.money.exception.ProcessingException;

public class FileLoanDisbursementDetailDAO implements LoanDisbursementDetailDAO {

	private static FileLoanDisbursementDetailDAO fileLoanDisbDetailObj;
	private static final List<LoanDisbursementDetail> loanDetailList = new ArrayList<LoanDisbursementDetail>();
	private static final Map<String, LoanDisbursementDetail> nameLoanDetailMap = new HashMap<String, LoanDisbursementDetail>();
	private static final Pattern p = Pattern.compile("\"([^\"]*)\"");

	private FileLoanDisbursementDetailDAO() throws ProcessingException {
		loadCustomerDetails();
	}

	public static FileLoanDisbursementDetailDAO getInstance() throws ProcessingException {
		if (fileLoanDisbDetailObj == null) {
			fileLoanDisbDetailObj = new FileLoanDisbursementDetailDAO();
		}
		return fileLoanDisbDetailObj;
	}

	private void loadCustomerDetails() throws ProcessingException {
		String fileName = System.getProperty("prospectFileName");
		if (fileName == null) {
			throw new FileHandlingException(
					"File not found. Please add filename(property = prospectFileName) in the running configurations",
					"ERRFRE003");
		}

		int noOfCustomersLoaded = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String readLine;
			String[] detail;
			while ((readLine = br.readLine()) != null) {
				Matcher m = p.matcher(readLine);
				if (m.find()) {
					String name = m.group(1);
					System.out.println(name);
					readLine = readLine.replace("\"" + name + "\",", "");
					System.out.println(readLine);
					detail = readLine.split(",");
					if (detail.length != 3) {
						throw new MissingLoanDetailException("Missing loan detail for " + readLine, "ERRFRE001");
					}
					String[] newDetail = new String[4];
					int i = 0;
					newDetail[i++] = name;
					for (String det : detail) {
						newDetail[i++] = det;
					}
					detail = newDetail;
				} else {
					detail = readLine.split(",");
					if (detail.length != 4) {
						throw new MissingLoanDetailException("Missing loan detail for " + readLine, "ERRFRE001"); // we
																													// can
																													// add
																													// more
						// detail here to
						// identify the line which is causing the issue & as it is sensitive data we can
						// mask the logs
					}
				}
				LoanDisbursementDetail readDetail = null;
				if (noOfCustomersLoaded++ != 0) {
					readDetail = createLoanDetailObj(detail);
					loanDetailList.add(readDetail);
					nameLoanDetailMap.put(readDetail.getCustomer().getName(), readDetail);
				}

			}
		} catch (FileNotFoundException e) {
			throw new FileHandlingException("File not found.", "ERRFRE003");
		} catch (IOException e) {
			throw new FileHandlingException("Unable to read file.", "ERRFRE004");
		}
		System.out.println("Total customers added = " + noOfCustomersLoaded);
	}

	public LoanDisbursementDetail getLoanDetails(Customer customer) {
		return nameLoanDetailMap.get(customer.getName());
	}

	public List<LoanDisbursementDetail> getAllLoanDetails() throws ProcessingException {
		return loanDetailList;
	}

	private LoanDisbursementDetail createLoanDetailObj(String[] detail) throws IncorrectLoanDetailException {
		LoanDisbursementDetail readDetail = new LoanDisbursementDetail();
		readDetail.setCustomer(new PrivateCustomer(detail[0]));
		try {
			readDetail.setTotalLoan(Float.parseFloat(detail[1]));
			readDetail.setInterest(Float.parseFloat(detail[2]));
			readDetail.setYears(Integer.parseInt(detail[3]));
			return readDetail;
		} catch (NumberFormatException ne) {
			throw new IncorrectLoanDetailException("Can not find correct loan details for: " + detail[0], "ERRFRE002"); // we
																														// can
			// identify
			// or log
			// the
			// details
			// of the
			// failing
			// lines
			// instead of totally halting the loading process
		}
	}

	public void writeAccount(LoanDisbursementDetail detail) {
		// not in scope for this task, we can add accounts here

	}

	public void updateAccount(LoanDisbursementDetail existingDetail, LoanDisbursementDetail newDetail) {
		// // not in scope for this task, we can update accounts here

	}

}
