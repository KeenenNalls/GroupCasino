package com.github.zipcodewilmington.casino.games.numberguess;

/**
 * Created by leon on 7/21/2020.
 */
import java.util.Scanner;
public class NumberGuessGame {
        private Player player; //This line declares a private variable named player of type Player. In this context, Player refers to a class that represents a player in the number guess game. By declaring it as private, the variable is only accessible within the class it is declared in (in this case, the NumberGuessGame class).
        private Scanner scanner; //This line declares a private variable named scanner of type Scanner. A Scanner is a Java class that allows reading user input from the console. Declaring it as private means that it is only accessible within the NumberGuessGame class.
        private int targetNumber; //This line declares a private variable named targetNumber of type int. It is used to store the randomly generated number that the player needs to guess in the number guess game.
        private int numberOfTries; //This line declares a private variable named numberOfTries of type int. It is used to keep track of the number of remaining attempts the player has to guess the correct number. The game may end after a certain number of tries.
        private String playAgainChoice; //This line declares a private variable named playAgainChoice of type String. It is used to store the player's choice of whether to play the game again or not. The game may prompt the player to input either "yup" or "nah" (yes or no) to determine if they want to play another round.

    //By declaring these variables as private, the NumberGuessGame class encapsulates its internal state, ensuring that other classes cannot directly access or modify these variables. Instead, other classes interact with the NumberGuessGame class through its public methods, which control and manage the game's behavior based on the values stored in these private variables.
    public NumberGuessGame() {
            this.scanner = new Scanner(System.in);
            this.numberOfTries = 3;
        }

        public void add(Player player) {
            this.player = player;
        }

        public void run() {
            System.out.println(displayInstructions()); //This line prints the game's instructions to the console. It tells the player to guess a number between 1 and 10.
            boolean playAgain = true;  //This line sets a boolean variable
            while (playAgain) { //This line starts a loop that will keep running the game as long as playAgain is true.
                targetNumber = (int) (Math.random() * 10) + 1; // Generate a random number between 1 and 10
                numberOfTries = 3;
                boolean isWinner = false; //It will later be used to check if the player guessed the correct number.

                while (!isWinner && numberOfTries > 0) { //This line starts another loop that runs as long as the player hasn't won
                    int userGuess = getUserGuess(); //This line gets the player's guess from the user (input from the console) and stores it in the userGuess variable.
                    isWinner = checkWinner(userGuess); //This line checks if the userGuess is equal to the targetNumber (the correct number to guess). If the guess is correct, isWinner becomes true, and the player wins.
                    numberOfTries--; //This line decreases the number of remaining tries by 1, as the player made an attempt.
                    if (isWinner) {
                        System.out.println("Congratulations!!!! You LUCKILY guessed the right number: " + targetNumber);
                    } else if (numberOfTries > 0) { //the player's guess is incorrect, but they have more attempts left. The game prints a message encouraging the player to try again.
                        System.out.println("Better Luck Next Time!");
                    }
                    else {
                        System.out.println("Out of attempts! The number was " + targetNumber);
                    }

                }

                playAgain();
                if(playAgainChoice.equalsIgnoreCase("yup")) {
                    playAgain = true;
                } else if(playAgainChoice.equalsIgnoreCase("nah")) {
                    playAgain = false;
                }
            }
//            quit();
        }

        public String displayInstructions() {
            return "Welcome to the rigged for our casino Number Guessing Game!!!! Try to guess the number between 1 and 10.";
        }

        public int getUserGuess() {
            System.out.print("Waste Your Money On A Guess: ");
            return scanner.nextInt();
        }

        public boolean checkWinner(int userGuess) {
            if (userGuess == targetNumber) {
                return true;
            } else if (userGuess < targetNumber) {
                System.out.println("Seriously? Try Higher!");
            } else {
                System.out.println("Try going lower");
            }
            return false;
        }

        public String playAgain() {
            System.out.print("Play Again? (yup/nah): ");
            playAgainChoice = scanner.next().toLowerCase();
            return playAgainChoice;
        }

        public void quit() {
            System.out.println("Thank you for playing, Stop quitting everything!");
            scanner.close();
        }

//        public static void main(String[] args) {
//            NumberGuessGame game = new NumberGuessGame();
//            Player player = new Player();
//            game.add(player);
//            game.run();
//        }
    }

    class Player {
        // You can add additional methods or attributes specific to the player here
    }

//minor change to try and push