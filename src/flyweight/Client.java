package flyweight;

public class Client {
    public static void main(String[] args) {
        Flyweight flyweight;
        FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();

        flyweight = flyweightFactory.getFlyweight("MyClass");
        System.out.println(flyweight.operation());

        flyweight = flyweightFactory.getFlyweight("MyClass");
        System.out.println(flyweight.operation());

        System.out.println("\nNumber of flyweights created: " + flyweightFactory.getSize());
    }
}
