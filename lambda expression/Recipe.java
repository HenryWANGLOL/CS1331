public class Recipe implements Comparable<Recipe>{

    private double yummyFactor;
    private String name;
    private String originalBaker;

    public Recipe(double yummyFactor, String name, String originalBaker) {
        this.yummyFactor = yummyFactor;
        this.name = name;
        this.originalBaker = originalBaker;
    }

    public double getYummyFactor() {
        return yummyFactor;
    }

    public String getName() {
        return name;
    }

    public String getOB() {
        return originalBaker;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Recipe)) {
            return false;
        }
        Recipe that = (Recipe) other;
        return that.name.equals(this.name)
        && that.originalBaker.equals(this.originalBaker);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Recipe other) {
        return this.name.compareTo(other.name);
    }

    public String toString() {
        return name + " " + yummyFactor + " " + originalBaker;
    }

}












