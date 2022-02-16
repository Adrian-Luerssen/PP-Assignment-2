package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView score;

    private Button trueButton;
    private Button falseButton;
    private Button resetButton;
    private Button nextButton;
    private Button backButton;

    private int scoreCounter = 0;
    private int answerCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuestionPool questionPool = new QuestionPool();
        questionPool.init();
        initVars();
        questionPool.addQuestion(getString(R.string.Question1),true,false);
        questionPool.addQuestion(getString(R.string.Question2),true,false);
        question.setText(questionPool.getQuestionString());
        // setting the initial question on start up
        // creating the toast for a correct answer
        Toast correctToast= Toast.makeText(getApplicationContext(), R.string.toast_correct, Toast.LENGTH_LONG);
        correctToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 250);
        // creating the toast for an incorrect answer
        Toast incorrectToast= Toast.makeText(getApplicationContext(), R.string.toast_incorrect, Toast.LENGTH_LONG);
        incorrectToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 250);


        trueButton.setOnClickListener(view -> {
            if (!questionPool.isEmpty()){

                // the user presses true, display the corresponding toast if the answer is correct or not
                if (questionPool.answerIsCorrect(true)) {
                    correctToast.setText(getString(R.string.toast_correct)+"\n"+questionPool.getQuestionExplanation());
                    correctToast.show();
                    scoreCounter += 1;
                } else {
                    incorrectToast.setText(getString(R.string.toast_incorrect)+"\n"+questionPool.getQuestionExplanation());
                    incorrectToast.show();

                }
                answerCounter += 1;

            } else{
                question.setText(questionPool.getQuestionString()); // changes the display question
            }

        });

        falseButton.setOnClickListener(view -> {
            if (!questionPool.isEmpty()){

                // the user presses true, display the corresponding toast if the answer is correct or not
                if (questionPool.answerIsCorrect(false)) {
                    correctToast.setText(getString(R.string.toast_correct)+"\n"+questionPool.getQuestionExplanation());
                    correctToast.show();

                    scoreCounter += 1;
                } else {
                    incorrectToast.setText(getString(R.string.toast_incorrect)+"\n"+questionPool.getQuestionExplanation());
                    incorrectToast.show();
                }
                answerCounter += 1;


            } else {
                question.setText(questionPool.getQuestionString()); // changes the display question
            }
        });

        resetButton.setOnClickListener(view -> {
            questionPool.restartQuestions();
            answerCounter = 0;
            scoreCounter = 0;
            question.setText(questionPool.getQuestionString()); // changes the display question
            score.setText(R.string.Score);
        });

        nextButton.setOnClickListener(view -> {
            questionPool.nextQuestion();
            question.setText(questionPool.getQuestionString()); // changes the display question

        });

        backButton.setOnClickListener(view -> {
            questionPool.backQuestion();
            question.setText(questionPool.getQuestionString()); // changes the display question

        });

    }

    public void initVars(){
        backButton = (Button) findViewById(R.id.back_button);
        nextButton = (Button) findViewById(R.id.next_button);
        resetButton = (Button) findViewById(R.id.reset_button);   // reset button in the view
        trueButton = (Button) findViewById(R.id.true_button);   // true button in the view
        falseButton = (Button) findViewById(R.id.false_button); // false button in the view
        question = (TextView) findViewById(R.id.question); // text box displaying the question in the view
        score = (TextView) findViewById(R.id.score);

    }


}