package state;

public class Shielded implements State {
    private static final State instance = new Shielded();

    private Shielded() {
    }

    public static State getInstance() {
        return instance;
    }

    @Override
    public void damage(Player player) {
        player.takeDamage((byte) 10);
    }
}
