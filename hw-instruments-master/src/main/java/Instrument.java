/**
*The abstract class of all instrument
*@version Java 8.0
*@author Yufeng Wang
*/
public abstract class Instrument {

    private String serialnumber;
    private double price;
    private String name;
    private String property;
    /**
    *Constructor of the class
    *@param name is the  name of the instrument
    *@param serialnumber is the serialnumber of the instrument
    *@param price of the instrument
    *@param property is the property of the instrument
    */
    public Instrument(String name, String serialnumber,
        double price, String property) {
        this.serialnumber = serialnumber;
        this.price = price;
        this.name = name;
        this.property = property;
    }
    /**
    *@return the name of the instrument
    */
    public String getname() {
        return name;
    }
    /**
    *@return the price of the instrument
    */
    public double getprice() {
        return price;
    }
    /**
    *@return the serialnumber of the instrument
    */
    public String getserialnumber() {
        return serialnumber;
    }
    /**
    *@return play the instrument
    */
    public abstract String play();
    /**
    *@return the property of the instrument
    */
    public String getsproperty() {
        return property;
    }

}