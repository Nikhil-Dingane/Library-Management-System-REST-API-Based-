package com.example.demo.entity.service;

import com.example.demo.entity.IssueBookLoan;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.repository.IssueBookLoanRepository;

@Service
public class IssueBookLoanService {
	@Autowired
	IssueBookLoanRepository issueBookLoanRepository;

	public List<IssueBookLoan> getAllIssuedBookLoans() {
		List<IssueBookLoan> issuedBookLoans = new ArrayList<IssueBookLoan>();
		issueBookLoanRepository.findAll().forEach(issuedBookLoans::add);
		return issuedBookLoans;
	}
	public Optional<IssueBookLoan> getIssuedBookLoan(Long id) {
		return issueBookLoanRepository.findById(id);
	}

	public IssueBookLoan issueBookLoan(IssueBookLoan issueBookLoan) {
		issueBookLoan.setId(null);
		return issueBookLoanRepository.save(issueBookLoan);
	}

	public IssueBookLoan updateIssuedBookLoan(IssueBookLoan issueBookLoan) {
		return issueBookLoanRepository.save(issueBookLoan);
	}

	public Optional<IssueBookLoan> deleteIssuedBookLoan(Long id) {
		Optional<IssueBookLoan> issuedBook = getIssuedBookLoan(id);

		if (issuedBook != null) {
			issueBookLoanRepository.deleteById(id);
		}

		return issuedBook;
	}
}
