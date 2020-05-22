package generics;

import java.util.Map;

public class CalculatorDouble implements Calculator<Double> {
    public Double add(Double a, Double b) {
        return a+b;
    }

    public Double subtract(Double a, Double b) {
        return a-b;
    }

    public Double multiply(Double a, Double b) {
        return a*b;
    }

    public Double divide(Double a, Double b) {
        return a/b;
    }

    public Double modulo(Double a, Double b) {
        return a%b;
    }

    public Double reset() {
      //  a = 0;
        return 0.0;
    }

    public Double squareRoot(Double a) {
        return Math.sqrt(a);
    }

    public Double square(Double a){
        return a*a;
    }
}
