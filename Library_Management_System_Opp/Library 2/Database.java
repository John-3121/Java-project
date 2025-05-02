package library;

import java.util.ArrayList;
import java.io.File;

public class Database {

    private ArrayList<User> users = new ArrayList<User>(); // this helps us hold different data types
    private ArrayList<String> usernames = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> booknames = new ArrayList<String>();

    // Changed these two lines to manually point to Library/Data/Users and Books folders
    private File usersfiles = new File("Library/Data/Users");
    private File booksfile = new File("Library/Data/Books");

    public Database() {
        if (!usersfiles.exists()) {//if file not exist
            usersfiles.mkdirs(); //create dirrctory
        }

        if (!booksfile.exists()) {
            booksfile.mkdirs();
        } else {
            // optional else block
        }
    }

    public void Adduser(User s) {
        users.add(s);
        usernames.add(s.getName());
    }

    public int login(String phonenumber, String email) {
        int n = -1;
        for (User s : users) {
            if (s.getPhoneNumber().matches(phonenumber) && s.getmail().matches(email)) {
                n = users.indexOf(s);
                break;
            }
        }
        return n;
    }

    public User getUser(int n) {
        return users.get(n);
    }

    public void AddBook(Book book) {
        books.add(book);
        booknames.add(book.getName());
    }
}