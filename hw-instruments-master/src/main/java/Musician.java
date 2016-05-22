import java.util.ArrayList;
/**
*The Musician class
*@version Java 8.0
*@author Yufeng Wang
*/

public class Musician {
    private ArrayList<Instrument> instruments;
    private String musicianname;
    private double fund;
    /**
    *Constructor of the class
    *@param instruments is  the instrument
    *@param musicianname is the name of the musician
    *@param fund is the fund that the musician has
    */
    public Musician(ArrayList<Instrument> instruments,
        String musicianname, double fund) {
        this.instruments = instruments;
        this.fund = fund;
        this.musicianname = musicianname;
    }
    /**
    *purchase condition
    *@param a is the instrument that musician wants to buy
    *@throws ContainException checks whether the instrument is already owned
    *@throws NoenoughfundException checks fund enough or not
    */
    public void purchase(Instrument a) throws
        ContainException, NoenoughfundException {
        double price = a.getprice();
        String newinsname = a.getname();

        boolean containins = false;

        for (Instrument b: instruments) {
            if (newinsname.equals(b.getname())) {
                containins = true;
            }
        }

        if (containins) {
            throw new ContainException(a);
        }
        if (fund >= price) {
            fund = fund - price;
            instruments.add(a);
        } else {
            throw new NoenoughfundException(price);
        }

    }

    /**
    *sell condition
    *@param instrument is the instrument that musician wants to buy
    *@throws Lastexception checks whether the instrument is the last one
    *@throws Notownexception checks the onwership of the instrument
    */
    public void sell(Instrument instrument) throws
        Lastexception, Notownexception {
        if (instruments.size() <= 1) {
            throw new Lastexception();
        }
        boolean containins = false;
        for (Instrument b: instruments) {
            if (instrument.equals(b)) {
                containins = true;
            }
        }
        if (!containins) {
            throw new Notownexception();
        }
        instruments.remove(instrument);
        double price = instrument.getprice();
        fund = fund + price;
    }
    /**
    *@return the fund that musician has
    */
    public double getfund() {
        return fund;
    }
    /**
    *get the instrument's name
    */
    public void getinstrument() {
        for (Instrument a : instruments) {
            System.out.println(a.getname());
        }
    }
}