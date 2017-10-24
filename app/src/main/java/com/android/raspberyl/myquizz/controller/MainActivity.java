package com.android.raspberyl.myquizz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView; //
import android.widget.EditText; // L'importantion de ces packages est proposée à la création des variables ou methods correspondantes
import android.widget.Button; //
import android.content.Intent;
import android.view.View;

import com.android.raspberyl.myquizz.R;
import com.android.raspberyl.myquizz.model.User;

public class MainActivity extends AppCompatActivity { // Indique que c'est la class sur laquelle l'application commence

    private ImageView mLogoImage; //
    private EditText mNameInput; // Création des variables qui servent à recenser les éléments visuels
    private Button mStartButton; //
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogoImage = (ImageView) findViewById(R.id.my_quizz_logo); // methods qui asssignent les variables aux éléments graphiques recensés par des ID dans les fichiers layouts
        mStartButton = (Button) findViewById(R.id.activity_start_button); //
        mStartButton.setEnabled(false); //boutton Start désactivé (method)
        mNameInput = (EditText) findViewById(R.id.activity_name_input);
        mUser = new User();

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mStartButton.setEnabled(s.toString().length() > 0);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mNameInput.getText().toString();
                mUser.setUserName(userName);
                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivity);

            }

        });

    }

}






