public class SuperPower {

    int damage, energy;
    String name;

    public SuperPower() {

    }

    public SuperPower(int damage, int energy, String name) {
        this.damage = damage;
        this.energy = energy;
        this.name = name;
    }


    public String toString() {
        return name + "has " + damage + " damage and takes " + energy
        + "energy to use.";
    }
}