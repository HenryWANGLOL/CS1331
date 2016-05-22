/**
*the Exception class to check whether the instrument has already
*being the last one that the musician has
*@version Java 8.0
*@author Yufeng Wang
*/
public class Lastexception extends Exception {
    /**
    *Constructor of the exception class
    */
    public Lastexception() {
        System.out.println("you cannot sell the last instrument");
    }

}