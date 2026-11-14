import java.util.Random;

public class ChallengeBank {
    public static final Challenge[] EASY = {
        new Challenge("")
    
    };

    public static final Challenge[] MEDIUM = {
        new Challenge("")

    };

    public static final Challenge[] HARD = {
        new Challenge("");

    };

    // banks for challenges of the 3 types of difficulties

    Random random = new Random();

    public static Challenge getRandom(int difficulty) {
        Challenge[] section;
        switch (difficulty) {
            case 1: section = EASY; break;
            case 2: section = EASY; break;
            case 3: section = EASY; break;
            default: throw new IllegalArgumentException("Difficulty must be 1 to 3");
        }
        
        return section[random.nextInt(section.length)];
    }
}
