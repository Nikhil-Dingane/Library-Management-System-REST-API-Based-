package com.example.demo.entity.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.IssueBookLoan;
import com.example.demo.entity.service.IssueBookLoanService;

@RestController
@RequestMapping("issueBookLoans")
public class IssueBookLoanController {
	@Autowired
	IssueBookLoanService issueBookLoanService;
	@RequestMapping(method = RequestMethod.GET)
	public List<IssueBookLoan> getAllIssuedBooks(){
		return issueBookLoanService.getAllIssuedBookLoans();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{issuedBookLoanId}")
	public Optional<IssueBookLoan> getIssuedBook(@PathVariable Long issuedBookLoanId){
		return issueBookLoanService.getIssuedBookLoan(issuedBookLoanId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public IssueBookLoan issueBook(@RequestBody IssueBookLoan issueBookLoan) {
		return issueBookLoanService.issueBookLoan(issueBookLoan);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{issuedBookLoanId}")
	public IssueBookLoan updateIssuedBook(@PathVariable Long issuedBookLoanId, @RequestBody IssueBookLoan issueBookLoan) {
		issueBookLoan.setId(issuedBookLoanId);
		return issueBookLoanService.updateIssuedBookLoan(issueBookLoan);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{issuedBookLoanId}")
	public Optional<IssueBookLoan> deleteIssuedBookLoan(@PathVariable Long issuedBookLoanId) {
		return issueBookLoanService.deleteIssuedBookLoan(issuedBookLoanId);
	}
}
