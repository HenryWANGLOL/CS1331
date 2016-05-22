import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import java.util.List;
import java.util.ArrayList;

public class LocalDots{
  private VBox dotline;
  private HBox dots;
  private String color;
  private Text nameofDistrict;
  private District district;
  private Circle circle;
  private int numOfCircles;
  
  public LocalDots(District district) {
    this.dotline = new VBox(10);
    this.district = district;
    circle = new Circle(1, Color.BLACK);
    numOfCircles = district.getSize();
    this.dotline.setPrefWidth(numOfCircles*10);
    nameofDistrict = new Text(district.getDistrictName());
  }
  
  public LocalDots addnewDots(LocalDots oldlocaldots) {
    District district = oldlocaldots.getDistrict();
    LocalDots templocaldots = new LocalDots(district);
    List<District> districtlist = district.getSubDistrict();
    if ((districtlist.isEmpty())) {
      int numOfCircles2 = oldlocaldots.getnumOfCircle();
      for (int i = 0; i< numOfCircles2; i++) {
            dots.getChildren().add(circle);
      }
      dotline.getChildren().addAll(nameofDistrict, dots);
    } else {
        for (District a : districtlist) {
          LocalDots templocal = new LocalDots(a);
          templocal.addnewDots(templocal);
        }
      }
      return 
  }
  
  public int getnumOfCircle() {
    return numOfCircles;
  }


  public District getDistrict() {
    return district;
  }

  public HBox getHbox () {
    return dots;
  }
}
