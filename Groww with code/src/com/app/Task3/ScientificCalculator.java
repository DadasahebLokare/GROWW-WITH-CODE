package com.app.Task3;

import java.util.Scanner;

public class ScientificCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scientific Calculator");
        System.out.println("Operations:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Power");
        System.out.println("6. Square Root");
        System.out.println("7. Logarithm");
        System.out.println("Enter 'q' to quit");

        while (true) {
            System.out.print("Select an operation (1-7): ");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("q")) {
                break;
            }

            double result = 0;
            switch (operation) {
                case "1":
                    result = performOperation(scanner, "Addition", (a, b) -> a + b);
                    break;
                case "2":
                    result = performOperation(scanner, "Subtraction", (a, b) -> a - b);
                    break;
                case "3":
                    result = performOperation(scanner, "Multiplication", (a, b) -> a * b);
                    break;
                case "4":
                    result = performOperation(scanner, "Division", (a, b) -> a / b);
                    break;
                case "5":
                    result = performOperation(scanner, "Power", (a, b) -> Math.pow(a, b));
                    break;
                case "6":
                    result = performOperation(scanner, "Square Root", (a, b) -> Math.sqrt(a));
                    break;
                case "7":
                    result = performOperation(scanner, "Logarithm", (a, b) -> Math.log(a));
                    break;
                default:
                    System.out.println("Invalid operation. Try again.");
                    break;
            }

            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    public static double performOperation(Scanner scanner, String operationName, MathOperation operation) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        if (!operationName.equalsIgnoreCase("Square Root") && !operationName.equalsIgnoreCase("Logarithm")) {
            System.out.print("Enter the second number: ");
        }
        double num2 = operationName.equalsIgnoreCase("Square Root") || operationName.equalsIgnoreCase("Logarithm") ? 0 : scanner.nextDouble();
        return operation.calculate(num1, num2);
    }

    @FunctionalInterface
    interface MathOperation {
        double calculate(double a, double b);
    }
}
