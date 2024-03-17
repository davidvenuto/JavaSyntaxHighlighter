package sourceFiles;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String topic;
    private List<String> questions = new ArrayList<>();
    private int score;

    public Quiz(String topic) {
        this.topic = topic;
        this.score = 0;
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    public void takeQuiz() {
        System.out.println("Quiz on: " + topic);
        // Simulate taking the quiz
        questions.forEach(System.out::println);
    }

    public void updateScore(int score) {
        this.score += score;
    }

    public String getQuizResults() {
        return "Quiz Topic: " + topic + ", Score: " + score;
    }
}
