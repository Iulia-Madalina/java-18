package generics;

public class CalculatorMain {
    public static void main(String[] args) {


        calculatorImplementationInteger();

        calculatorImplementationDouble();

    }

    public static void calculatorImplementationInteger() {
        CalculatorInteger calculatorInteger = new CalculatorInteger();

        System.out.println("Sum of integer numbers: " + calculatorInteger.add(8, 2));
        System.out.println("Reduction of integer numbers: " + calculatorInteger.subtract(8, 2));
        System.out.println("Division of integer numbers: " + calculatorInteger.divide(8, 2));
        System.out.println("Multiplication of integer numbers: " + calculatorInteger.multiply(8, 2));
        System.out.println("Rest of integer numbers: " + calculatorInteger.modulo(8, 2));
        System.out.println("Square of integer numbers: " + calculatorInteger.square(2));
        System.out.println("Square Root of integer numbers: " + calculatorInteger.squareRoot(4));
        System.out.println("Reset button: " + calculatorInteger.reset());
    }

    public static void calculatorImplementationDouble() {
        CalculatorDouble calculatorDouble = new CalculatorDouble();

        System.out.println("Sum of integer numbers: " + calculatorDouble.add(8.5, 2.4));
        System.out.println("Reduction of integer numbers: " + calculatorDouble.subtract(8.2, 2.5));
        System.out.println("Division of integer numbers: " + calculatorDouble.divide(8.1, 2.7));
        System.out.println("Multiplication of integer numbers: " + calculatorDouble.multiply(8.1, 2.5));
        System.out.println("Rest of integer numbers: " + calculatorDouble.modulo(8.0, 3.0));
        System.out.println("Square of integer numbers: " + calculatorDouble.square(2.0));
        System.out.println("Square Root of integer numbers: " + calculatorDouble.squareRoot(16.0));
        System.out.println("Reset button: " + calculatorDouble.reset());
    }
}
