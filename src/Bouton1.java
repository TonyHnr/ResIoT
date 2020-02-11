import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

import java.net.InetSocketAddress;

public class Bouton1 {


    public static void main(String[] args) throws KNXException, InterruptedException {
        newfonction();
    }

    public static InetSocketAddress IPLocal = new InetSocketAddress("192.168.1.111", 0);
    public static InetSocketAddress IPBloc = new InetSocketAddress("192.168.1.201", 3671);


    public static void newfonction() throws KNXException, InterruptedException {
        KNXNetworkLinkIP netLinkIp = KNXNetworkLinkIP.newTunnelingLink(IPLocal, IPBloc, false, new TPSettings());
        ProcessCommunicator pc = new ProcessCommunicatorImpl(netLinkIp);



    }
}
