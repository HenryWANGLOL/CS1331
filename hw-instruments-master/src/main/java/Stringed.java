/**
*The Stringed instrument which is an instrument
*@version Java 8.0
*@author Yufeng Wang
*/
public class Stringed extends Instrument {
    /**
    *Constructor of the class
    *@param price is the price of the instrument
    *@param serialnumber is the serialnumber of the instrument
    */
    public Stringed(double price, String serialnumber) {
        super("Stringed", serialnumber, price,
            "it cuts finger when you played");
    }
    /**
    *@return the sound of the Stringed instrument
    */
    public String play() {
        return "Tseeeeee Tseeeee";
    }


}