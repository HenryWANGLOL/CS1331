/**
*The Flute instrument which is a woodwind
*@version Java 8.0
*@author Yufeng Wang
*/
public class Flute extends Woodwind {

    /**
    *Constructor of the Flute class
    *@param serialnumber is the serialnumber of the flute
    */
    public Flute(String serialnumber) {
        super(50.0, serialnumber);
    }
    /**
    *@return name of the flute
    **/
    public String getname() {
        return "Flute";
    }
    /**
    *@return the classification of flute, the serialnumber, the property
    *and play the instrument
    **/
    public String toString() {
        return "-Flute" + " is a Woodwind" + "\n     Serial Number: "
            + getserialnumber() + "\n     Special Property: "
            + getsproperty() + "\n     It sounds like: " + play();
    }
}