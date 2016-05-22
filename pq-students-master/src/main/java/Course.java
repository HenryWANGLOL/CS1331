public class Course {
    private String nameofcourse;
    private int credit;
    private int lettergrade;
    public Course(String nameofcourse, int credit, int lettergrade) {
        this.nameofcourse = nameofcourse;
        this.credit = credit;
        this.lettergrade = lettergrade;
    }
    public int getCredits() {
        return credit;
    }
    public int getGrade() {
        return lettergrade;
    }
    public String toString() {
        return nameofcourse + ": " + lettergrade;
    }
}