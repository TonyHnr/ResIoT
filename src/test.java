import tuwien.auto.calimero.*;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.NetworkLinkListener;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;


import java.net.InetSocketAddress;

public class test {

    public static void main(String[] args) throws KNXException, InterruptedException {
        fonction1();
    }

    public static InetSocketAddress IPLocal = new InetSocketAddress("192.168.1.103", 0);
    public static InetSocketAddress IPBloc = new InetSocketAddress("192.168.1.201",3671);





    public static void fonction1 () throws KNXException, InterruptedException {
        KNXNetworkLinkIP netLinkIp = KNXNetworkLinkIP.newTunnelingLink(IPLocal, IPBloc, false, new TPSettings());
        ProcessCommunicator pc = new ProcessCommunicatorImpl(netLinkIp);

        final String[] button = {""};

        netLinkIp.addLinkListener(new NetworkLinkListener() {
            @Override
            public void confirmation(FrameEvent frameEvent) {

            }

            @Override
            public void indication(FrameEvent arg0) {

                KNXAddress add = ((tuwien.auto.calimero.cemi.CEMILData) arg0.getFrame()).getDestination();
                if(add.toString().charAt(0)=='1'){
                    System.out.println("targetadress " + ((tuwien.auto.calimero.cemi.CEMILData) arg0.getFrame()).getDestination());
                }
            }

            @Override
            public void linkClosed(CloseEvent closeEvent) {

            }
        });


        //pc.write(new GroupAddress("0/0/1"), true);



            for (int i = 0; i < 3; i++) {
                pc.write(new GroupAddress("0/0/1"), true);
                Thread.sleep(1000);
                pc.write(new GroupAddress("0/0/1"), false);
                pc.write(new GroupAddress("0/0/2"), true);
                Thread.sleep(1000);
                pc.write(new GroupAddress("0/0/2"), false);
                pc.write(new GroupAddress("0/0/3"), true);
                Thread.sleep(1000);
                pc.write(new GroupAddress("0/0/3"), false);
                pc.write(new GroupAddress("0/0/4"), true);
                Thread.sleep(1000);
                pc.write(new GroupAddress("0/0/4"), false);

            }


            pc.close();
            netLinkIp.close();

    }









}
