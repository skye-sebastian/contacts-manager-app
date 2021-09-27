import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactList {

    public ContactList() {
        Path contactsFilePath = Paths.get("src/contacts.txt");
        try {
            List<String> contactLines = Files.readAllLines(contactsFilePath);
            List<Contact> contactList = new ArrayList<Contact>(0);

//            Source: https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object

            for (String line : contactLines) {
                Contact contact = new Contact();
                String[] tokens = line.split("\\|");

                contact.setName(tokens[0]);
                contact.setPhoneNumber(tokens[1]);

                contactList.add(contact);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
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


    public static void searchContacts(String name) {
        Path contactsFilePath = Paths.get("src/contacts.txt");
        try {
            List<String> contactsList = Files.readAllLines(contactsFilePath);
            for (String contact : contactsList) {
                if (contact.contains(name)) {
                    System.out.println(contact);
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

//    public static void deleteContact(String name) {
//        Path contactsFilePath = Paths.get("src/contacts.txt");
////        if (searchContacts(name)) {
//        try {
//            List<String> contactsList = Files.readAllLines(contactsFilePath);
//            for (String contact : contactsList) {
//                if (contact.contains(name)) {
//                    System.out.println("Deleting " + name + "\n");
//                    contactsList.remove(contact);
//                    break;
//                } else {
//                    System.out.println("No matches found");
//                }
//            }
//        } catch (IOException | ConcurrentModificationException exc){
//            exc.printStackTrace();
//        }
//
//    }

}
