/**
*The Trumpet instrument which is a Brass
*@version Java 8.0
*@author Yufeng Wang
*/
public class Trumpet extends Brass {

    /**
    *Constructor of the Flute class
    *@param serialnumber is the serialnumber of the trumpet
    */
    public Trumpet(String serialnumber) {
        super(75.0, serialnumber);
    }
    /**
    *@return name of the trumpet
    **/
    public String getname() {
        return "Trumpet";
    }
    /**
    *@return the classification of trumpet, the serialnumber, the property
    *and play the instrument
    **/
    public String toString() {
        return "-Trumpet" + " is a Brass" + "\n     Serial Number: "
            + getserialnumber() + "\n     Special Property: "
            + getsproperty() + "\n     It sounds like: " + play();
    }
}