import java.util.ArrayList;
import java.util.HashMap;


public class UserIdandPassword {

     int Id;
    String  passowrd;

    //Account useraccount;

    HashMap<Integer,String> logininfo = new HashMap<Integer,String>();



     public  UserIdandPassword(int id, String passowrd) {
        Id = id;
        this.passowrd = passowrd;
        /// Account useraccount = new Account(Id, passowrd);

        logininfo.put(Id,passowrd);

     }



    protected HashMap<Integer,String> getusersinfo(){

         return logininfo;
    }



}