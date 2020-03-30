import java.net.InetAddress;
import java.net.InetSocketAddress;

import tuwien.auto.calimero.CloseEvent;
import tuwien.auto.calimero.FrameEvent;
import tuwien.auto.calimero.KNXAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.link.KNXLinkClosedException;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.NetworkLinkListener;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

public class Connection implements  NetworkLinkListener{

    private int tempAttente;

    private Chenillard chenillard;

    private ProcessCommunicator pc;

    private  int vit;

    private KNXNetworkLinkIP netLinkIp;

    public Connection (InetSocketAddress source, InetSocketAddress destination, boolean utilisationNAT, TPSettings tpSetting, int tempAttente) throws KNXException, InterruptedException {

        netLinkIp = KNXNetworkLinkIP.newTunnelingLink(source, destination, false, new TPSettings());
        pc = new ProcessCommunicatorImpl(netLinkIp);

        this.tempAttente = tempAttente;
        //Vitesse initialiser à 1000ms
         this.vit = 1000;
         //On initialise un chenillard
        chenillard = new Chenillard(pc, vit);
        netLinkIp.addLinkListener(this);

    }

    //Permet de savoir si la connexion est ouverte
    public boolean estOuvert(){

        return netLinkIp.isOpen();

    }

    @Override
    public void confirmation(FrameEvent frameEvent) {

    }

    @Override
    public void indication(FrameEvent arg0) {


        KNXAddress add = ((tuwien.auto.calimero.cemi.CEMILData) arg0.getFrame()).getDestination();



        //on regarde si c'est un interrupteur
        if(add.toString().charAt(0)=='1'){


            //System.out.println("targetadress " + ((tuwien.auto.calimero.cemi.CEMILData) arg0.getFrame()).getDestination());

            //On regarde quel interrupteur est déclenché
            System.out.println(add.toString().charAt(add.toString().length()-1));

            //Interrupteur 1
            if(add.toString().charAt(add.toString().length()-1) == '1') {

                //Si la vitesse n'est pas en dessous de 200ms, on lance un chenillard classique
                if (vit >= 200) {
                    vit = 1000;
                    chenillard.stopC();
                    chenillard = new Chenillard(pc, vit);
                    chenillard.start();
                    System.out.println("start : "+ vit);
                }
                else{
                    System.out.println("no work " + vit);
                }

            }


            //Interrupteur 4
            if(add.toString().charAt(add.toString().length()-1) == '4'){

                //On arrète le chenillard en cours et le lien
                chenillard.stopC();
                System.out.println("stop");
                pc.close();
                netLinkIp.close();

            }

            //Interrupteur 2
            if(add.toString().charAt(add.toString().length()-1) == '2') {

                //On diminue la vitesse
                chenillard.stopC();
                if (vit >=300) {
                    vit = vit - 100;
                }
                //On lance un nouveau chenillard
                chenillard = new Chenillard(pc, vit);
                chenillard.start();
                System.out.println("vitesse : " + vit);

            }

            //Interrupteur 3
            if(add.toString().charAt(add.toString().length()-1) == '3') {

                //On augmente la vitesse et on lance un nouveau chenillard
                chenillard.stopC();
                vit = vit + 100;
                chenillard = new Chenillard(pc, vit);
                chenillard.start();
                System.out.println("vitesse : " + vit);

            }



        }

    }


    @Override
    public void linkClosed(CloseEvent closeEvent) {

    }

}
