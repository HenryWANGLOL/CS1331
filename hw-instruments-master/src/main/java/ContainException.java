/**
*the Exception class to check whether the instrument has already
*being equiped by the musician
*@version Java 8.0
*@author Yufeng Wang
*/
public class ContainException extends Exception {
    private Instrument instrument;
    /**
    *Constructor of the exception class
    *@param instrument is the instrument created
    */
    public ContainException(Instrument instrument) {
        this.instrument = instrument;
        System.out.println("you already have one");
    }
}