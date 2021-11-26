package state;

public class Player {
    private State state;
    private byte health;
    private String name;

    public Player(String name) {
        setState(Basic.getInstance());
        health = 100;
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    void upgrade() {
        System.out.println(name + " :: Upgrade to shielded.");
        setState(Shielded.getInstance());
    }

    public void takeDamage(byte i) {
        health -= i;
        System.out.println(name + " :: Damage :: Health - " + health);
        if (health <= 0) {
            setState(Killed.getInstance());
            System.out.println("Player " + name + " have been killed!");
        }
    }
}
