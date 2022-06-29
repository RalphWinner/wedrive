package com.wedrive.service;

import java.util.List;
import java.util.Optional;

import com.wedrive.model.Feedback;

public interface FeedbackService {
	 String saveFeedback(Feedback feedback);
	    List<Feedback> findAllFeedbacks();
	    Feedback findFeedbackbyID(Long id);

}
