public class Tasks {
    private String nameoftask;

    private String valueofpriority;

    private String dateandtime;

    private String completeornot;

    public Tasks(String nameoftask, String valueofpriority,
        String dateandtime, String completeornot) {
        this.nameoftask = nameoftask;
        this.valueofpriority = valueofpriority;
        this.dateandtime = dateandtime;
        this.completeornot = completeornot;
    }

    public String gettaskname() {
        String t = nameoftask.replaceAll(" ", "");
        return t;
    }

    public boolean gettaskstatus() {
        String t = completeornot.replaceAll(" ", "");
        return t.equals("true");
    }

    public String gettaskstatus2() {
        String t = completeornot.replaceAll(" ", "");
        String ab = null;
        if (t.equals("false")) {
            ab = "incomplete";
        } else if (t.equals("true")) {
            ab = "complete";
        }
        return ab;
    }

    public String gettaskstatus3() {
        String t = completeornot.replaceAll(" ", "");
        return t;
    }

    public String getdateandtime() {
        String dateandtime2 = dateandtime.replaceAll("T" , ":");
        return dateandtime2;
    }

    public int getvalueofpriority() {
        return Integer.parseInt(valueofpriority);
    }

    public String getpriority() {
        String ab = null;
        int priorityint = Integer.parseInt(valueofpriority);
        if (priorityint < 4) {
            ab = "Low Priority";
        } else if (priorityint < 7) {
            ab = "Medium Priority";
        } else {
            ab = "High Priority";
        }
        return ab;
    }
    public void cs() {
        String t = completeornot.replaceAll(" ", "");
        String ab = null;
        if (t.equals("false")) {
            ab = "true";
        } else {
            ab = "false";
        }
        completeornot = ab;
    }


    public String toString() {
        String output = new String();
        output = nameoftask + " | " + valueofpriority + " | "
            + dateandtime + " | " + completeornot;
        return output;
    }
}