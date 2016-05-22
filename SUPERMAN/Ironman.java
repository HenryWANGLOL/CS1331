public class Ironman extends SuperHero {

    private int wealth;

    public Ironman(String catchphrase, SuperPower ... powers) {
        super("Ironman", "Tony Stark", catchphrase, powers);
        // this.name = "Ironman";
        // this.ego = "Tony Stark";
        // this.catchphrase = catchphrase;
        // this.powers = powers;
        tragicBackstory = "I don't have one";
    }

    public static void main(String[] args) {
        Ironman im = new Ironman("JARVIS!", new SuperPower(10, 5, "Repulsar beam"));
        System.out.println(im.getCatchPhrase());
        System.out.println(im.SuperPower.toString());
    }

}