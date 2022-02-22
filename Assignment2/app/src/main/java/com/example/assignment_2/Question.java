package com.example.assignment_2;

public class Question {
    private final String question;
    private final boolean correctAnswer;
    private final String explanation;

    public String getQuestion() {
        return question;
    }
    public String getExplanation(){return explanation;}

    public boolean isCorrect(boolean answer) {
        return this.correctAnswer == answer;
    }

    public Question(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.explanation = "";
    }
    public Question(String question, boolean correctAnswer, String explanation) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }
}
