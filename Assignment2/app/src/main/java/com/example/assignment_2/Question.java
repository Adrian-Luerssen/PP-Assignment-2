package com.example.assignment_2;

public class Question {
    private String question;
    private boolean correctAnswer;
    private boolean wrongAnswer;
    private String explanation;

    public String getQuestion() {
        return question;
    }
    public String getExplanation(){return explanation;}

    public boolean isCorrect(boolean answer) {
        return this.correctAnswer == answer;
    }

    public Question(String question, boolean correctAnswer, boolean wrongAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.explanation = "";
    }
    public Question(String question, boolean correctAnswer, boolean wrongAnswer, String explanation) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.explanation = explanation;
    }
}
