import java.util.Scanner;
import java.util.Random;
public class BashLearningGame {
    public static void main(String[] args) {
        playGame();
    }
    

    public static void instructions() {
        System.out.println("Welcome to the Bash Learning Game!\n" +
                           "Practice your Bash skills by completing one daily challenge of the difficulty\n" +
                           "level of your choice, being EASY, MEDIUM, or HARD. You will be asked to write a \n" +
                           "BASH command to complete a task, based on it's difficulty level.\n" +
                           "You have FIVE (5) attempts to complete each challenge. You can write 'help' at any time to access the BASH manual.\n" +
                           "If you fail to complete the challenge in five attempts, you will receive an explanation on how to complete\n" + 
                            "the challenge and the correct command to do so.\n" +
                           "Your score will be 0 if you fail to complete the challenge, you will have the chance to try again the\n" +
                           "next day!");
    }
    public static int getDifficultyLevel() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Choose a difficulty level:");
        System.out.println("1. EASY");
        System.out.println("2. MEDIUM");
        System.out.println("3. HARD");
        String difficulty = reader.next();
        char firstChar = difficulty.charAt(0);
        boolean isTooLong = difficulty.length() > 1;
        int difficultyLevel = firstChar - 49 + 1;
        for (boolean validInput = difficultyLevel >= 1 && difficultyLevel <= 3; !validInput; validInput = difficultyLevel >= 1 && difficultyLevel <= 3) {
            System.out.println("Invalid input. Please choose a valid difficulty level.");
            difficulty = reader.next(); 
            firstChar = difficulty.charAt(0);
            difficultyLevel = firstChar - 49 + 1;
        }
        return difficultyLevel;
    }
    public static void playGame() {
        Scanner reader = new Scanner(System.in);
        int MAX_ATTEMPTS = 5;
        instructions();
        int difficulty = getDifficultyLevel();
        Challenge challenge = ChallengeBank.getRandom(difficulty);
        System.out.println("Your challenge is: " + challenge.getPrompt());
        String input = help();
        int attempt = 1;               
        for (boolean isSolved = challenge.checkAnswer(input); !isSolved && !(attempt > MAX_ATTEMPTS); isSolved = challenge.checkAnswer(input)) {
            System.out.println("Incorrect answer. Try again!");
            input = help();
            attempt++;
        }
        if (attempt > MAX_ATTEMPTS) {
            System.out.println("You have exceeded the maximum number of attempts. The correct answer is: " + challenge.getAnswer());
        } else {
            System.out.println("Congratulations! You have completed the daily BASH challenge. Come back tomorrow for a new one!");
        }
    }
    public static String help() {
        Scanner reader = new Scanner(System.in);
        while (true) {
            String line = reader.nextLine().trim();
            if (line.equalsIgnoreCase("help")) { 
                System.out.println("You can find the BASH manual at the following link:");
                System.out.println("https://www.gnu.org/software/bash/manual/bash.html");
                System.out.print("> ");
            } else {
                return line;
            }
        }
    }
}