

import java.io.File;
import java.net.URL;
import java.util.Scanner;
import  javax.media.*;


public class MediaPlayer {

    Player ap = null;

    String ap1;
    String ap2;

    public MediaPlayer() {

        ap1 = ("C:\\Users\\salma\\Downloads\\sample-file-4.wav");
        ap2 = ("C:\\Users\\salma\\Downloads\\sample-file-4.wav");

    }

    private void initMediaPlayer(String path) {
        try {
            URL url = new File(path).toURL();
            ap = (Player) Manager.createRealizedPlayer(url);

        } catch (Exception e) {
            System.out.println("Unable to play the Song Right NOW");

        }

    }


    public void selectasong() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a song : Song1  or Song2");


        String songname = scanner.nextLine();

        switch (songname) {

            case "Song1":
                initMediaPlayer(ap1);

                break;

            case "Song2":
                initMediaPlayer(ap2);
                break;
            default:
                System.out.println("Song unavailable");


        }
    }


    public void mediaselect()  {

        System.out.println("Select : play - pause - stop");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String option = scanner.nextLine();

            switch (option) {

                case "play":

                    ap.start();
                    break;


                case "pause":
                    ap.stop();
                    ap.setMediaTime(new Time(0.0));
                    break;


                case "stop":
                    ap.stop();
                    break;

                default:
                    System.out.println("Not an option");


            }

        }


    }
}





