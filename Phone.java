public interface Phone {

    void addContact(Contact c);

    void listContacts();

    void sendMessage(String phoneNumber, String messageContent);

    void listMessages(String phoneNumber);

    void call(String phoneNumber);

    void viewHistory();

}
