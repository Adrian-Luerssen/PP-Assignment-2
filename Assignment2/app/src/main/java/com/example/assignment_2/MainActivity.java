package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView score;

    private Button trueButton;
    private Button falseButton;
    private Button resetButton;
    private Button nextButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuestionPool questionPool = new QuestionPool();
        // saving the question and answer strings for later use
        // done as variable to make it more readable
        String[] questionArray = getResources().getStringArray(R.array.questions);
        String[] answerArray = getResources().getStringArray(R.array.answers);
        questionPool.init();
        initVars();
        // filling the question pool with the previously loaded strings
        // boolean parsing is required in the answerArray, done with equals
        for(int i = 0; !questionArray[i].equals("No question has been loaded"); i++){
            questionPool.addQuestion(questionArray[i], answerArray[i].equals("TRUE"));
        }
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
                    correctToast.setText(getString(R.string.toast_correct)+"\n" + questionPool.getQuestionExplanation());
                    correctToast.show();
                    questionPool.popCurrentQuestion(true);
                    score.setText(String.format(Locale.ENGLISH, "Score: %d", questionPool.getCorrectAnswers()));
                } else {
                    incorrectToast.setText(getString(R.string.toast_incorrect) + "\n" + questionPool.getQuestionExplanation());
                    incorrectToast.show();
                    questionPool.popCurrentQuestion(false);

                }

                // shift index to next question
                questionPool.nextQuestion();
                // change the text to make it into the new question
                question.setText(questionPool.getQuestionString());

            } else{
                question.setText(questionPool.getQuestionString()); // changes the display question
            }

        });

        falseButton.setOnClickListener(view -> {
            if (!questionPool.isEmpty()){

                // the user presses true, display the corresponding toast if the answer is correct or not
                if (questionPool.answerIsCorrect(false)) {
                    correctToast.setText(getString(R.string.toast_correct) + "\n" + questionPool.getQuestionExplanation());
                    correctToast.show();
                    questionPool.popCurrentQuestion(true);
                    score.setText(String.format(Locale.ENGLISH, "Score: %d", questionPool.getCorrectAnswers()));

                } else {
                    incorrectToast.setText(getString(R.string.toast_incorrect)+"\n"+questionPool.getQuestionExplanation());
                    incorrectToast.show();
                    questionPool.popCurrentQuestion(false);
                }

                // shift index to next question
                questionPool.nextQuestion();
                // change the text to make it into the new question
                question.setText(questionPool.getQuestionString());


            } else {
                question.setText(questionPool.getQuestionString()); // changes the display question
            }


        });

        resetButton.setOnClickListener(view -> {
            questionPool.restartQuestions();
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