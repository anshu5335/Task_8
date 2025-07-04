package com.quizapp;

import com.quizapp.Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        int score = 0;

        questions.add(new Question(
            "What is the entry point for a Java application?",
            Arrays.asList("start()", "init()", "main()", "run()"),
            2
        ));

        questions.add(new Question(
            "Which keyword is used to define a class in Java?",
            Arrays.asList("Cls", "class", "obj", "type"),
            1
        ));

        questions.add(new Question(
            "What does JVM stand for?",
            Arrays.asList("Java Virtual Machine", "Java Verification Module", "Joint Venture Model", "Java Visual Modeler"),
            0
        ));
        
        questions.add(new Question(
            "Which data type is used to store true/false values in Java?",
            Arrays.asList("int", "String", "boolean", "char"),
            2
        ));
        
        questions.add(new Question(
            "What is the superclass of all classes in Java?",
            Arrays.asList("Main", "System", "Object", "Class"),
            2
        ));

        System.out.println("--- Welcome to the Online Java Quiz! ---");
        System.out.println("Answer the following multiple-choice questions by entering the number of your choice.");

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            currentQuestion.displayQuestion();

            int userAnswer = -1;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Your answer (1-" + currentQuestion.getOptions().size() + "): ");
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    if (userAnswer >= 1 && userAnswer <= currentQuestion.getOptions().size()) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and " + currentQuestion.getOptions().size() + ".");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }
            scanner.nextLine();

            if (currentQuestion.isCorrect(userAnswer - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + currentQuestion.getCorrectAnswerText());
            }
            System.out.println("------------------------------------");
        }

        System.out.println("\n--- Quiz Finished! ---");
        System.out.println("You scored " + score + " out of " + questions.size() + " questions.");
        if (score == questions.size()) {
            System.out.println("Congratulations! Perfect score!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Well done!");
        } else {
            System.out.println("Keep practicing!");
        }

        scanner.close();
    }
}
