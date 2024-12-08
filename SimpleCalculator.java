import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean c = true;

        while (c) {
            System.out.println("Welcome to the Simple Calculator!");
            System.out.print("Enter first number: ");
            double num1 = getValidNumber(sc);

            System.out.print("Enter an operator (+, -, *, /): ");
            char operator = getValidOperator(sc);

            System.out.print("Enter second number: ");
            double num2 = getValidNumber(sc);

            double result = performCalculation(num1, num2, operator);
            System.out.println("Result: " + result);

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String response = sc.next();
            c = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for using the Simple Calculator!");
        sc.close();
    }

    private static double getValidNumber(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static char getValidOperator(Scanner sc) {
        char operator;
        while (true) {
            operator = sc.next().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                return operator;
            } else {
                System.out.print("Invalid operator. Please enter one of (+, -, *, /): ");
            }
        }
    }

    private static double performCalculation(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    return Double.NaN; 
                }
                return num1 / num2;
            default:
                return 0; 
        }
    }
}