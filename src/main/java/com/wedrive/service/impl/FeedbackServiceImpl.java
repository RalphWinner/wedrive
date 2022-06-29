package com.wedrive.service.impl;

import java.util.List;
import java.util.Optional;

import com.wedrive.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import com.wedrive.model.Feedback;
import com.wedrive.repository.FeedbackRepository;
import com.wedrive.service.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	private FeedbackRepository feedbackRepository;

	@Autowired
	public FeedbackServiceImpl(FeedbackRepository feedbackRepo) {
		this.feedbackRepository = feedbackRepo;
		
	}
	
	@Override
	public String saveFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
		return "saved";
	}

	@Override
	public List<Feedback> findAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback findFeedbackbyID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
