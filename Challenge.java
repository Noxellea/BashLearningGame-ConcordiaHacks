public class Challenge {
    private final String prompt;
    private final String answer;

    public Challenge(String prompt, String answer) {
        this.prompt = prompt;
        this.answer = answer; 
    }

    public String getPrompt() { return prompt; }
    public String getAnswer() { return answer; }
    public boolean checkAnswer(String input) {
        return normalize(input).equals(normalize(answer)); // Compares the normalized input with the normalized answer
    }
    private static String normalize(String s) {
        return s.trim().replaceAll("\\s+", " "); // Normalizes whitespace, double spaces, and leading/trailing spaces to a single space
    }
}