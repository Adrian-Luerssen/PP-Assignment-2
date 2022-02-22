package com.example.assignment_2;

import java.util.ArrayList;

public class QuestionPool {

    private ArrayList<com.example.assignment_2.Question> questions;

    private int correctAnswers;

    private int index;

    public void init(){

        index = 0;

        correctAnswers = 0;

        questions = new ArrayList<>();


    }
    public boolean isEmpty(){
        return questions.size() == 0;
    }

    public boolean answerIsCorrect(boolean answer) {

        return questions.get(index).isCorrect(answer);

    }
    public void nextQuestion() {

        index++;

        // changed previous code to an if statement to make the arrows circular
        if(index == questions.size()){
            index = 0;
        }

        System.out.println(index);

    }
    public void backQuestion() {

        index--;

        // changed it to an if statement to make the arrows circular
        if(index < 0){
            index = questions.size() - 1;
        }

    }

    public String getQuestionString() {
        return (isEmpty())?"There are no questions left.":questions.get(index).getQuestion();
    }
    public void addQuestion(String question, boolean correctAnswer){
        questions.add(new Question(question,correctAnswer));
    }

    public String getQuestionExplanation(){
        return questions.get(index).getExplanation();
    }

    public void popCurrentQuestion(boolean answerCorrect){

        if(answerCorrect){
            correctAnswers++;
        }

        questions.remove(index);

    }

    public void restartQuestions(){
        index = 0;
    }

    public int getCorrectAnswers(){
        return correctAnswers;
    }

}
