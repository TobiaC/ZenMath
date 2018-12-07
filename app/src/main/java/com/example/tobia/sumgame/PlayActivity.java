package com.example.tobia.sumgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    static Math mathematics = new Math();

    private boolean isSecondNumber = false;
    private int intPoints = 0;
    int level = 1;
    int lives = 1;

    CountDownTimer my = new CountDownTimer(8000, 1000) {

        public void onTick(long millisUntilFinished) {
            TextView mTextField = findViewById(R.id.TextView);
            mTextField.setText("" + millisUntilFinished/1000);
        }

        public void onFinish() {
            TextView operation = findViewById(R.id.operationTexView);
            TextView operator = findViewById(R.id.operator);
            ImageView lifesImage = findViewById(R.id.lifeView);
            TextView levelText = findViewById(R.id.levelTexView);
            TextView result = findViewById(R.id.result);
            TextView firstNumber = findViewById(R.id.numberA);
            TextView secondNumber = findViewById(R.id.numberB);
            TextView tellIfRight = findViewById(R.id.checkView);
            TextView pointsTextView = findViewById(R.id.points);
            Button checkButton = findViewById(R.id.checkButton);
            checkIfRight(levelText, firstNumber, secondNumber, result, tellIfRight, pointsTextView, checkButton, lifesImage, operator, operation);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.theme);
        mediaPlayer.start();

        Button back = findViewById(R.id.BackButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
                mediaPlayer.stop();
            }
        });

        loadActivity();
    }

    private void loadActivity(){

        my.start();

        final Button checkButton = findViewById(R.id.checkButton);

        int numbersOnTheBoard[] = {mathematics.getRandom(mathematics.numbersAvailable, level),mathematics.getRandom(mathematics.numbersAvailable, level),mathematics.getRandom(mathematics.numbersAvailable, level),mathematics.getRandom(mathematics.numbersAvailable, level),mathematics.getRandom(mathematics.numbersAvailable, level),mathematics.getRandom(mathematics.numbersAvailable, level)};

        final TextView operation = findViewById(R.id.operationTexView);
        final TextView operator = findViewById(R.id.operator);
        final ImageView lifesImage = findViewById(R.id.lifeView);
        final TextView result = findViewById(R.id.result);
        final TextView firstNumber = findViewById(R.id.numberA);
        final TextView secondNumber = findViewById(R.id.numberB);
        final TextView tellIfRight = findViewById(R.id.checkView);
        final TextView pointsTextView = findViewById(R.id.points);
        final TextView levelText = findViewById(R.id.levelTexView);

        changeKindOfOperation(operation);

        final Button number1 = findViewById(R.id.number1);
        final Button number2 = findViewById(R.id.number2);
        final Button number3 = findViewById(R.id.number3);
        final Button number4 = findViewById(R.id.number4);
        final Button number5 = findViewById(R.id.number5);
        final Button number6 = findViewById(R.id.number6);

        number1.setText(Integer.toString(numbersOnTheBoard[0]));
        number2.setText(Integer.toString(numbersOnTheBoard[1]));
        number3.setText(Integer.toString(numbersOnTheBoard[2]));
        number4.setText(Integer.toString(numbersOnTheBoard[3]));
        number5.setText(Integer.toString(numbersOnTheBoard[4]));
        number6.setText(Integer.toString(numbersOnTheBoard[5]));




        result.setText(Integer.toString(mathematics.getRandomResult(numbersOnTheBoard, level)));
        firstNumber.setText("_");
        secondNumber.setText("_");
        checkButton.setText(getString(R.string.check));
        tellIfRight.setText("");



        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSecondNumber) {
                    firstNumber.setText(number1.getText());
                    isSecondNumber = true;
                } else {
                    secondNumber.setText(number1.getText());
                    isSecondNumber = false;
                }
            }
        });

        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSecondNumber) {
                    firstNumber.setText(number2.getText());
                    isSecondNumber = true;
                } else {
                    secondNumber.setText(number2.getText());
                    isSecondNumber = false;
                }
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSecondNumber) {
                    firstNumber.setText(number3.getText());
                    isSecondNumber = true;
                } else {
                    secondNumber.setText(number3.getText());
                    isSecondNumber = false;
                }
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSecondNumber) {
                    firstNumber.setText(number4.getText());
                    isSecondNumber = true;
                } else {
                    secondNumber.setText(number4.getText());
                    isSecondNumber = false;
                }
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSecondNumber) {
                    firstNumber.setText(number5.getText());
                    isSecondNumber = true;
                } else {
                    secondNumber.setText(number5.getText());
                    isSecondNumber = false;
                }
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSecondNumber) {
                    firstNumber.setText(number6.getText());
                    isSecondNumber = true;
                } else {
                    secondNumber.setText(number6.getText());
                    isSecondNumber = false;
                }
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkIfRight(levelText, firstNumber, secondNumber, result, tellIfRight, pointsTextView, checkButton, lifesImage, operator, operation);
            }
        });
    }

    /**
     *
     * @param levelText
     * @param firstNumber
     * @param secondNumber
     * @param result
     * @param tellIfRight
     * @param points
     * @param checkButton
     * @param lifes
     * @param operator
     * @param operation
     */
    void checkIfRight(final TextView levelText, TextView firstNumber, TextView secondNumber, TextView result, final TextView tellIfRight, final TextView points, Button checkButton, final ImageView lifes, TextView operator, TextView operation){
        MediaPlayer mediaPlayerError = MediaPlayer.create(this, R.raw.error);
        if (mathematics.checkResult(firstNumber, secondNumber, result, level)) {
           isRight(points, levelText, lifes, operator, operation);
        } else {
            if (lives>0) {
              //  mediaPlayerError.start();
                decreaseLife(lifes);
                loadActivity();
            } else {
                my.cancel();
                isGameOver(tellIfRight, checkButton, points, levelText, lifes, operator);
            }
        }
    }

    /**
     *
     * @param pointsTextView i punti vengono incrementati di uno quando la risposta è giusta
     * @param levelText      viene aggiornato al livello successivo se la risposta è giusta e i punti sono sufficienti
     * @param lifesImageView    viene guadagnata una vita al passaggio ad un livello successivo
     * @param operator  viene aggiornato al passaggio ad un nuovo tipo di operazione
     * @param operation viene aggiornata sul tipo di operazione corrente
     */
    void isRight(TextView pointsTextView, TextView levelText, ImageView lifesImageView, TextView operator, TextView operation){
        MediaPlayer mediaPlayerRight = MediaPlayer.create(this, R.raw.right);
        mediaPlayerRight.start();
        intPoints += 1;
        pointsTextView.setText(Integer.toString(intPoints));
        isSecondNumber = false;
        loadActivity();
        goToNextLevel(levelText, lifesImageView, intPoints, operator, operation);
    }

    /**
     *
     * @param tellIfRight   indica quando il gioco è terminato
     * @param checkButton   il puslante check passa alla modalità restart
     * @param pointsTextView    vengono azzerati i punti al game over
     * @param levelText         viene aggiornato al primo livello
     * @param lifesImage        viene aggiornata alla quantità di vite di partenza
     * @param operator          viene aggiornato all'operatore di partenza
     */
    void isGameOver(final TextView tellIfRight, Button checkButton, final TextView pointsTextView, final TextView levelText, final ImageView lifesImage, final TextView operator) {
        tellIfRight.setText(R.string.gameover);
        checkButton.setText(getString(R.string.restart));
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = 1;
                intPoints = 0;
                lives = 1;
                pointsTextView.setText(getString(R.string.zero));
                tellIfRight.setText("");
                levelText.setText(getString(R.string.lev1));
                lifesImage.setImageDrawable(getDrawable(R.drawable.nolifes));
                lifesImage.setImageDrawable(getDrawable(R.drawable.life));
                operator.setText("+");
                loadActivity();
            }
        });
    }

    /**
     *
     * @param lifesImage si aggiorna quando si guadagna o perde una vita
     */
    void decreaseLife(final ImageView lifesImage) {
        lives -= 1;
        isSecondNumber = false;

        if (lives == 0) {
            lifesImage.setImageDrawable(getDrawable(R.drawable.nolifes));
        } else if (lives == 1) {
            lifesImage.setImageDrawable(getDrawable(R.drawable.life));
        } else if (lives == 2) {
            lifesImage.setImageDrawable(getDrawable(R.drawable.twolifes));
        }
    }

    /**
     *
     * @param levelText si aggiorna quando si passa ad un livello successivo
     * @param operator si aggiorna quando si passa ad un'opearione diversa
     */

    void changeLevel(TextView levelText, TextView operator) {
        level += 1;
        if (level == 1) {
            levelText.setText(getString(R.string.lev1));
            operator.setText("+");
        } else if (level == 2) {
            levelText.setText(getString(R.string.lev2));
            operator.setText("+");
        } else if (level == 3) {
            levelText.setText(getString(R.string.lev3));
            operator.setText("+");
        } else if (level == 4) {
            levelText.setText(getString(R.string.lev4));
            operator.setText("*");
        } else if (level == 5) {
            levelText.setText(getString(R.string.lev5));
            operator.setText("*");
        } else if (level == 6) {
            levelText.setText(getString(R.string.lev6));
            operator.setText("*");
        }

    }

    /**
     *
     * @param lifes viene aggiunta una vita in caso di avanzamento di livello
     */
    void changeLife(ImageView lifes){
        lives += 1;
        if (lives == 1){
            lifes.setImageDrawable(getDrawable(R.drawable.life));
        } else if (lives == 2){
            lifes.setImageDrawable(getDrawable(R.drawable.twolifes));
        } else if (lives == 3){
            lifes.setImageDrawable(getDrawable(R.drawable.threelifes));
        }
    }

    /**
     *
     * @param levelText viene aggiornata da un'altro metodo
     * @param lifesImage viene aggiornata da un'altro metodo
     * @param intPoints in base al punteggio si passa o meno al livello successivo
     * @param operator viene aggiornata da un'altro metodo
     * @param operation viene aggiornata da un'altro metodo
     */
    void goToNextLevel(TextView levelText, ImageView lifesImage, int intPoints, TextView operator, TextView operation) {
        if (intPoints == 1 || intPoints == 2 || intPoints == 3 || intPoints == 35 || intPoints == 40 || intPoints == 45) {
            changeLevel(levelText, operator);
            changeLife(lifesImage);
            changeKindOfOperation(operation);
        }
    }

    /**
     *
     * @param operation aggiorna il tipo di operazione
     */
    void changeKindOfOperation(TextView operation){
        if (level <= 3){
            operation.setText("Sum");
        } else {
            operation.setText("Product");
        }
    }
}
