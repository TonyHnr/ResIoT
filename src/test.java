import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

import java.net.Inet4Address;
import java.net.InetSocketAddress;

public class test {

    public void main(String[] args) throws KNXException, InterruptedException {
        fonction1();
    }

    public static InetSocketAddress IPLocal = new InetSocketAddress("148.60.132.10", 0);
    public static InetSocketAddress IPBloc = new InetSocketAddress("192.168.1.201",2536);





    public void fonction1 () throws KNXException, InterruptedException {
        KNXNetworkLinkIP netLinkIp = new KNXNetworkLinkIP.newTunnelingLink(IPLocal, IPBloc, false, new TPSettings());
        ProcessCommunicator pc = new ProcessCommunicatorImpl(netLinkIp);


        boolean temp = pc.readBool(new GroupAddress("0/1/0"));
        pc.write(new GroupAddress("0/0/1"), !temp);

        pc.close();
        netLinkIp.close();
    }

}
