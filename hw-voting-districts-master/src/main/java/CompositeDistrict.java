import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 * The composite district which may contain the same kind
 * @author Yufeng Wang
 * @version 1.0
 */
public class CompositeDistrict implements District {
    private List<District> district;
    private String districtWinner;
    private int winnerScore;
    private int districtSize;
    private String compodistrictname;
    /**
    * the first constructor which includes the name and subdistrict
    * @param district the subdistricts contained in this district
    * @param compodistrictname the name for that district
    */
    public CompositeDistrict(List<District> district,
        String compodistrictname) {
        this.district = district;
        this.compodistrictname = compodistrictname;
    }
    /**
    * the second constructor which only includes the name
    * @param compodistrictname the name for that district
    */
    public CompositeDistrict(String compodistrictname) {
        this.district = new ArrayList<District>(0);
        this.compodistrictname = compodistrictname;
    }
    /**
    * get the district name
    * @return the districtname
    */
    public String getDistrictName() {
        return compodistrictname;
    }

    /**
    * add district to the class
    * @param d the additional district being added
    */
    public void addDistrict(District d) {
        district.add(d);
    }
    /**
    * get the subdistrict contained in the district
    * @return the subdistrict contained in the district
    */
    public List<District> getSubDistrict() {
        return district;
    }

    /**
    * get the size of the district
    * @return the size of the district
    */
    public int getSize() {
        int size = 0;
        for (District d :district) {
            size = size + d.getSize();
        }
        return size;
    }
    /**
    * get the district winner
    * @return the winner
    */
    public String getWinner() {
        Iterator<District> iter = district.iterator();
        int maxsize = 0;
        String winner = "";
        while (iter.hasNext()) {
            District a = iter.next();
            int localwinnerscore = a.getSize();
            String localwinner = a.getWinner();
            if (localwinnerscore > maxsize) {
                winner = localwinner;
                maxsize = localwinnerscore;
            }
        }
        return winner;
    }
}