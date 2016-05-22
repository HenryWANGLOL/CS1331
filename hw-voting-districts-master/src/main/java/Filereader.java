import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Map.Entry;
/**
 * The test class for Merge sort and the final winner
 * @author Yufeng Wang
 * @version 1.0
 */
public class Filereader {
    /**
    * main caller of the class
    * @param args we all know about it right?
    */
  private List<District> allvisited;
     public Filereader() {
        Map<String, String> localdistrictmap = new HashMap<>(0);
        List<District> maindistrictlist = new ArrayList<>(0);
        List<LocalDistrict> localdistrictlist = new ArrayList<>(0);
        List<Voter> voterList = new ArrayList<>(0);
        List<District> visited = new ArrayList<>(0);
        allvisited = new ArrayList<>(0);
        //String filename = args[0]; //read voters.txt
        String filename = "voters.txt";
        voterList = readvoter(filename);
        //String filename2 = args[1]; //read local_district.txt
        String filename2 = "local_districts.txt";
        localdistrictlist = readLocalDistrict(filename2, voterList);
        localdistrictmap = putittomap(localdistrictlist);
        Set<Entry<String, String>> entries = localdistrictmap.entrySet();
        MapComparator2 comp = new MapComparator2();
        MergeSort<Entry<String, String>> sorter = new MergeSort<>();
        ArrayList<Entry<String, String>> lst =
            new ArrayList<Entry<String, String>>(entries.size());
        lst.addAll(entries);
        sorter.sort(lst, comp);
        for (Entry<String, String> a : lst) {
            System.out.println(a);
        }
        //String filename3 = args[2]; //read district.txt
        String filename3 = "districts.txt";
        visited = getDistrictWithOnlyL(filename3, localdistrictlist);
        allvisited = getAllvisited(filename3, localdistrictlist);
        for (District a : allvisited) {
            List<District> newdis = a.getSubDistrict();
            for (District disdis : newdis) {
                for (District local : localdistrictlist) {
                    if (local.getDistrictName().equals(
                        disdis.getDistrictName())) {
                        disdis = local;
                    }
                }
                for (District disdisdis : allvisited) {
                    if (disdis.getDistrictName().equals(
                        disdisdis.getDistrictName())) {
                        disdis = disdisdis;
                    }
                }
            }
        }
        String finalwinner = "";
        int size = 0;
        int sizefinal = 0;
        for (District b : allvisited) {
            for (District a : b.getSubDistrict()) {
                sizefinal = sizefinal + a.getSize();
            }
        }
        for (District a :allvisited) {
            int temsize = a.getSize();
            if (temsize > size) {
                finalwinner = a.getWinner();
                size = temsize;
            }
        }
        System.out.println();
        System.out.println("Sorted according to their names :D");
        System.out.println();
        System.out.println("Here is the Winner of the all District");
        System.out.println(finalwinner + " with the score of " + sizefinal);
    }
     
     public List<District> getAll() {
       return allvisited;
     }
    public static void main(String[] args) {
        Map<String, String> localdistrictmap = new HashMap<>(0);
        List<District> maindistrictlist = new ArrayList<>(0);
        List<LocalDistrict> localdistrictlist = new ArrayList<>(0);
        List<Voter> voterList = new ArrayList<>(0);
        List<District> visited = new ArrayList<>(0);
        List<District>  allvisited = new ArrayList<>(0);
        //String filename = args[0]; //read voters.txt
        String filename = "voters.txt";
        voterList = readvoter(filename);
        //String filename2 = args[1]; //read local_district.txt
        String filename2 = "local_districts.txt";
        localdistrictlist = readLocalDistrict(filename2, voterList);
        localdistrictmap = putittomap(localdistrictlist);
        Set<Entry<String, String>> entries = localdistrictmap.entrySet();
        MapComparator2 comp = new MapComparator2();
        MergeSort<Entry<String, String>> sorter = new MergeSort<>();
        ArrayList<Entry<String, String>> lst =
            new ArrayList<Entry<String, String>>(entries.size());
        lst.addAll(entries);
        sorter.sort(lst, comp);
        for (Entry<String, String> a : lst) {
            System.out.println(a);
        }
        //String filename3 = args[2]; //read district.txt
        String filename3 = "districts.txt";
        visited = getDistrictWithOnlyL(filename3, localdistrictlist);
        allvisited = getAllvisited(filename3, localdistrictlist);
        for (District a : allvisited) {
            List<District> newdis = a.getSubDistrict();
            for (District disdis : newdis) {
                for (District local : localdistrictlist) {
                    if (local.getDistrictName().equals(
                        disdis.getDistrictName())) {
                        disdis = local;
                    }
                }
                for (District disdisdis : allvisited) {
                    if (disdis.getDistrictName().equals(
                        disdisdis.getDistrictName())) {
                        disdis = disdisdis;
                    }
                }
            }
        }
        String finalwinner = "";
        int size = 0;
        int sizefinal = 0;
        for (District b : allvisited) {
            for (District a : b.getSubDistrict()) {
                sizefinal = sizefinal + a.getSize();
            }
        }
        for (District a :allvisited) {
            int temsize = a.getSize();
            if (temsize > size) {
                finalwinner = a.getWinner();
                size = temsize;
            }
        }
        System.out.println();
        System.out.println("Sorted according to their names :D");
        System.out.println();
        System.out.println("Here is the Winner of the all District");
        System.out.println(finalwinner + " with the score of " + sizefinal);
    }
    /**
    * map the localdistrict according to name and winner
    * @param localdis the arraylist of all local district
    * @return the hashmap of local district
    */
    public static Map<String, String> putittomap(
        List<LocalDistrict> localdis) {
        Map<String, String> localmap = new HashMap<String, String>(0);
        for (LocalDistrict a : localdis) {
            String disname = a.getDistrictName();
            String winner = a.getWinner();
            localmap.put(disname, winner);
        }
        return localmap;
    }
    /**
    * get all the composite district visited
    * @param filename the file to be opened
    * @param localdistrictlist all the localdistrict
    * @return all the composite district visited
    */
    public static List<District> getAllvisited(String filename,
        List<LocalDistrict> localdistrictlist) {
        File file = new File(filename);
        List<District> districtlist = new ArrayList<>(0);
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNext()) {
                String newline = sc.nextLine();
                String[] newstring = newline.split(":");
                String districtname = newstring[0].trim();
                String[] subdistricts = newstring[1].split(",");
                District tempdistrict = new CompositeDistrict(districtname);
                for (String a : subdistricts) {
                    String b = a.trim();
                    Iterator<LocalDistrict>ite = localdistrictlist.iterator();
                    while (ite.hasNext()) {
                        LocalDistrict c = ite.next();
                        if (b.equals(c.getDistrictName())) {
                            tempdistrict.addDistrict(c);
                        }
                    }
                }
                districtlist.add(tempdistrict);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        return districtlist;
    }

    /**
    * get all composite district contains only local district
    * @param filename the file to be opened
    * @param localdistrictlist all the localdistrict
    * @return all the composite district contains only local district
    */
    public static List<District> getDistrictWithOnlyL(String filename,
        List<LocalDistrict> localdistrictlist) {
        File file = new File(filename);
        List<District> districtlist = new ArrayList<>(0);
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNext()) {
                String newline = sc.nextLine();
                String[] newstring = newline.split(":");
                String districtname = newstring[0].trim();
                String[] subdistricts = newstring[1].split(",");
                List<District> templocalD = new ArrayList<>(0);
                for (String a : subdistricts) {
                    Iterator<LocalDistrict> ite = localdistrictlist.iterator();
                    String b = a.trim();
                    while (ite.hasNext()) {
                        LocalDistrict c = ite.next();
                        if (b.equals(c.getDistrictName())) {
                            templocalD.add(c);
                        }
                    }
                }
                if (templocalD.size() == (subdistricts.length)) {
                    CompositeDistrict newcompD = new CompositeDistrict(
                        templocalD, districtname);
                    districtlist.add(newcompD);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        return districtlist;
    }
    /**
    * get all local district contains only local district
    * @param filename the file to be opened
    * @param voterlist all the voters
    * @return all the local district contains in the main file
    */
    public static List<LocalDistrict> readLocalDistrict(String filename,
        List<Voter> voterlist) {
        File file = new File(filename);
        List<LocalDistrict> localdistrictlist2 = new ArrayList<>(0);
        try {
            Scanner sc6 = new Scanner(file);
            while (sc6.hasNextLine()) {
                List<Voter> newvoterlist = new ArrayList<>(0);
                String newline = sc6.nextLine();
                String[] result = newline.split(":");
                String localdistrictname = result[0].trim();
                String voters = result[1];
                String[] secondresult = voters.split(",");
                for (String a : secondresult) {
                    for (Voter voter : voterlist) {
                        if (voter.getVoterName().equals(a.trim())) {
                            newvoterlist.add(voter);
                        }
                    }
                }
                if (!newvoterlist.isEmpty()) {
                    localdistrictlist2.add(new LocalDistrict(newvoterlist,
                        localdistrictname));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file is Found lol");
        }
        return localdistrictlist2;
    }

    /**
    * get all the voters with their votes
    * @param filename the file to be opened
    * @return all the voters with their votes
    */
    public static List<Voter> readvoter(String filename) {
        File file = new File(filename);
        List<Voter> voterlist = new ArrayList<>(0);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String newline = sc.nextLine();
                String[] result = newline.split(":");
                String votername = result[0].trim();
                String votes = result[1];
                String[] secondresult = votes.split(",");
                String firstname = secondresult[0].trim();
                String secondname = secondresult[1].trim();
                String thirdname = secondresult[2].trim();
                voterlist.add(new Voter(votername, firstname,
                    secondname, thirdname));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file is Found");
        }
        return voterlist;
    }
}