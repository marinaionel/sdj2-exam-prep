package state;

public class Basic implements State {
    private static final State instance = new Basic();

    private Basic() {
    }

    public static State getInstance() {
        return instance;
    }

    @Override
    public void damage(Player player) {
        player.takeDamage((byte) 20);
    }
}
