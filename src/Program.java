import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
class Contact {
    String name;
    String company;
    String title;
    String mobile;
    String alternateMobile;
    String email;
    public Contact() {
        this.name = "";
        this.company = "";
        this.title = "";
        this.mobile = "";
        this.alternateMobile = "";
        this.email = "";
    }
    public Contact(String name, String company, String title, String mobile, String alternateMobile, String email) {
        this.name = name;
        this.company = company;
        this.title = title;
        this.mobile = mobile;
        this.alternateMobile = alternateMobile;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display() {
        System.out.println(
                name + "  " +
                        company + "  " +
                        title + "  " +
                        mobile + "  " +
                        alternateMobile + "  " +
                        email + "  ");
    }
}
class ContactBO {
    public ContactBO() {

    }

    public Contact[] FindContact(Contact[] contactlist, String[] name) {
        for(int i = 0; i < contactlist.length; i++) {
           for(int j = 0; j < name.length; j++) {
               if(name[j].equals(contactlist[i].name)) {
                   contactlist[i].display();
               }
           }
        }
        return contactlist;
    }
    public Contact[] FindDomain(Contact[] contactlist, String domain) {
        for(int i = 0; i < contactlist.length; i++) {
            if (contactlist[i].email.contains(domain) == true) {
                contactlist[i].display();
            }
        }
        return contactlist;
    }
}


public class Program {
    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");
        Scanner sc = new Scanner(file);
        //sc.useDelimiter("\\n");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = sc.nextInt();
        sc.nextLine();
        String str[] = new String[6];
        Contact[] contact = new Contact[n];
        for (int i = 0; i < n; i++) {
           str = sc.nextLine().split(",");
           contact[i].name = "John";
        }
        System.out.println("Enter a search type:");
        System.out.println("1.Name");
        System.out.println("2.Email Domain:");
        int num = sc.nextInt();
        switch (num) {
            case 1:
                String[] name = input.readLine().split(",");
                ContactBO c = null;
                c.FindContact(contact, name);
                break;
            case 2:
                ContactBO c1 = null;
                String domain = sc.next();
                c1.FindDomain(contact, domain);
                break;
            default:
                System.out.println("Invalid Choice.");
        }
    }
}