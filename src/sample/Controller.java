package sample;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    public TextField saaTab;

    Thread dateThread;
    DateFormat df = new SimpleDateFormat("hh:mm:ss");

    boolean isRunning = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dateThread = new Thread(this::handleThread);
        dateThread.start();
    }

    private void handleThread(){

        while (isRunning){
            String dateStr = ("current time: " + df.format(new Date()));

            Platform.runLater(()->{
                saaTab.setText(dateStr);
            } );

            try{
                Thread.sleep(1000);
            } catch (InterruptedException iex){
                iex.printStackTrace();
            }
        }
    }
}
