public class Student {
    private String nameofstudent;
    private Course[] coursearray;
    public Student(String nameofstudent, Course[] coursearray) {
        this.nameofstudent = nameofstudent;
        this.coursearray = coursearray;
    }
    public int getCredits() {
        int numofcredits = 0;
        for (Course p : coursearray) {
            numofcredits = p.getCredits() + numofcredits;
        }
        return numofcredits;
    }

    public String toString() {
        int numberofcourses = 0;
        
        int count = 0;
        for (Course p : coursearray) {
            numberofcourses++;
        }

        String[] one = new String[numberofcourses];

        String two = nameofstudent + " is taking " + numberofcourses;
        for (Course p : coursearray) {
            one[count] = p.toString() + " \n";
            count++;
        }
        return  two + " \n" + one;
    }

    public double getGPA() {
        int totalcredits = 0;
        int totalgpa = 0;
        int credits2 = 0;
        for (Course p : coursearray) {
            totalcredits = totalcredits +  p.getCredits() * p.getGrade();
            credits2 = getCredits();
        }
        return (double) totalcredits / credits2;
    }
}