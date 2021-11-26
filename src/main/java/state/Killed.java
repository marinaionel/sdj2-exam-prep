package state;

public class Killed implements State {
    private static final State instance = new Killed();

    private Killed() {
    }

    public static State getInstance() {
        return instance;
    }

    @Override
    public void damage(Player player) {
        System.out.println("Player " + player.getName() + " is already killed!");
    }
}
