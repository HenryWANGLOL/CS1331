/**
*The Brass instrument
*@version Java 8.0
*@author Yufeng Wang
*/
public class Brass extends Instrument {
    /**
    *the Constructor of the Instrument class
    * @param price price is price
    * @param serialnumber serialnumber is serialnumber
    */
    public Brass(double price, String serialnumber) {
        super("Brass", serialnumber, price,
            "uses vibration of the player's lips");
    }

    /**
    *Play the Brass
    * @return return the play sound
    */
    public String play() {
        return "Woooooooo Wooooo";
    }


}