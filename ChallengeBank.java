import java.util.Random;

public class ChallengeBank {
    public static final Challenge[] EASY = {
        new Challenge("Write a command to show the current working directory", "pwd"),
        new Challenge("Write a command to list all files in the current directory", "ls"),
        new Challenge("Write a command to create a directory called \"test\"", "mkdir test"),
        new Challenge("Write a command to delete a file called \"test.txt\"", "rm test.txt"),
        new Challenge("Write a command to change the current directory to \"/home/users/work/college/semester1\"", "cd /home/users/work/college/semester1"),

    };

    public static final Challenge[] MEDIUM = {
        new Challenge("You are currently in directory \"/home/users/work/college/semester1\"" +
        "\n create a file with the name of \"HelloWorld.txt\"" +
        "inside of directory \"/home/users/work/university/semester3\" using relative pathing", 
        "touch ../../university/semester3/HelloWorld.txt"),
        new Challenge("Write a command to display all files in the previous directory, including hidden ones, that starts with the letter \"a\"", "ls -a ../a*"),
        

    };

    public static final Challenge[] HARD = {
        new Challenge("")

    };

    // banks for challenges of the 3 types of difficulties

    static Random random = new Random();

    public static Challenge getRandom(int difficulty) {
        Challenge[] section;
        switch (difficulty) {
            case 1: section = EASY; break;
            case 2: section = MEDIUM; break;
            case 3: section = HARD; break;
            default: throw new IllegalArgumentException("Difficulty must be 1 to 3");
        }

        return section[random.nextInt(section.length)];
    }
}
