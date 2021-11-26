package flyweight;

public class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public String operation() {
        return "--- This operation is called on the object with intrinsic state: " + intrinsicState;
    }
}
