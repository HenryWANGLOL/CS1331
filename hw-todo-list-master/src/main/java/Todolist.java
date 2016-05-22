import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Todolist {
    public static boolean containthenameornot(String[] ar, String name) {
        boolean containornot = false;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != null) {
                if (ar[i].equalsIgnoreCase(name)) {
                    containornot = true;
                }
            }
        }
        return containornot;
    }
    public static void createcsvfile(String name2) {
        String newfilename = name2 + ".csv";
        try {
            File csv = new File(newfilename);
            BufferedWriter bw2 = new BufferedWriter(new
                FileWriter(csv, true));
            bw2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void putnewname(String a) {
        try {
            File csv = new File("users.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            bw.write(a);
            bw.newLine();
            bw.close();
            System.out.println();
            System.out.println("Your username is added into our system!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void showthetasks(Goals[] goalsarray) {
        for (Goals a : goalsarray) {
            System.out.println(a.getgoalname() + " - " + a.getgoalstatus2());
            a.gettaskdetails();
        }
    }
    public static void onlyshowgoals(Goals[] goalsarray) {
        int count = 1;
        for (Goals a : goalsarray) {
            System.out.println(count + " " + a.getgoalname());
            count++;
        }
    }
    public static boolean checktheuserexist(String name) {
        String[] finalalone = {};
        String[] ar = new String[100];
        int count = 0;
        try {
            File filename = new File("users.csv");
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = "";
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                while (st.hasMoreTokens()) {
                    String newname = st.nextToken();
                    String newname3 = newname.replaceAll(" ", "");
                    ar[count] = newname3;
                    count++;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return containthenameornot(ar, name);
    }
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean checkcondition(String[] item) {
        boolean ab = true;
        for (String a : item) {
            if (!isInteger(a)) {
                ab = false;
            }
        }
        try {
            int intger1 = Integer.parseInt(item[1]);
            int intger2 = Integer.parseInt(item[2]);
            int intger3 = Integer.parseInt(item[3]);
            int intger4 = Integer.parseInt(item[4]);
            if (intger1 > 12 | intger2 > 13 | intger3 > 24 | intger4 > 60) {
                ab = false;
            }
        } catch (NumberFormatException e) {
            ab = false;
        }
        return ab;
    }
    public static String checkpriority(String ps) {
        Scanner woca = new Scanner(System.in);
        String newstring = null;
        boolean trigger12 = true;
        int psint = 0;
        while (trigger12) {
            if (isInteger(ps)) {
                psint = Integer.parseInt(ps);
                System.out.println(psint);
                if (psint >= 0 & psint < 10) {
                    trigger12 = false;
                    newstring = ps;
                } else {
                    System.out.println("Integer between 0 - 9");
                    newstring = woca.next();
                    ps = newstring;
                }
            } else {
                System.out.println("Integer between 0 - 9");
                newstring = woca.next();
                ps = newstring;
            }

        }
        return newstring;

    }
    public static Goals[] addtask(Goals[] goalsarray, int goallength) {
        boolean trigger2 = true;
        while (trigger2) {
            System.out.println("Under which goal you want to addtask");
            onlyshowgoals(goalsarray);
            Scanner scanname4 = new Scanner(System.in);
            String value = scanname4.next();
            if (isInteger(value) && Integer.parseInt(value) <= goallength) {
                int number = Integer.parseInt(value);
                System.out.println("what is the taskname");
                String taskname = scanname4.next();
                System.out.println("what is the priority level? from 0-9");
                String priority = scanname4.next();
                String truepriority = checkpriority(priority);
                boolean trigger3 = true;
                while (trigger3) {
                    System.out.println("what is the duetime? Year");
                    String dueyear = scanname4.next();
                    System.out.println("what is the duetime? month");
                    String duemonth = scanname4.next();
                    System.out.println("what is the duetime? day");
                    String dueday = scanname4.next();
                    System.out.println("what is the duetime? hr");
                    String duehr = scanname4.next();
                    System.out.println("what is the duetime? min");
                    String duemin = scanname4.next();
                    String[] item = {dueyear, duemonth, dueday, duehr, duemin};
                    if (checkcondition(item)) {
                        String duetime2 = item[0] + "-" + item[1] + "-"
                            + item[2] + "-" + item[3] + "T" + item[4];
                        String completeornot = "false";
                        Tasks newtask = new Tasks(taskname, priority,
                            duetime2, completeornot);
                        goalsarray[number - 1].addtask(newtask);
                        trigger2 = false;
                        trigger3 = false;
                    } else {
                        System.out.println("type properly");
                    }
                }
            } else {
                System.out.println("please Type again");
            }
        }
        return goalsarray;
    }

    public static Goals[] markascomplete(Goals[] g, int goallength2) {
        boolean trigger2 = true;
        while (trigger2) {
            System.out.println("Under which goal you want"
                + "to complete the task");
            onlyshowgoals(g);
            Scanner scanname4 = new Scanner(System.in);
            String value = scanname4.next();
            if (isInteger(value)) {
                int number = Integer.parseInt(value);
                System.out.println("Which task you want to complete");
                g[number - 1].gettaskdetails();
                int tasknumber = Integer.parseInt(scanname4.next());
                g[number - 1].gettaskarray()[tasknumber - 1].cs();
                trigger2 = false;
            } else {

                System.out.println("please Type again");
            }
        }
        return g;
    }
    public static String getnameoftask(String taskname) {
        return taskname;
    }
    public static String getnameoftask2(String taskname) {
        String t = taskname.replaceAll(" ", "");
        return t;
    }

    public static void writecsv(String filename, Goals[] goalsarray) {
        String newfilename = filename + ".csv";
        try {
            File csv = new File(newfilename);
            BufferedWriter bw3 = new BufferedWriter(new FileWriter(csv, false));
            for (Goals a : goalsarray) {
                bw3.write(a.getgoalname() + ",");
                Tasks[] taskarray = a.gettaskarray();
                for (Tasks b : taskarray) {
                    if (b != null) {
                        bw3.write(b.toString() + ",");
                    } else {
                        break;
                    }
                }
                bw3.newLine();
            }
            bw3.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int goallength(String name) {
        int count = 0;
        String newfilename = name + ".csv";
        int maxlength = 0;
        try {
            BufferedReader reader = new BufferedReader(new
                FileReader(newfilename));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                if (item.length > maxlength) {
                    maxlength = item.length;
                }
                count++;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static boolean checkgoalstatus(Tasks[] tasksarray) {
        boolean ab = true;
        for (Tasks a : tasksarray) {
            if (a != null) {
                if (!a.gettaskstatus()) {
                    ab = false;
                }
            }
        }
        return ab;
    }

    public static Goals[] checkgoalsandtask(String name, int count) {
        Goals[] goalsarray2 = new Goals[count];
        int count2 = 0;
        String newfilename = name + ".csv";
        try {
            BufferedReader reader = new BufferedReader(new
                FileReader(newfilename));
            String line = null;
            while ((line = reader.readLine()) != null) {
                Tasks[] tasksarray = new Tasks[10];
                String[] item = line.split(",");
                for (int i = 1; i < item.length; i++) {
                    String[] item2 = item[i].split("\\|");
                    String nameoftask = getnameoftask(item2[0]);
                    String valueofpriority = getnameoftask2(item2[1]);
                    String dateandtime = getnameoftask2(item2[2]);
                    String completeornot = getnameoftask2(item2[3]);
                    tasksarray[i - 1] = new Tasks(nameoftask, valueofpriority,
                        dateandtime, completeornot);
                }
                String gname = item[0];
                boolean goalstatus = checkgoalstatus(tasksarray);
                goalsarray2[count2] = new Goals(gname, goalstatus, tasksarray);
                count2++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goalsarray2;
    }

    public static Tasks[] createatask() {
        Scanner scanname4 = new Scanner(System.in);
        System.out.println("what is the taskname");
        String taskname = scanname4.next();
        boolean trigger11 = true;
        String priority = null;
        while (trigger11) {
            System.out.println("what is the priority? from 0-9");
            String priorite = scanname4.next();
            if (isInteger(priorite)) {
                if (Integer.parseInt(priorite) < 10) {
                    priority = priorite;
                    trigger11 = false;
                } else {
                    System.out.println("retype please");
                }
            } else {
                System.out.println("integer between 0 and 9");
            }
        }
        boolean trigger5 = true;
        String duetime2 = null;
        while (trigger5) {
            System.out.println("what is the duetime? in yyyy/mm/dd/hh/mm");
            String duetime = scanname4.next();
            String[] item = duetime.split("/");
            if (checkcondition(item)) {
                duetime2 = item[0] + "-" + item[1] + "-" + item[2] + "-"
                        + item[3] + "T" + item[4];
                trigger5 = false;
            } else {
                System.out.println("type properly");
            }
        }
        Tasks newtask = new Tasks(taskname, priority, duetime2, "false");
        Tasks[] newtaskarray = new Tasks[1];
        newtaskarray[0] = newtask;
        return newtaskarray;
    }
    public static Goals[] addgoal(Goals[] goalsarray, int length) {
        Scanner scanname3 = new Scanner(System.in);
        System.out.println("What is the name of your goal?");
        String newgoalname = scanname3.next();
        System.out.println("Please create a task for the goal");
        Tasks[] newtask = createatask();
        Goals newgoal = new Goals(newgoalname, false, newtask);
        Goals[] newgoalsarray = new Goals[length + 1];
        for (int i = 0; i < length; i++) {
            newgoalsarray[i] = goalsarray[i];
        }
        newgoalsarray[length] = newgoal;
        newgoalsarray[0].getgoalname();
        System.out.println();
        System.out.println();
        return newgoalsarray;
    }

    public static void checkallusers() {
        try {
            File filename = new File("users.csv");
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = "";
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                while (st.hasMoreTokens()) {
                    String newname = st.nextToken();
                    String newname2 = newname + ".csv";
                    try {
                        File filename2 = new File(newname2);
                        BufferedReader br5 = new BufferedReader(new
                            FileReader(filename2));
                    } catch (FileNotFoundException e) {
                        createcsvfile(newname2);
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        checkallusers();
        Scanner scanname = new Scanner(System.in);
        System.out.println("what is your user name?");
        String name = scanname.next();
        boolean containornot = checktheuserexist(name);
        int goallength2 = 0;
        if (!containornot) {
            System.out.println("You username is not existing, do you want"
                + "to create a new one? yes/no");
            String name2 = scanname.next();
            if (name2.equalsIgnoreCase("yes")) {
                System.out.println("Please Retype your name to confirm");
                putnewname(name);
                createcsvfile(name);
            }
        } else {
            goallength2 = goallength(name);
            Goals[] goalsarray = new Goals[goallength2];
            System.out.println("Do you want to see your goals? yes/no");
            String answer2 = scanname.next();
            goalsarray = checkgoalsandtask(name, goallength2);
            if (answer2.equalsIgnoreCase("yes")) {
                showthetasks(goalsarray);
            }
            boolean trigger1 = true;
            while (trigger1) {
                System.out.println();
                System.out.println("Select An option!(type integers)");
                System.out.println("     [1] add goal");
                System.out.println("     [2] add task");
                System.out.println("     [3] mark complete");
                System.out.println("     [4] save and exit");
                String answer3 = scanname.next();
                System.out.println(answer3);
                int numberofchoice = Integer.parseInt(answer3);
                if (numberofchoice == 1) {
                    goalsarray = addgoal(goalsarray, goallength2);
                    System.out.println("You goal is created");
                } else if (numberofchoice == 2) {
                    goalsarray = addtask(goalsarray, goallength2);
                } else if (numberofchoice == 3) {
                    goalsarray = markascomplete(goalsarray, goallength2);
                } else if (numberofchoice == 4) {
                    trigger1 = false;
                    writecsv(name, goalsarray);
                }
            }
        }
    }
}