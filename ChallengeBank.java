import java.util.Random;

public class ChallengeBank {
    public static final Challenge[] EASY = {
            new Challenge("Write a command to show the current working directory", "pwd"),
            new Challenge("Write a command to list all files in the current directory", "ls"),
            new Challenge("Write a command to create a directory called \"test\"", "mkdir test"),
            new Challenge("Write a command to delete a file called \"test.txt\"", "r test.txt"),
            new Challenge("Write a command to change the current directory to \"/home/users/work/college/semester1\"",
                    "cd /home/users/work/college/semester1"),

    };

    public static final Challenge[] MEDIUM = {
            new Challenge("You are currently in directory \"/home/users/work/college/semester1\"" +
                    "\n create a file with the name of \"HelloWorld.txt\"" +
                    "inside of directory \"/home/users/work/university/semester3\" using relative pathing",
                    "touch ../../university/semester3/HelloWorld.txt"),
            new Challenge(
                    "Write a command to display all files in the previous directory, including hidden ones, that starts with the letter \"a\"",
                    "ls -a ../a*"),
            new Challenge(
                    "Write a command to display the contents of the file \"test.txt\" in the terminal with numbered lines and no extra empty lines",
                    "cat -bs test.txt"),
            new Challenge("Write a command to display the first 20 bytes of the file \"test.txt\" in the terminal",
                    "head -c 20test.txt"),
            new Challenge("Write a command to remove a directory called \"test\" and all of its contents", "rm -r test")

    };

    public static final Challenge[] HARD = {
            new Challenge(
                    "Recursively scan the current directory, find all files that have identical contents (even if their filenames differ), and group them together without failing on spaces or special characters in filenames.",
                    "find . -type f -print0 | xargs -0 sha256sum | sort | uniq -w64 -D"),
            new Challenge(
                    "Parse an Nginx/Apache access log in real time or from a massive file, extract the client IP addresses, count occurrences, and print the top 10 most frequent IPs sorted descending.",
                    "awk '{print $1}' access.log | sort | uniq -c | sort -rn | head -n 10"),
            new Challenge(
                    "Find and forcefully terminate all running processes matching a specific string (e.g., python_worker) without accidentally killing your own grep command or requiring pkill.",
                    "ps aux | awk '/[p]ython_worker/ {print $2}' | xargs -r kill -9"),
            new Challenge(
                    "Read a file (ids.txt) containing one ID per line, strip empty lines, wrap each ID in single quotes, and join them into a single comma-separated line ready for a SQL query (e.g., 'id1','id2','id3').",
                    "grep -v '^$' ids.txt | sed \"s/.*/'&'/\" | paste -sd ',' -"),
            new Challenge(
                    "Your disk shows 100% full, even though du shows plenty of free space because a running process is still writing to a deleted file. List the PIDs, process names, and sizes of open deleted files.",
                    "lsof +L1 | awk 'NR==1 || /deleted/ {printf \"%-10s %-8s %12s %s\\n\", $1, $2, $7, $9}'")
    };
    // banks for challenges of the 3 types of difficulties

    private static Random random = new Random();

    public static Challenge getRandom(int difficulty) {
        Challenge[] section;
        switch (difficulty) {
            case 1:
                section = EASY;
                break;
            case 2:
                section = MEDIUM;
                break;
            case 3:
                section = HARD;
                break;
            default:
                throw new IllegalArgumentException("Difficulty must be 1 to 3");
        }

        if (difficulty == 1) {
            int[] easyChallengeIndex = new int[5];
            int randomNumber = random.nextInt(section.length);
            for (int i = 0; i < easyChallengeIndex.length; i++) {
                if (easyChallengeIndex[i] == randomNumber) {
                    randomNumber = random.nextInt(section.length);
                    i = -1; // Reset the loop to check for duplicates again
                } else {
                    easyChallengeIndex[randomNumber - 1] = randomNumber;
                    i = 5;
                }
            }
            return section[randomNumber];
        }

        if (difficulty == 2) {
            int[] mediumChallengeIndex = new int[5];
            int randomNumber = random.nextInt(section.length);
            for (int i = 0; i < mediumChallengeIndex.length; i++) {
                if (mediumChallengeIndex[i] == randomNumber) {
                    randomNumber = random.nextInt(section.length);
                    i = -1; // Reset the loop to check for duplicates again
                } else {
                    mediumChallengeIndex[randomNumber - 1] = randomNumber;
                    i = 5;
                }
            }
            return section[randomNumber];
        }

        if (difficulty == 3) {
            int[] hardChallengeIndex = new int[5];
            int randomNumber = random.nextInt(section.length);
            for (int i = 0; i < hardChallengeIndex.length; i++) {
                if (hardChallengeIndex[i] == randomNumber) {
                    randomNumber = random.nextInt(section.length);
                    i = -1; // Reset the loop to check for duplicates again
                } else {
                    hardChallengeIndex[randomNumber - 1] = randomNumber;
                    i = 5;
                }
            }
            return section[randomNumber];
        }
        return null; // This line should never be reached due to the earlier checks
    }
}
