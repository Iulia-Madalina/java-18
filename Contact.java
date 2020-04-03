public class Contact {

    private String phoneNumber;
    private String firstName;
    private String lastName;


    public Contact(String phoneNumber, String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", lastName='" + firstName + '\'' +
                ", firstName='" + lastName + '\'' +
                '}';
    }

}
