package generics;

public class CalculatorInteger implements Calculator<Integer> {
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    public Integer divide(Integer a, Integer b) {
        return a / b;
    }

    public Integer modulo(Integer a, Integer b) {
        return a % b;
    }

    public Integer reset() {

        return 0;
    }

    public Integer squareRoot(Integer a) {
        return 0;
    }

    public Integer square(Integer a) {
        return a * a;
    }
}
