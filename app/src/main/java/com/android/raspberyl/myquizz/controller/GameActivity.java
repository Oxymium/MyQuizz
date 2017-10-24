package com.android.raspberyl.myquizz.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.raspberyl.myquizz.R;
import com.android.raspberyl.myquizz.model.Question;
import com.android.raspberyl.myquizz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mGameTextQuestion;
    private Button mGameButton1;
    private Button mGameButton2;
    private Button mGameButton3;
    private Button mGameButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;
    private int mNumberOfQuestions;

    private int mScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        mScore = 0;
        mNumberOfQuestions = 4;

        mGameTextQuestion = (TextView) findViewById(R.id.question_game_text);
        mGameButton1 = (Button) findViewById(R.id.answer_button1);
        mGameButton2 = (Button) findViewById(R.id.answer_button2);
        mGameButton3 = (Button) findViewById(R.id.answer_button3);
        mGameButton4 = (Button) findViewById(R.id.answer_button4);

        //On commence à compter à partir de 0. Donc le premier boutton a un index égal à 0
        mGameButton1.setTag(0);
        mGameButton2.setTag(1);
        mGameButton3.setTag(2);
        mGameButton4.setTag(3);

        mGameButton1.setOnClickListener(this);
        mGameButton2.setOnClickListener(this);
        mGameButton3.setOnClickListener(this);
        mGameButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);

    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            //Good
            Toast.makeText(this, "Nice :) !", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            //False
            Toast.makeText(this, "False :( !", Toast.LENGTH_SHORT).show();
        }

        if (--mNumberOfQuestions == 0) {
            //End of the game
            endGame();
        } else {
            mCurrentQuestion  = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Good game!").setMessage("Your score is " + mScore).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //end the activity
                finish();
            }
        })
                .create()
                .show();
    }

    private void displayQuestion(final Question question) {
        mGameTextQuestion.setText(question.getQuestion());
        mGameButton1.setText(question.getChoiceList().get(0));
        mGameButton2.setText(question.getChoiceList().get(1));
        mGameButton3.setText(question.getChoiceList().get(2));
        mGameButton4.setText(question.getChoiceList().get(3));

    }

    //INDEX STARTS AT 0 !! (lost 2h)
    private QuestionBank generateQuestions() {

        Question question1 = new Question("What is the lightest element?", Arrays.asList("Iron (Fe)", "Helium (He)", "Hydrogen (H)", "Carbon (C)" ), 2);

        Question question2 = new Question("What is the biggest country by sheer size?", Arrays.asList("China", "Russia", "Canada", "United States of America"), 1);

        Question question3 = new Question("Which color has the shortest wavelength?", Arrays.asList("Yellow", "Pink", "Red", "Blue"), 3);

        Question question4 = new Question("Which American state is the most populated one?", Arrays.asList("California", "Florida", "Texas", "Alaska"), 0);

        Question question5 = new Question("How many bones does a single human arm have?", Arrays.asList("58", "60", "62", "64"), 3);

        Question question6 = new Question("What is the closest planet to the Sun?", Arrays.asList("Earth", "Mercury", "Venus", "Jupiter"), 1);

        Question question7 = new Question("What is the size of the Earth (approximately, in km)?", Arrays.asList("5 400km", "6 000km", "6 400 km", "6 800 km"), 2);

        Question question8 = new Question("π approximately equals to :", Arrays.asList("3.14159", "3.14169", "3.14179", "3.14189"), 0);

        Question question9 = new Question("How tall is the Eiffel Tower (approximately, in m)?", Arrays.asList("200m", "300m", "400m", "500m"), 1);

        Question question10 = new Question("What is the name of our galaxy?", Arrays.asList("Andromeda", "The Milky Way", "Magellanic Clouds", "Sombrero Galaxy"), 1);

        Question question11 = new Question("Which of the following elements is the heaviest?", Arrays.asList("Nitrogen (N)", "Zinc (Zn)", "Gold (Au)", "Platinum (Pt)"), 2);

        Question question12 = new Question("What is the largest Ocean on Earth?", Arrays.asList("The Arctic Ocean", "The Indian Ocean", "The Atlantic Ocean", "The Pacific Ocean"), 3);

        Question question13 = new Question("Who invented the alternating current?", Arrays.asList("Albert Einstein", "Nikola Tesla", "Thomas Edison", "Bill Gates"), 1);

        Question question14 = new Question("日本語 are Japanese characters also known as:", Arrays.asList("Hanji", "Banji", "Nanji", "Kanji"), 3);

        Question question15 = new Question("How much is the speed of light in a vacuum (approximately, in km/s)?", Arrays.asList("150 000 km/s", "200 000 km/s", "300 000 km/s", "350 000 km/s"), 2);

        Question question16 = new Question("What's the highest-grossing film in history?", Arrays.asList("Titanic", "Avatar", "Star Wars : The Force Awakens", "Jurassic World"), 1);

        Question question17 = new Question("Android applications are mostly coded in:", Arrays.asList("JAVA", "C++", "Objective C", "Swift"), 0);

        Question question18 = new Question("0 + 6 x 6 + 4 = ?", Arrays.asList("0", "20", "40", "60"), 2);

        Question question19 = new Question("Which beverage is the most consumed world-wide?", Arrays.asList("Coffee", "Tea", "Coca-cola", "Vodka"), 0);

        Question question20 = new Question("In the famous equation E=mc², c stands for:?", Arrays.asList("Conductivity", "Celerity", "Constant", "Crystal"), 1);

        return new QuestionBank(Arrays.asList(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14, question15, question16, question17, question18, question19, question20));
    }
}
