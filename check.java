import java.util.Scanner;
public class check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 1, max = 100;
        int score = 0;
        boolean play = true;
        while (play) {
            boolean right = false;
            int comp = (min + (int) (Math.random() * (max - min) + 1));
            int count = 5;

            System.out.println("Limit for number of attempts by the user is 5");

            while (count > 0) {
                System.out.println("Enter a numnber randomly between 1 to 100");
                int user = sc.nextInt();
                if (comp == user) {
                    System.out.println("The number guessed is correct");
                    score++;
                    right = true;
                    break;
                } else if (comp > user) {
                    System.out.println("The number guessed by user is too low");

                } else {
                    System.out.println("The number guessed by user is too high");
                }
            }
        }
    }
}