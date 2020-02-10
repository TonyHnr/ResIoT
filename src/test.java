import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.KNXFormatException;
import tuwien.auto.calimero.KNXTimeoutException;
import tuwien.auto.calimero.knxnetip.KNXnetIPTunnel;
import tuwien.auto.calimero.link.KNXLinkClosedException;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

public class test {

    public void main(String[] args) throws KNXException, InterruptedException {
        fonction1();
    }



    public void fonction1 () throws KNXException, InterruptedException {
        KNXNetworkLinkIP netLinkIp = new KNXNetworkLinkIP ("192.168.1.201", new TPSettings(false));
        ProcessCommunicator pc = new ProcessCommunicatorImpl(netLinkIp);


        boolean temp = pc.readBool(new GroupAddress("0/1/0"));
        pc.write(new GroupAddress("0/0/1"), !temp);

        pc.close();
        netLinkIp.close();
    }

}
