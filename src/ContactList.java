import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ContactList {

    public ContactList() {
    }


    public static String viewContacts(){
        Path contactsFilePath = Paths.get("src/contacts.txt");
        try {
            List<String> contactsList = Files.readAllLines(contactsFilePath);
            for (int i = 0; i < contactsList.size(); i += 1) {
                System.out.println((i + 1) + ": " + contactsList.get(i));
            }

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return "";
    }

    public static List<String> addContact(Contact contact) {
        List<String> formattedContact = Arrays.asList(contact.getName() + " | " + contact.getPhoneNumber());
        Path contactsFilePath = Paths.get("src/contacts.txt");
        try {
            Files.write(contactsFilePath, formattedContact, StandardOpenOption.APPEND);
            return formattedContact;
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return formattedContact;

    }

    public static List<String> addContact(String name, String number) {
        Contact contact = new Contact(name, number);
        List<String> formattedContact = Arrays.asList(contact.getName() + " | " + contact.getPhoneNumber());
        Path contactsFilePath = Paths.get("src/contacts.txt");
        try {
            Files.write(contactsFilePath, formattedContact, StandardOpenOption.APPEND);
            return formattedContact;
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return formattedContact;
    }


    public static String searchContacts(String name) {
        Path contactsFilePath = Paths.get("src/contacts.txt");
        try {
            List<String> contactsList = Files.readAllLines(contactsFilePath);
            for (String contact : contactsList) {
                if (contact.contains(name)) {
                    System.out.println(contact);
                    return contact;
                } else {
                    System.out.println("No matches found");
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return "";
    }


}
