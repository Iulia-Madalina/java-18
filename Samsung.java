import java.util.*;
import java.util.stream.Collectors;

public abstract class Samsung implements Phone {
    public static int batteryLife = 10;

    List<Contact> contactList = new ArrayList<>();
    List<String> callsHistory = new ArrayList<>();
    Map<String, String> messagesReceived = new HashMap<>();


    public Samsung() {
        super();
    }

    @Override
    public void addContact(Contact c) {

        if (batteryLife != 0) {
            contactList.add(new Contact(c.getPhoneNumber(), c.getFirstName(), c.getLastName()));
        } else {
            System.out.println("Out of battery life!");
        }
    }

    @Override
    public void listContacts() {
        if (batteryLife != 0) {
            contactList.forEach(System.out::println);
        } else {
            System.out.println("Out of battery life!");
        }
    }

    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        if (batteryLife != 0) {
            if (messageContent.length() > 100) {
                System.out.println("Maximum number of characters reached");
            } else {
                batteryLife--;
                System.out.println("The message( " + messageContent + " )was sent to phone number: " + phoneNumber);
                messagesReceived.put(messageContent, phoneNumber);

            }
        } else {
            System.out.println("Out of battery life!");
        }
    }


    @Override
    public void listMessages(String phoneNumber) {
        if (batteryLife != 0) {

            Map<String, String> result = messagesReceived.entrySet()
                    .stream()
                    .filter(map -> map.getValue().equals(phoneNumber))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            System.out.println("The messages from " + phoneNumber + " are: ");
            System.out.println(result);

        } else {
            System.out.println("Out of battery life!");
        }
    }

    @Override
    public void call(String phoneNumber) {
        if (batteryLife != 0) {
            if (phoneNumber.length() != 10 && !phoneNumber.equals("112")) {
                System.out.println("Please enter a valid number!");
            } else {
                System.out.println("Calling: " + phoneNumber);
                batteryLife = batteryLife - 2;
                callsHistory.add(phoneNumber);
            }
        } else {
            System.out.println("Out of battery life!");
        }

    }

    @Override
    public void viewHistory() {
        if (batteryLife != 0) {
            System.out.println("The call history is: ");
            callsHistory.forEach(System.out::println);

        } else {
            System.out.println("Out of battery life!");
        }
    }
}
