import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random rdm = new Random();
        
        int score = 0;
        boolean PlayAgain = true;
        
        while (PlayAgain) {
            System.out.println("Welcome to the Number Game");
            System.out.println("You have 7 attempts to guess the correct number between 101 and 200.");
            
            int start = 101;
            int end = 200;
            int NumberToGeuss = rdm.nextInt((end - start) + 1) + start;
            int attempts = 7;
            boolean correct = false;
            
            while (attempts > 0) {
                System.out.print("Hey user please enter your number: ");
                int userGuess = sc.nextInt();
                
                if (userGuess == NumberToGeuss) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    score++;
                    correct = true;
                    break;
                } else if (userGuess > NumberToGeuss) {
                    System.out.println("Your Number is GREATER than the generated number.");
                } else {
                    System.out.println("Your Number is SMALLER than the generated number.");
                }
                
                attempts--;
                System.out.println("Reamining Attempts are: "+attempts);
            }
            
            if (!correct) {
                System.out.println("Sorry, No more Attempts. The correct number was: " + NumberToGeuss);
            }
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next();
            if (response.equalsIgnoreCase("no")) {
                PlayAgain = false;
            }
        }
        
        System.out.println("GAME OVER! YOUR TOTAL SCORE: " + score);
        sc.close();
    }
}
