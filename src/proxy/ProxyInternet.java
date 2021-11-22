package proxy;

import java.util.HashSet;
import java.util.Set;


public class ProxyInternet implements IInternet {
    private IInternet internet;
    private Set<String> bannedSites;

    public ProxyInternet() {
        internet = new Internet();
        bannedSites = new HashSet<>();
        bannedSites.add("example.com");
    }

    @Override
    public void connectTo(String site) throws Exception {
        if (bannedSites.contains(site.toLowerCase())) throw new Exception("Access Denied");
        internet.connectTo(site);
    }

}
