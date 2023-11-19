import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    Socket socket;
    String name;

    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public Client(Socket socket, String name) throws IOException {
        this.socket = socket;
        this.name = name;
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }


    public void  msgtosend(){

        Scanner s = new Scanner(System.in);
        String massegetosend = s.nextLine();

        try {

            bufferedWriter.write(name + ": " +massegetosend);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            closeAll(socket, bufferedReader, bufferedWriter);
        }


    }

    public void msgtoread(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                String msgfromgroup;

                while(socket.isConnected()){
                    try {
                        msgfromgroup = bufferedReader.readLine();
                        System.out.println(msgfromgroup);

                    } catch (IOException e) {
                        closeAll(socket, bufferedReader, bufferedWriter);

                    }


                }




                }
        });

    }

    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if(bufferedReader!= null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        Socket socket = new Socket("localhost", 1234);
        Client client = new Client(socket, name);
        client.msgtosend();
        client.msgtoread();


    }
}


