package logger;

public class User {

    private String username;

    private String password;

    private int grade;


    public User(String username, String password, int grade) {
        this.username = username;
        this.password = password;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                '}';
    }

    public int getGrade() {
        return grade;
    }

}
