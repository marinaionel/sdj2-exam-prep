package flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static final FlyweightFactory INSTANCE = new FlyweightFactory();
    private Map<String, Flyweight> flyweights = new HashMap<>();

    private FlyweightFactory() {
    }

    public static FlyweightFactory getInstance() {
        return INSTANCE;
    }

    public Flyweight getFlyweight(String key) {
        if (flyweights.containsKey(key)) {
            System.out.println("Sharing a flyweight with key = " + key);
            return flyweights.get(key);
        }
        System.out.println("Creating a flyweight with key = " + key);
        Flyweight flyweight = new ConcreteFlyweight(key);
        flyweights.put(key, flyweight);
        return flyweight;
    }

    public int getSize() {
        return flyweights.size();
    }
}
