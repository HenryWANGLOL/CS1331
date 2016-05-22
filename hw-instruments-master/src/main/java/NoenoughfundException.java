/**
*the Exception class to check the Musician has
*enough fund to buy the equipment
*@version Java 8.0
*@author Yufeng Wang
*/
public class NoenoughfundException extends Exception {
    private double fund;
    /**
    *Constructor of the exception class
    *@param fund is the money musician has
    */
    public NoenoughfundException(double fund) {
        this.fund = fund;
        System.out.println("you dont have enough fund");
    }
    /**
    *@return the money musician has
    */
    public double getfund() {
        return fund;
    }
}