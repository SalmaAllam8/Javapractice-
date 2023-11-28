import java.util.ArrayList;
import java.util.HashMap;

public class Login   {


    int id;
    String password;

    ArrayList<UserIdandPassword>users = new ArrayList<UserIdandPassword>();
    HashMap<Integer,String> logininfo;

    public Login(HashMap<Integer,String>logininfos) {

        logininfo = logininfos;

    }

    public void signin(UserIdandPassword userIdandPassword){


        users.add(userIdandPassword);
    }



    public void loginuser(int id, String password){

        if(logininfo.containsKey(id)){
            if (logininfo.get(id).equals(password)){

                System.out.println("Logged in sucessufully");
                Account account = new Account(id, password);
                account.run();
             //for (UserIdandPassword user: users){
               //  if(logininfo.get(id).equals(user.passowrd)){

                    //

               //  }
            // }


            }else {
                System.out.println("Failed to login");
            }
        }




    }



}
