/**
*The Violin instrument which is a stringed
*@version Java 8.0
*@author Yufeng Wang
*/
public class Violin extends Stringed {

    /**
    *Constructor of the Flute class
    *@param serialnumber is the serialnumber of the violin
    */
    public Violin(String serialnumber) {
        super(100.0, serialnumber);
    }
    /**
    *@return name of the violin
    **/
    public String getname() {
        return "Violin";
    }
    /**
    *@return the classification of violin, the serialnumber, the property
    *and play the instrument
    **/
    public String toString() {
        return "-Violin" + " is a Stringed " + "\n    Serial Number: "
            + getserialnumber() + "\n    Special Proper ty: "
            + getsproperty() + "\n    It sounds like: " + play();
    }
}