package com.example.assignment_2;

import java.util.ArrayList;

public class QuestionPool {

    private ArrayList<com.example.assignment_2.Question> questions;

    private int correctAnswers;

    private int totalAnswered;

    private int index;

    public void init(){

        index = 0;

        correctAnswers = 0;

        questions = new ArrayList<>();

    }

    //GETTERS

    public int getCorrectAnswers(){
        return correctAnswers;
    }

    public String getQuestionExplanation(){
        return questions.get(index).getExplanation();
    }

    public String getQuestionString() {
        return questions.get(index).getQuestion();
    }

    public boolean isCurrentQuestionAnswered(){
        return !questions.get(index).isAnswered();
    }

    public int getTotalAnswered() {
        return totalAnswered;
    }

    // stopped using it as we changed the way of moving in ArrayList
    // kept it just for future checks
    @Deprecated
    public boolean isEmpty(){
        return questions.size() == totalAnswered;
    }

    public boolean answerIsCorrect(boolean answer) {

        return questions.get(index).isCorrect(answer);

    }

    //SETTERS

    public void nextQuestion() {


        index++;

        if (index == questions.size()) {
            index = 0;
        }

        // debugging
        System.out.println(index);

    }

    public void backQuestion() {

        index--;

        if (index < 0) {
            index = questions.size() - 1;
        }

        // debugging
        System.out.println(index);

    }

    public void addQuestion(String question, boolean correctAnswer){
        questions.add(new Question(question,correctAnswer));
    }

    public void answeredCurrentQuestion(boolean answerCorrect){

        if(answerCorrect){
            correctAnswers++;
        }

        questions.get(index).setAnswerState(true);
        totalAnswered++;

        System.out.print(totalAnswered);

    }

    public void restartQuestions(){

        index = 0;
        correctAnswers = 0;
        totalAnswered = 0;

        for(int i = 0; i < questions.size(); i++){
            questions.get(i).setAnswerState(false);
        }

    }

}
