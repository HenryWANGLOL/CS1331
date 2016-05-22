/**
 * The Container for Voters
 * @author Yufeng Wang
 * @version 1.0
 */
public class Voter {
    private String firstvote;
    private String secondvote;
    private String thirdvote;
    private String voterName;

    /**
    * the constructor for the Voter class
    * @param voterName voter's name
    * @param firstvote voter's first vote
    * @param secondvote voter's second vote
    * @param thirdvote voter's third vote
    */
    public Voter(String voterName, String firstvote,
        String secondvote, String thirdvote) {
        this.firstvote = firstvote;
        this.secondvote = secondvote;
        this.thirdvote = thirdvote;
        this.voterName = voterName;
    }

    /**
    * return the firstvote of the voter
    * @return get the firstvote
    */
    public String getFirstvote() {
        return firstvote;
    }
    /**
    * return the second of the voter
    * @return get the second vote
    */
    public String getSecondvote() {
        return secondvote;
    }
    /**
    * return the thirdvote of the voter
    * @return get the third vote
    */
    public String getThirdvote() {
        return thirdvote;
    }
    /**
    * return the voter's name
    * @return get the voter's name
    */
    public String getVoterName() {
        return voterName;
    }
}