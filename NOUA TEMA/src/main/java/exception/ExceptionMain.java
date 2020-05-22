package exception;


public class ExceptionMain {

    public static void main(String[] args) {

        try {
            TestException.check(-1);
        } catch (Exception m) {
            System.out.println("Exception occured: " + m);
        }

        try {
            TestException.check(4);
        } catch (CheckedException e) {
            e.printStackTrace();
        }

    }
}
