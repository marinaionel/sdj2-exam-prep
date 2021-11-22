package proxy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

public class Internet implements IInternet {
    @Override
    public void connectTo(String site) {
        URL siteURL = null;
        try {
            siteURL = new URL("http://" + site + "/");
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL!");
        }
        URLConnection siteConnection = null;
        try {
            siteConnection = Objects.requireNonNull(siteURL).openConnection();
        } catch (IOException e) {
            System.err.println("Connection failed!");
        }
        try {
            Objects.requireNonNull(siteConnection).connect();
        } catch (IOException e) {
            System.err.println("Connection failed!");
        }
        System.out.println("Successfully connected to " + site);
    }
}
