import java.util.ArrayList;
import java.util.UUID;
/**
*The Music store which sells the equipment
*@version Java 8.0
*@author Yufeng Wang
*/
public class MusicStore {
    /**
    *main method of the music store
    *@param args is the normal way
    */
    public static void main(String[] args) {
        caseone();
        casetwo();
        casethree();
        casefour(); // these are four exceptions being caught
        casefive();
        casesix(); //these two successfully bought and sold instrument
    }
    /**
    *@return generate the serial number
    */
    public static String generateserialnumber() {
        return UUID.randomUUID().toString();
    }

    /**
    *shows the details of instruments
    *@param instruments is the arraylist of the instruments musician has
    */
    public static void showinstrument(ArrayList<Instrument> instruments) {
        System.out.println("The musician has the following instruments:");
        for (Instrument a : instruments) {
            System.out.println("  " + a.toString());
        }
    }
    /**
    *only the name of the instrument
    *@param instruments is the arraylist of the instruments musician has
    */
    public static void showonlyname(ArrayList<Instrument> instruments) {
        int count = 1;
        for (Instrument a : instruments) {
            System.out.println("[" + count + "]  " + a.getname());
            count++;
        }
    }

    /**
    *case one is purchase condition
    *illustrates the condition that Musician has already had one instrument
    **/
    public static void caseone() {
        System.out.println("This is case one:" + "\n");
        Violin violin = new Violin(generateserialnumber());
        Snare snare = new Snare(generateserialnumber());
        Flute flute = new Flute(generateserialnumber()); //initiate
        ArrayList<Instrument> instruments = new ArrayList<>(3);
        //add to arraylist
        instruments.add(flute);
        instruments.add(violin);
        instruments.add(snare);
        showinstrument(instruments); //show all instruments he has
        Musician musician = new Musician(instruments, "lex", 300.0);
        // initate the musician with enough funds
        System.out.println("..............................");
        System.out.println("You have $300 and tried to sell a violin");
        System.out.println("..............................");
        try {
            Violin newviolin = new Violin(generateserialnumber());
            //Assume the musician buy a new violin twice
            musician.purchase(newviolin);
            musician.purchase(newviolin);
        } catch (ContainException e) {
            System.out.println("The ContainException occured");
        } catch (NoenoughfundException e) {
            System.out.println("the NoenoughfundException occured");
        } finally {
            System.out.println("-Your money left is " + musician.getfund());
            System.out.println("-You have the following instrument currently:");
            showonlyname(instruments);
        }
    }

    /**
    *case two is purchase condition
    *illustrates the condition that Musician has no enough money
    **/
    public static void casetwo() {
        System.out.println();
        System.out.println("This is case two");
        Violin violin = new Violin(generateserialnumber());
        Snare snare = new Snare(generateserialnumber());
        Flute flute = new Flute(generateserialnumber()); //initiate
        ArrayList<Instrument> instruments = new ArrayList<>(3);
        //add to arraylist
        instruments.add(flute);
        instruments.add(violin);
        instruments.add(snare);
        showinstrument(instruments); //show all instruments he has
        Musician musician = new Musician(instruments, "lex", 1.0);
        // initate the musician with no enough funds

        System.out.println("..............................");
        System.out.println("You have $1 and You tried to buy a trumpet");
        System.out.println("..............................");
        try {
            Trumpet newtrumpet = new Trumpet(generateserialnumber());
            //Assume the musician buy a new trumpet
            musician.purchase(newtrumpet);
        } catch (ContainException e) {
            System.out.println("The ContainException occured");
        } catch (NoenoughfundException e) {
            System.out.println("the NoenoughfundException occured");
        } finally {
            System.out.println("-Your money left is " + musician.getfund());
            System.out.println("-You have the following instrument currently:");
            showonlyname(instruments);
        }
    }

    /**
    *case three is selling condition
    *illustrates the condition that Musician does not have one he sells
    */

    public static void casethree() {
        System.out.println();
        System.out.println("This is case three");
        Violin violin = new Violin(generateserialnumber());
        Snare snare = new Snare(generateserialnumber());
        Flute flute = new Flute(generateserialnumber()); //initiate
        ArrayList<Instrument> instruments = new ArrayList<>(3);
        //add to arraylist
        instruments.add(flute);
        instruments.add(violin);
        instruments.add(snare);
        showinstrument(instruments); //show all instruments he has
        Musician musician = new Musician(instruments, "lex", 300.0);
        System.out.println("..............................");
        System.out.println("You have $300 and You tried to sell a trumpet");
        System.out.println("..............................");
        // initate the musician with enough funds
        try {
            Trumpet newtrumpet = new Trumpet(generateserialnumber());
            //Assume the musician sell a trumpet
            musician.sell(newtrumpet);
        } catch (Lastexception e) {
            System.out.println("The Lastexception occured");
        } catch (Notownexception e) {
            System.out.println("the Notownexception occured");
        } finally {
            System.out.println("Your money left is " + musician.getfund());
            System.out.println("You have the following instrument currently:");
            showonlyname(instruments);
        }
    }

    /**
    *case four is selling condition
    *illustrates the condition that Musician only has one instrument
    **/

    public static void casefour() {
        System.out.println();
        System.out.println("This is case four");
        Violin violin = new Violin(generateserialnumber());
        ArrayList<Instrument> instruments = new ArrayList<>(1);
        //add to arraylist
        instruments.add(violin);
        showinstrument(instruments); //show all instruments he has
        Musician musician = new Musician(instruments, "lex", 300.0);
        System.out.println("..............................");
        System.out.println("You have $300 and You tried to sell your violin");
        System.out.println("..............................");
        // initate the musician with enough funds
        try {
            musician.sell(violin);
        } catch (Lastexception e) {
            System.out.println("The Lastexception occured");
        } catch (Notownexception e) {
            System.out.println("the Notownexception occured");

        } finally {
            System.out.println("Your money left is " + musician.getfund());
            System.out.println("You have the following instrument currently:");
            showonlyname(instruments);
        }
    }

    /**
    *case five is purchase condition
    *illustrates the condition that Musician successfully bought.
    **/

    public static void casefive() {
        System.out.println();
        System.out.println("This is case five");
        Violin violin = new Violin(generateserialnumber());
        ArrayList<Instrument> instruments = new ArrayList<>(1);
        //add to arraylist
        instruments.add(violin);
        showinstrument(instruments); //show all instruments he has
        Musician musician = new Musician(instruments, "lex", 300.0);
        System.out.println("..............................");
        System.out.println("You have $300 and You tried to buy a new trumpet");
        System.out.println("..............................");
        // initate the musician with enough funds
        try {
            Trumpet newtrumpet = new Trumpet(generateserialnumber());
            //Assume the musician sell the violin
            musician.purchase(newtrumpet);
        } catch (ContainException e) {
            System.out.println("The ContainException occured");
        } catch (NoenoughfundException e) {
            System.out.println("the NoenoughfundException occured");
        } finally {
            System.out.println("Your money left is " + musician.getfund());
            System.out.println("You have the following instrument currently:");
            showonlyname(instruments);
        }
    }

    /**
    *case six is selling condition
    *illustrates the condition that Musician successfully sold.
    **/
    public static void casesix() {
        System.out.println();
        System.out.println("This is case six");
        Violin violin = new Violin(generateserialnumber());
        Snare snare = new Snare(generateserialnumber());
        ArrayList<Instrument> instruments = new ArrayList<>(1);
        //add to arraylist
        instruments.add(violin);
        instruments.add(snare);
        showinstrument(instruments); //show all instruments he has
        Musician musician = new Musician(instruments, "lex", 300.0);
        System.out.println("..............................");
        System.out.println("You have $300 and You tried to sell a snare");
        System.out.println("..............................");
        // initate the musician with enough funds
        try {
            //Assume the musician sell the violin
            musician.sell(snare);
        } catch (Lastexception e) {
            System.out.println("The Lastexception occured");
        } catch (Notownexception e) {
            System.out.println("the Notownexception occured");
        } finally {
            System.out.println("Your money left is " + musician.getfund());
            System.out.println("You have the following instrument currently:");
            showonlyname(instruments);
        }
    }
}