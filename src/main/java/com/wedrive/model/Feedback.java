package com.wedrive.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long feedbackId;

	@OneToOne
	@JoinColumn(name = "rental_id")
	private Rental rental;
	
	@Column(name="message")
	private String message;
	
	@Column(name="feedbackDate")
	private LocalDateTime feedbackDate;

	public Feedback() {
	}

	public Feedback(long feedbackId, String message, LocalDateTime feedbackDate) {
		super();
		this.feedbackId = feedbackId;
		this.message = message;
		this.feedbackDate = feedbackDate;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(LocalDateTime feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	
	

}
