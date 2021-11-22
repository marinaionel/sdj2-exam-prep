package state;

public class Run {
    public static void main(String[] args) {
        Player player = new Player("player1");

        player.getState().damage(player);
        player.getState().damage(player);
        player.getState().damage(player);
        player.upgrade();
        player.getState().damage(player);
        player.getState().damage(player);
        player.getState().damage(player);
        player.getState().damage(player);
        player.getState().damage(player);
    }
}
