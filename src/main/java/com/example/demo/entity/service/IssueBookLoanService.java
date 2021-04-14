package com.example.demo.entity.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookStock;
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
	@Autowired
	BookStockService bookStockService;
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
		BookStock bookStock = bookStockService.getBookQuantity(issueBookLoan.getBook().getId());
		
		if(bookStock.getquantity() > 0) {
			bookStock.setquantity(bookStock.getquantity() - 1);
			bookStockService.updateBookQuantity(bookStock);
			return issueBookLoanRepository.save(issueBookLoan);
		} else {
			return null;
		}
	}

	public IssueBookLoan updateIssuedBookLoan(IssueBookLoan issueBookLoan) {
		return issueBookLoanRepository.save(issueBookLoan);
	}

	public Optional<IssueBookLoan> deleteIssuedBookLoan(Long id) {
		Optional<IssueBookLoan> issuedBook = getIssuedBookLoan(id);

		if (issuedBook != null) {
			issueBookLoanRepository.deleteById(id);
			Book book = new Book();
			book.setId(id);
			bookStockService.addBookQuantity(new BookStock(book,1));
		}

		return issuedBook;
	}
}
