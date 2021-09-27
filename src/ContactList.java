import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

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


    public static boolean searchContacts(String name) {
        Path contactsFilePath = Paths.get("src/contacts.txt");
        try {
            List<String> contactsList = Files.readAllLines(contactsFilePath);
            for (String contact : contactsList) {
                if (contact.contains(name)) {
                    System.out.println(contact);
                    return true;
                } else {
                    System.out.println("No matches found");
                    return false;
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return false;
    }

    public static void deleteContact(String name) {
        Path contactsFilePath = Paths.get("src/contacts.txt");
//        if (searchContacts(name)) {
        try {
            List<String> contactsList = Files.readAllLines(contactsFilePath);
            for (String contact : contactsList) {
                if (contact.contains(name)) {
                    System.out.println("Deleting " + name + "\n");
                    contactsList.remove(contact);
                    break;
                } else {
                    System.out.println("No matches found");
                }
            }
        } catch (IOException | ConcurrentModificationException exc){
            exc.printStackTrace();
        }

    }

}
