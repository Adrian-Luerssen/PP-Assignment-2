package com.example.assignment_2;

import java.util.ArrayList;
import java.util.Random;

public class QuestionPool {
    private ArrayList<com.example.assignment_2.Question> questions;
    private int index;

    public void init(){

        index = 0;

        questions = new ArrayList<>();


    }
    public boolean isEmpty(){
        return questions.size() == 0;
    }
    public boolean answerIsCorrect(boolean answer) {

        return questions.get(index).isCorrect(answer);

    }
    public void nextQuestion() {
        index = (index < questions.size()-1)? index+1:index;
        System.out.println(index);

    }
    public void backQuestion() {
        index = (index == 0)? index:index-1;


    }

    public String getQuestionString() {
        return (isEmpty())?"There are no questions left.":questions.get(index).getQuestion();
    }
    public void addQuestion(String question, boolean correctAnswer, boolean wrongAnswer){
        questions.add(new Question(question,correctAnswer,wrongAnswer));
    }
    public String getQuestionExplanation(){
        return questions.get(index).getExplanation();
    }

    public void popCurrentQuestion(){
        questions.remove(index);
    }

    public void restartQuestions(){
        index = 0;
    }

}
