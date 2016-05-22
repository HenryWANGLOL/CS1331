/**
*The percussion instrument which is a Instrument
*@version Java 8.0
*@author Yufeng Wang
*/
public class Percussion extends Instrument {
    /**
    *Constructor of the Percussion
    *@param price is the price of the instrument
    *@param serialnumber is the serialnumber of the instrument
    */
    public Percussion(double price, String serialnumber) {
        super("Percussion", serialnumber, price,
            "it vibrates between surface and stick");

    }
    /**
    *@return the sound of the Percussion instrument
    */
    public String play() {
        return "Pen pen pen";
    }


}