package exception;

public class TestException {

    public static void check(int grade) throws CheckedException {
        if (grade < 0)
            throw new CheckedException("Woah! You really failed the test!");
        else if (grade > 0 && grade < 5) {
            throw new UncheckedException("Sorry! You failed the test!");
        } else
            System.out.println("Congrats! You passed the test!");
    }


}
