package com.example.assignment_2;

public class Question {
    private final String question;
    private final boolean correctAnswer;
    private boolean isAnswered;
    private final String explanation;



    public boolean isCorrect(boolean answer) {
        return this.correctAnswer == answer;
    }

    public Question(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.explanation = "";
        this.isAnswered = false;
    }

    // early concept to add explanation to question
    // deprecated as of now, will probably come back in the future
    @Deprecated
    public Question(String question, boolean correctAnswer, String explanation) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }


    // GETTERS
    public String getQuestion() {
        return question;
    }

    public String getExplanation(){return explanation;}

    public boolean isAnswered(){
        return this.isAnswered;
    }

    // SETTERS
    public void setAnswerState(boolean state){
        this.isAnswered = state;
    }

}
