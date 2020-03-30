import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.KNXFormatException;
import tuwien.auto.calimero.KNXTimeoutException;
import tuwien.auto.calimero.link.KNXLinkClosedException;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class Chenillard extends Thread {
    ProcessCommunicator pc;
    int temps; // La temps entre chaque LEDs

    public Chenillard(ProcessCommunicator pc, int temps) {
        this.pc = pc;
        this.temps = temps;
    }

    boolean cont = true;



    @Override
    public void run() {
        //Création du chenillard en fontion de temps
        while (cont) {

            try {
                pc.write(new GroupAddress("0/0/1"), true);
                Thread.sleep(temps);
                pc.write(new GroupAddress("0/0/1"), false);
                pc.write(new GroupAddress("0/0/2"), true);
                Thread.sleep(temps);
                pc.write(new GroupAddress("0/0/2"), false);
                pc.write(new GroupAddress("0/0/3"), true);
                Thread.sleep(temps);
                pc.write(new GroupAddress("0/0/3"), false);
                pc.write(new GroupAddress("0/0/4"), true);
                Thread.sleep(temps);
                pc.write(new GroupAddress("0/0/4"), false);

            } catch (KNXTimeoutException e) {
                e.printStackTrace();
            } catch (KNXLinkClosedException e) {
                e.printStackTrace();
            } catch (KNXFormatException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    //Pour stoper le chenillard, cont à false
    public void stopC (){
        cont = false;
        System.out.println("stop");
        try {
            Thread.sleep(temps*4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



