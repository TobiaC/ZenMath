package com.example.tobia.sumgame;

import android.widget.TextView;

import java.util.Random;

 class Math {

     private int numbersLevel1[] = {1,2,3,4,5,6,7,8,9};
     private int numbersLevel2[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
     private int numbersLevel3[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59};
     int[] numbersAvailable[] = {numbersLevel1, numbersLevel2, numbersLevel3};


     /**
      *
      * @param array insieme di numeri da cui sceglierne 6 per posizionarli nei bottoni
      * @param level in base al livello ci sono diversi insiemi di numeri più o meno grandi
      * @return un numero casuale dall'insieme
      */
    int getRandom(int[][] array, int level) {
        if (level == 1 || level == 4 || level == 7) {
            int rnd = new Random().nextInt(array[0].length);
            return (array[0][rnd]);
        } else if (level == 2 || level == 5 || level == 8) {
            int rnd = new Random().nextInt(array[1].length);
            return (array[1][rnd]);
        } else{
            int rnd = new Random().nextInt(array[2].length);
            return (array[2][rnd]);
        }
    }

     /**
      *
      * @param array insieme di numeri
      * @param level in base al livello ci sono diversi insiemi di numeri più o meno grandi
      * @return il risultato di un'operazione tra due numeri casuali scelti dall'insieme
      */
   int getRandomResult(int[] array, int level) {
       int rnd = new Random().nextInt(array.length);
       int rnd1 = new Random().nextInt(array.length);
       if (level == 1 || level == 2 || level == 3) {
           return (array[rnd] + array[rnd1]);
       } else  {
           return (array[rnd] * array[rnd1]);
       }
    }

     /**
      *
      * @param firstNumber primo numero inserito dall'utente
      * @param secondNumber secondo numero inserito dall'utente
      * @param result risultato casuale dato dal software
      * @param level in base al livello viene effettuata una determinata operazione
      * @return vero se i numeri inseriti dall'utente soddisfano l'equazione, falso in caso contrario
      */
    boolean checkResult(TextView firstNumber, TextView secondNumber, TextView result, int level){
        int numResult = Integer.parseInt(result.getText().toString());
        int numA;
        int numB;
        if (firstNumber.getText().toString().equals("_") && secondNumber.getText().toString().equals("_")) {
            numA = 0;
            numB = 0;

            return result(numA, numB, numResult, level);

        } else if(firstNumber.getText().toString().equals("_")) {
            numA = 0;
            numB = Integer.parseInt(secondNumber.getText().toString());

            return result(numA, numB, numResult, level);

        } else if (secondNumber.getText().toString().equals("_")) {
            numB = 0;
            numA = Integer.parseInt(firstNumber.getText().toString());

            return result(numA, numB, numResult, level);

        } else {
         numA = Integer.parseInt(firstNumber.getText().toString());
         numB = Integer.parseInt(secondNumber.getText().toString());

            return result(numA, numB, numResult, level);
        }
    }


    private boolean result(int numA, int numB, int numResult, int level){
        if (level == 1 || level == 2 || level == 3){
            return (numA + numB == numResult);
        } else {
            return (numA * numB == numResult);
        }
    }
}//class
