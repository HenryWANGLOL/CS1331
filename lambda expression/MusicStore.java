import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
public class MusicStore {
	private static int flutecount;
	private static int violincount;
	private static int snarecount;
	private static int trumpetcount; //count the number of different instruments
	private static String[] flutenostring;
	private static String[] snarenostring;
	private static String[] trumpetenostring;
	private static String[] violinnostring; 
	//different instruments with different serial number


	public static void main(String[] args) {
		String name = createname();
		double fund = createfund();
		String[] flutenostring = flutenostring();
		String[] snarenostring = snarenostring();
		String[] violinnostring = violinnostring();
		String[] trumpetenostring = trumpetnostring();
		//Flute flute = new Flute(50.0, flutenostring[flutecount]);
		//Violin violin = new Violin(22.0, violinnostring[violincount]);
		//Snare snare = new Snare(25.0, snarenostring[snarecount]); //initiate
		Flute flute = new Flute(generateserialnumber());
		Violin violin = new Violin(generateserialnumber());
		Snare snare = new Snare(generateserialnumber()); //initiate
		flutecount++;
		violincount++;
		snarecount++; //add one after adding each serial number;
		ArrayList<Instrument> instruments = new ArrayList<>(4);
		instruments.add(flute);
		instruments.add(violin);
		instruments.add(snare);
		boolean rightornot = checkhaswhat(); // check equipments
		if (rightornot) {
		    System.out.println(flute.toString());
			System.out.println(violin.toString());
			System.out.println(snare.toString());
		}
		Musician musician = new Musician(instruments, name, fund);
		boolean buyorsell2 = buyorsell();
		if (buyorsell2) {
			Instrument newinstrument = null;
			System.out.println("what Instrument do you want to buy?");
			System.out.println("[1] violin" + "\n" + "[2] trumpet" + "\n"+ "[3] snare"
				+"\n" + "[4] flute");
			System.out.println("type integers");
			Scanner scan = new Scanner(System.in);
			String value = scan.next();
			boolean trigger = true;
			while (trigger) {
				if (value.equals("1")) {
					newinstrument = new Violin(violinnostring[2]);
					instruments.add(newinstrument);
					violincount++;
					trigger = false;
				} else if (value.equals("2")) {
					newinstrument = new Trumpet(trumpetenostring[trumpetcount]);
					trumpetcount++;
					trigger = false;
				} else if (value.equals("3")) {
					newinstrument = new Snare(snarenostring[snarecount]);
					snarecount++;
				} else if (value. equals("4")) {
					newinstrument = new Flute(flutenostring[flutecount]);
					flutecount++;
				} else {
					System.out.println("pelase type properly");
				}
			} try {
				musician.purchase(newinstrument);
				instruments.add(newinstrument);
				System.out.println("you now have");
				for (Instrument c: instruments) {
					System.out.println(c.getname());
				}
				System.out.println("your money left is " + musician.getfund());
				} catch (ContainException e) {
				System.out.println("ContainException occured");
				} catch (NoenoughfundException e) {
				System.out.println("NoenoughfundException occurred");
			} 
		} else { // if want to sell the equipment
			Instrument newinstrument = null;
			System.out.println("what Instrument do you want to sell?");
			System.out.println("[1] violin" + "\n" + "[2] trumpet" + "\n"+ "[3] snare"
				+"\n" + "[4] flute");
			System.out.println("type integers");
			Scanner scan = new Scanner(System.in);
			String value = scan.next();
			boolean trigger2 = true;
			while (trigger2) {
				if (value.equals("1")) {
					newinstrument = new Violin(violinnostring[violincount]);
					trigger2 = false;
				} else if (value.equals("2")) {
					newinstrument = new Trumpet(trumpetenostring[trumpetcount]);
					trigger2 = false;
				} else if (value.equals("3")) {
					newinstrument = new Snare(snarenostring[snarecount]);
					trigger2 = false;
				} else if (value. equals("4")) {
					newinstrument = new Flute(flutenostring[flutecount]);
					trigger2 = false;
				} else {
					System.out.println("pelase type properly");
				}
			} try { 
				musician.sell(newinstrument);
				instruments.remove(newinstrument);
				for (Instrument c: instruments) {
					System.out.println(c.getname());
				}
				System.out.println("your money left is " + musician.getfund());
			} catch (Lastexception e) {
				System.out.println("Lastexception occured");
			} catch (Notownexception e) {
				System.out.println("Notownexception occured");
			}

			}

				
		}

	public static String generateserialnumber() {
		return UUID.randomUUID().toString();
	}




//	public static Instrument buynew() {//buy new equipment

//		return newinstrument;

//	}

	public static boolean buyorsell() {
		System.out.println("Do you want to buy or sell equipments you have?" 
			+ " Buy/Sell");
		boolean rightornot = false;
		Scanner scan = new Scanner(System.in);
		String value = scan.next();
		boolean trigger = true;
		while (trigger) {
		if (value.equals("Buy")) {
			rightornot = true;
			trigger = false;
		} else if (value.equals("Sell")) {
			trigger = false;
			rightornot = false;
		} else {
			System.out.println("retype");
			value = scan.next();
		}
		}
		return rightornot;
	}

	// check whether the user wants to check his equipments
	public static boolean checkhaswhat() {
		System.out.println("Do you want to see the equipments you have? Y/N");
		boolean rightornot = false;
		Scanner scan = new Scanner(System.in);
		String value = scan.next();
		boolean trigger = true;
		while (trigger) {
		if (value.equals("Y")) {
			rightornot = true;
			trigger = false;
		} else if (value.equals("N")) {
			trigger = false;
			rightornot = false;
		} else {
			System.out.println("retype");
			value = scan.next();
		}
		}
		return rightornot;
	}
	/**
	*create different serialnumbers for different flutes
	*Assuming there are 100 flutes
	**/

	public static String[] flutenostring() { 
		String[] flutenumber = new String[100];
		for (int i = 0; i < 100; i ++) {
			if (i < 10) {
				flutenumber[i] = "#1" + "00" + i; 
			} else {
				flutenumber[i] = "#10" + i;
			}

		}
		return flutenumber;
	}
		/**
	*create different serialnumbers for different snares
	**/

	public static String[] snarenostring() { 
		String[] snarenumber = new String[100];
		for (int i = 0; i < 100; i ++) {
			if (i < 10) {
				snarenumber[i] = "#2" + "00" + i; 
			} else {
				snarenumber[i] = "#10" + i;
			}

		}
		return snarenumber;
	}

	/**
	*create different serialnumbers for different trumpet
	**/

	public static String[] trumpetnostring() { 
		String[] trumpetnumber = new String[100];
		for (int i = 0; i < 100; i ++) {
			if (i < 10) {
				trumpetnumber[i] = "#3" + "00" + i; 
			} else {
				trumpetnumber[i] = "#10" + i;
			}

		}
		return trumpetnumber;
	}

	/**
	*create different serialnumbers for different viloin
	*Assuming there are 100 flutes
	**/

	public static String[] violinnostring() { 
		String[] violinnumber = new String[100];
		for (int i = 0; i < 100; i ++) {
			if (i < 10) {
				violinnumber[i] = "#4" + "00" + i; 
			} else {
				violinnumber[i] = "#10" + i;
			}

		}
		return violinnumber;
	}
	/** 
	*create the name of the musician (interface)
	**/
	public static String createname() {
		System.out.println("You are now a musician, what is your name?");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		return name;
	}
	/** 
	*create the fund of the musician (interface)
	**/

	public static double createfund() {
		System.out.println("how much fund do you have");
		Scanner scan = new Scanner(System.in);
		double newfund = 0.0;
		try {double fund = scan.nextDouble();
			newfund = fund;
		} catch (Exception e) {
			System.out.println("please retype a fund in double");
			createfund();
		}
		return newfund;
	}
}