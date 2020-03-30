import tuwien.auto.calimero.*;
import tuwien.auto.calimero.link.KNXLinkClosedException;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.NetworkLinkListener;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;


import java.net.InetSocketAddress;

public class test {

    //Initialisation de la connexion maquette/machine

    public static InetSocketAddress IPLocal = new InetSocketAddress("192.168.1.100", 0);
    public static InetSocketAddress IPBloc = new InetSocketAddress("192.168.1.202",3671);

    public static void main(String[] args) throws KNXException, InterruptedException {

        Connection connection = new Connection(IPLocal, IPBloc, false, new TPSettings(), 1000);

        //Il regarde si la connexion est ouverte toutes les 700ms pour stopper si besoin
        while (connection.estOuvert()) {

            Thread.sleep(700);

        }

    }

}
