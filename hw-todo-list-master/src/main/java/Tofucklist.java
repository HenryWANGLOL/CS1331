import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.time.LocalDateTime;

public class Tofucklist {

	public static String getnameoftask(String taskname) {
        return taskname;
    }
    public static String getnameoftask2(String taskname) {
    	String t = taskname.replaceAll(" ", "");
        return t;
    }

	public static void main (String[] args){

		String newfilename = "yufeng" + ".csv";
        try {
            BufferedReader reader = new BufferedReader(new
                FileReader(newfilename));
            String line = null;
            int count = 0;
            Tasks[] tasksarray = new Tasks[10];
            Goals[] Goalsarray2 = new Goals[10];
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                for (int i = 1; i < item.length; i++) {
                	if (item[i] != null) {
                	String[] item2 = item[i].split("\\|");
                	String nameoftask = getnameoftask(item2[0]);
                	String valueofpriority = getnameoftask2(item2[1]);
                	String dateandtime = getnameoftask2(item2[2]);
                	String completeornot = getnameoftask2(item2[3]);
                    tasksarray[i-1] = new Tasks(nameoftask, valueofpriority, dateandtime, completeornot);
                } else {
                	break;
                }
            }

                System.out.println(tasksarray[0].Gettaskname());
                
            }
  

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		}
	}
