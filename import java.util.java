import java.util.Scanner;

public class GPACalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of modules: ");
        int n = input.nextInt();

        double totalGradePoints = 0;
        int totalCredits = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nModule " + i + " ");

            System.out.print("Module Name: ");
            input.nextLine();  // Clear buffer
            String ModuleName = input.nextLine();

            System.out.print("Credit : ");
            int credit = input.nextInt();

            System.out.print("Grade (A-F): ");
            char grade = input.next().toUpperCase().charAt(0);

            double gradePoint = switch (grade) {
                case 'A' -> 4.0;
                case 'B' -> 3.0;
                case 'C' -> 2.0;
                case 'D' -> 1.0;
                case 'F' -> 0.0;
                default -> {
                    System.out.println("Invalid grade!");
                    yield 0.0;
                }
            };

            totalGradePoints += gradePoint * credit;
            totalCredits += credit;
        }

        double gpa = totalGradePoints / totalCredits;

        System.out.println("\nGPA Report ");
        System.out.println("Total Credits : " + totalCredits);
        System.out.printf("GPA: %.2f\n", gpa);
    }
}
