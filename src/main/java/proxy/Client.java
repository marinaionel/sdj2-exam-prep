package proxy;

public class Client {
    public static void main(String[] args) {
        IInternet internet = new ProxyInternet();
        try {
            internet.connectTo("via.dk");
            internet.connectTo("example.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
