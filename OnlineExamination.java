import java.util.*;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    void updateProfile(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
        System.out.println("Profile updated successfully!");
    }
}

class Question {
    String question;
    String[] options;
    int correctAnswer;

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}

class Exam {
    List<Question> questions = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    Exam() {
        // Adding sample questions
        questions.add(new Question("What is Java?", new String[]{"Programming Language", "OS", "Compiler", "None"}, 1));
        questions.add(new Question("Which keyword is used to inherit a class in Java?", new String[]{"super", "this", "extends", "implement"}, 3));
        questions.add(new Question("Which of these is not a Java feature?", new String[]{"Object-Oriented", "Platform Independent", "Pointers", "Robust"}, 3));
    }

    void startExam() {
        int score = 0;

        System.out.println("Your exam has started. You have 1 minute for the test (simulated).");
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60000; // 1 minute timer (simulation)

        for (Question q : questions) {
            if (System.currentTimeMillis() > endTime) {
                System.out.println("Time up! Auto-submitting...");
                break;
            }

            q.displayQuestion();
            System.out.print("Your answer: ");
            int ans = sc.nextInt();

            if (q.checkAnswer(ans)) {
                score++;
            }
        }

        System.out.println("Exam Over! Submitting...");
        System.out.println("Your Score: " + score + "/" + questions.size());
    }
}

class OnlineExamSystem {
    Scanner sc = new Scanner(System.in);
    User user;
    Exam exam = new Exam();

    OnlineExamSystem(User user) {
        this.user = user;
    }

    void menu() {
        while (true) {
            System.out.println("\n--- Online Examination System ---");
            System.out.println("1. Start Exam");
            System.out.println("2. Update Profile");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    exam.startExam();
                    break;
                case 2:
                    System.out.print("Enter new username: ");
                    String newUsername = sc.next();
                    System.out.print("Enter new password: ");
                    String newPassword = sc.next();
                    user.updateProfile(newUsername, newPassword);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("student", "1234");

        System.out.println("Welcome to Online Examination System");
        System.out.print("Enter username: ");
        String username = sc.next();
        System.out.print("Enter password: ");
        String password = sc.next();

        if (user.login(username, password)) {
            System.out.println("Login successful!");
            OnlineExamSystem system = new OnlineExamSystem(user);
            system.menu();
        } else {
            System.out.println("Invalid login credentials!");
        }
    }
}

