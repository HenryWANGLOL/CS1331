public class SuperHero {
    public String name;
    public SuperPower[] powers;
    public String ego;
    public String tragicBackstory = "Parents died";
    public String catchphrase;
    public int x = 0;

    public SuperHero() {
        x++;
    }

    public SuperHero(String name, String ego, String catchphrase, SuperPower ... powers) {
        this.name = name;
        this.ego = ego;
        this.catchphrase = catchphrase;
        this.powers = powers;
    }

    public String getCatchPhrase() {
        return catchphrase;
    }

    public String gettragy () {
        return tragicBackstory;
    }

    public SuperPower[] superpower() {
        return powers;
    }
}