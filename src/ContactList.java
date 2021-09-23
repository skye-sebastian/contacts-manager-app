import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContactList {

    public ContactList() {
    }


    public static String readFromContactsList(){
        Path contactsFile = Paths.get("src/contacts.txt");

        try {
            List<String> contactsList = Files.readAllLines(contactsFile);
            for (int i = 0; i < contactsList.size(); i += 1) {
                System.out.println((i + 1) + ": " + contactsList.get(i));
            }

        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        return "";
    }




}
