import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

public class Draw extends Application {
  private LocalDots localdots;
  private Text winner;
  private HBox hbox;
  
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Map");
    Filereader a = new Filereader();
    List<District> b = a.getAll();
    District biggest = new CompositeDistrict("US");
    for (District c : b) {
      biggest.addDistrict(c);
    }
    this.localdots = new LocalDots(biggest);
    winner = new Text(biggest.getWinner());
    localdots = new LocalDots(biggest);
    hbox = localdots.getHbox();
    Scene scene = new Scene(hbox);
    primaryStage.setScene(scene);
    System.out.println(winner);
    primaryStage.show();

  }
  
  public static void main(String[] args){
    launch(args);
  }
  
  
  
  
}