package com.example.demo.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "issue_book_loan")
public class IssueBookLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long bookId;
	private Long memberId;
	private Date issuedDate;
	private Date dueDate;
	private Date returnedDate;
	private String activityStatus;
	
	
	
	public IssueBookLoan() {
		super();
	}

	public IssueBookLoan(Long id, Long bookId, Long memberId, Date issuedDate, Date dueDate, Date returnedDate,
			String activityStatus) {
		this.id = id;
		this.bookId = bookId;
		this.memberId = memberId;
		this.issuedDate = issuedDate;
		this.dueDate = dueDate;
		this.returnedDate = returnedDate;
		this.activityStatus = activityStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
}
