public class Goals {
    private boolean goalstatus;
    private String goalname;
    private Tasks[] taskarray;
    public Goals(String goalname, boolean goalstatus, Tasks[] taskarray) {
        this.goalname = goalname;
        this.goalstatus = goalstatus;
        this.taskarray = taskarray;
    }


    public void addtask(Tasks newtask) {
        int count = 0;
        for (Tasks a : taskarray) {
            if (a != null) {
                count++;
            }
        }
        Tasks[] newtaskarray = new Tasks[count + 1];
        newtaskarray[count] = newtask;
        taskarray = newtaskarray;
    }
    public boolean getgoalstatus() {
        return goalstatus;
    }
    public Tasks[] gettaskarray() {
        return taskarray;
    }
    public String getgoalstatus2() {
        String ab = null;
        if (goalstatus) {
            ab = "complete";
        } else {
            ab = "incomplete";
        }
        return ab;
    }
    public String getgoalname() {
        return goalname;
    }
    public void gettaskdetails() {
        int count = 1;
        for (Tasks a : taskarray) {
            if (a != null) {
                System.out.println(" - " + count + " " + a.gettaskname() + " - "
                    + a.getpriority() + " - due " + a.getdateandtime()
                    + " - " + a.gettaskstatus2());
                count++;
            }
        }
    }
}