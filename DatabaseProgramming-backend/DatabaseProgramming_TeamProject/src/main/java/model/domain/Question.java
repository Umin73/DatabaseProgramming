package model.domain;

import java.util.List;

public class Question {
	
	private String questionText;
	private List<String> options;
	private String correctAnswer;
	
	public Question(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
	
	public boolean checkAnswer(String answer) {
		return answer.equals(correctAnswer);
	}
	
	public String getQuestionText() {
        return questionText;
    }
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public List<String> getOptions() {
        return options;
    }
	
	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	public String getCorrectAnswer() {
        return correctAnswer;
    }
	
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}