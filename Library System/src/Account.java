import java.util.ArrayList;
import java.util.Scanner;

public class Account extends BookShelf implements Runnable {

    int UserID;

    String password;


    String Favouritebook;

    Book borrowedbook;

    ArrayList<Book> history = new ArrayList<Book>();

    public Account(int userID, String password) {
        UserID = userID;
        this.password = password;

    }

    public String getFavouritebook() {
        return Favouritebook;
    }

    public void setFavouritebook(String favouritebook) {
        Favouritebook = favouritebook;
    }




    @Override
    public void run() {


            System.out.println("Start your journey");


    }
}