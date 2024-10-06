package model.domain;

import java.util.List;

public class Quiz {
	private String title;
	private List<Question> questions;
    private User createdBy;
    
    
	public Quiz(String title, List<Question> questions, User createdBy) {
		super();
		this.title = title;
		this.questions = questions;
		this.createdBy = createdBy;
	}


	public String getTitle() {
		return title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public User getCreatedBy() {
		return createdBy;
	}

    
	public void createQuiz() {
		
	}
	
	public void attemptQuiz(User user) {
		
	}
	
	public void viewAnswer(User user) {
		
	}
}