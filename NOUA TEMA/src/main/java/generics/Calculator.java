package generics;

public interface Calculator<T extends Number> {

    T add(T a, T b);

    T subtract(T a, T b);

    T multiply(T a, T b);

    T divide(T a, T b);

    T modulo(T a, T b);

    T reset();

    T squareRoot(T a);

    T square(T a);
}
