import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * The Container for localdistrict
 * @author Yufeng Wang
 * @version 1.0
 */
public class LocalDistrict implements District {
    private List<Voter> voters;
    private String localWinner;
    private int winnerScore;
    private Map<String, Integer> candidates;
    private int totalsize;
    private String districtname;
    /**
    * the constructor for the class
    * @param voters the voters arraylist
    * @param districtname the name of this local district
    */
    public LocalDistrict(List<Voter> voters, String districtname) {
        this.voters = voters;
        this.districtname = districtname;
        candidates = new HashMap<String, Integer>();
        addCandidates();
        this.localWinner = getWinner();
    }

    /**
    * @return the voters contained in this local district
    */
    public List<Voter> getVoter() {
        return voters;
    }
    /**
    * @return the name of this local district
    */
    public String getDistrictName() {
        return districtname;
    }

    /**
    * just for fun :D
    * @param d add district to localdistrct which is useless
    */
    public void addDistrict(District d) {
    }
    /**
    * just for fun :D
    * @return nothing
    */
    public List<District> getSubDistrict() {
        return null;
    }
    /**
    * add candidates to this local district
    */
    public void addCandidates() {
        Iterator<Voter> voterite = voters.iterator();
        while (voterite.hasNext()) {
            Voter voter = voterite.next();
            String firstname = voter.getFirstvote();
            String secondname = voter.getSecondvote();
            String thirdname = voter.getThirdvote();
            if (candidates.containsKey(firstname)) {
                int oriint = candidates.get(firstname);
                candidates.put(firstname, oriint + 3);
            } else {
                candidates.put(firstname, 3);
            }
            if (candidates.containsKey(secondname)) {
                int oriint = candidates.get(secondname);
                candidates.put(secondname, oriint + 2);
            } else {
                candidates.put(secondname, 2);
            }
            if (candidates.containsKey(thirdname)) {
                int oriint = candidates.get(thirdname);
                candidates.put(thirdname, oriint + 1);
            } else {
                candidates.put(thirdname, 1);
            }
        }
    }
    /**
    * @return the size of this localdistrict
    */
    public int getSize() {
        return voters.size();
    }
    /**
    * get the winner of this local district
    * @return the winner name of this localdistrict
    */
    public String getWinner() {
        Set<Entry<String, Integer>> entries = candidates.entrySet();
        MapComparator comp = new MapComparator();
        MergeSort<Entry<String, Integer>> sorter = new MergeSort<>();
        ArrayList<Entry<String, Integer>> lst =
            new ArrayList<Entry<String, Integer>>(entries.size());
        lst.addAll(entries);
        sorter.sort(lst, comp);
        return lst.get(entries.size() - 1).getKey();
    }
    /**
    * get the winner score of this local district
    * @return the winner score
    */
    public int getScore() {
        Set<Entry<String, Integer>> entries = candidates.entrySet();
        MapComparator comp = new MapComparator();
        MergeSort<Entry<String, Integer>> sorter = new MergeSort<>();
        ArrayList<Entry<String, Integer>> lst =
            new ArrayList<Entry<String, Integer>>(entries.size());
        lst.addAll(entries);
        sorter.sort(lst, comp);
        return lst.get(entries.size() - 1).getValue();
    }
}