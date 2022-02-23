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
    public boolean isEmpty(){
        return questions.size() == totalAnswered;
    }

    public boolean answerIsCorrect(boolean answer) {

        return questions.get(index).isCorrect(answer);

    }
    public void nextQuestion() {

        if(totalAnswered != questions.size()) {
            index++;

            for (; true; index++) {

                if (index == questions.size()) {
                    index = 0;
                }

                if (!questions.get(index).isAnswered()) {
                    break;
                }
            }
        }

        System.out.println(index);

    }
    public void backQuestion() {

        if(totalAnswered != questions.size()) {
            index--;

            for (; true; index--) {

                if (index < 0) {
                    index = questions.size() - 1;
                }

                if (!questions.get(index).isAnswered()) {
                    break;
                }
            }
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

    public int getCorrectAnswers(){
        return correctAnswers;
    }

}
