import java.util.List;
/**
 * The interface for composite district and local district
 * @author Yufeng Wang
 * @version 1.0
 */
public interface District {
    /**
    * get the size of the district
    * @return the size of the district
    */
    int getSize();

    /**
    * add district to the class
    * @param d the additional district being added
    */
    void addDistrict(District d);

    /**
    * get the district name
    * @return the districtname
    */
    String getDistrictName();

    /**
    * get the district winner
    * @return the winner
    */
    String getWinner();

    /**
    * get the subdistrict contained in the district
    * @return the subdistrict contained in the district
    */
    List<District> getSubDistrict();
}