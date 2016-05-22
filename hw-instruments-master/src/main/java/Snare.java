/**
*The Snare instrument which is a Percussion
*@version Java 8.0
*@author Yufeng Wang
*/
public class Snare extends Percussion {
    /**
    *Constructor of the Flute class
    *@param serialnumber is the serialnumber of the snare
    */
    public Snare(String serialnumber) {
        super(22.0, serialnumber);
    }

    /**
    *@return name of the snare
    **/
    public String getname() {
        return "Snare";
    }
    /**
    *@return the classification of snare, the serialnumber, the property
    *and play the instrument
    **/
    public String toString() {
        return "-Snare" + " is a Percussion" + "\n    Serial Number: "
            + getserialnumber() + "\n    Special Property: "
            + getsproperty() + "\n    It sounds like: " + play();
    }
}