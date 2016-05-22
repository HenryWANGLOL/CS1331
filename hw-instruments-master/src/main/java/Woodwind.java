/**
*The Woodwind instrument which is a Instrument
*@version Java 8.0
*@author Yufeng Wang
*/
public class Woodwind extends Instrument {
    /**
    *Constructor of the class
    *@param price is the price of the instrument
    *@param serialnumber is the serialnumber of the instrument
    */
    public Woodwind(double price, String serialnumber) {
        super("Woodwind", serialnumber, price,
            "it is long and hard");

    }
    /**
    *@return the sound of the Woodwind instrument
    */
    public String play() {
        return "Woa Woa";
    }


}