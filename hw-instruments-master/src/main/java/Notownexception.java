/**
*the Exception class to check the Musician has
*owned the instrument
*@version Java 8.0
*@author Yufeng Wang
*/
public class Notownexception extends Exception {
    /**
    *Constructor of the exception class
    */
    public Notownexception() {
        System.out.println("you don't have this instrument");
    }

}