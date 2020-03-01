import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.KNXFormatException;
import tuwien.auto.calimero.KNXTimeoutException;
import tuwien.auto.calimero.link.KNXLinkClosedException;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

import java.net.InetSocketAddress;

public class Bouton2 extends Thread {
    public static InetSocketAddress IPLocal = new InetSocketAddress("192.168.1.103", 0);
    public static InetSocketAddress IPBloc = new InetSocketAddress("192.168.1.201", 3671);

    KNXNetworkLinkIP netLinkIp = KNXNetworkLinkIP.newTunnelingLink(IPLocal, IPBloc, false, new TPSettings());
    ProcessCommunicator pc = new ProcessCommunicatorImpl(netLinkIp);

    public Bouton2() throws KNXException, InterruptedException {
    }

    boolean cont = true;

    @Override
    public void run() {
        while (cont)
            try {
                pc.write(new GroupAddress("0/0/1"), true);
            } catch (KNXTimeoutException e) {
                e.printStackTrace();
            } catch (KNXLinkClosedException e) {
                e.printStackTrace();
            } catch (KNXFormatException e) {
                e.printStackTrace();
            }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            pc.write(new GroupAddress("0/0/1"), false);
        } catch (KNXTimeoutException e) {
            e.printStackTrace();
        } catch (KNXLinkClosedException e) {
            e.printStackTrace();
        } catch (KNXFormatException e) {
            e.printStackTrace();
        }
        try {
            pc.write(new GroupAddress("0/0/2"), true);
        } catch (KNXTimeoutException e) {
            e.printStackTrace();
        } catch (KNXLinkClosedException e) {
            e.printStackTrace();
        } catch (KNXFormatException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            pc.write(new GroupAddress("0/0/2"), false);
        } catch (KNXTimeoutException e) {
            e.printStackTrace();
        } catch (KNXLinkClosedException e) {
            e.printStackTrace();
        } catch (KNXFormatException e) {
            e.printStackTrace();
        }
        try {
            pc.write(new GroupAddress("0/0/3"), true);
        } catch (KNXTimeoutException e) {
            e.printStackTrace();
        } catch (KNXLinkClosedException e) {
            e.printStackTrace();
        } catch (KNXFormatException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            pc.write(new GroupAddress("0/0/3"), false);
        } catch (KNXTimeoutException e) {
            e.printStackTrace();
        } catch (KNXLinkClosedException e) {
            e.printStackTrace();
        } catch (KNXFormatException e) {
            e.printStackTrace();
        }
        try {
            pc.write(new GroupAddress("0/0/4"), true);
        } catch (KNXTimeoutException e) {
            e.printStackTrace();
        } catch (KNXLinkClosedException e) {
            e.printStackTrace();
        } catch (KNXFormatException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            pc.write(new GroupAddress("0/0/4"), false);
        } catch (KNXTimeoutException e) {
            e.printStackTrace();
        } catch (KNXLinkClosedException e) {
            e.printStackTrace();
        } catch (KNXFormatException e) {
            e.printStackTrace();
        }
    }

    public void stopC (){
        cont =false;
    }
}



