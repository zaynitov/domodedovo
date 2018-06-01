package main;

import unisoft.ws.FNSNDSCAWS2;
import unisoft.ws.FNSNDSCAWS2Port;
import unisoft.ws.fnsndscaws2.request.NdsRequest2;
import unisoft.ws.fnsndscaws2.request.ObjectFactory;
import unisoft.ws.fnsndscaws2.response.NdsResponse2;

import java.util.List;

/**
 * Created by Альберт on 01.06.2018.
 */
public class Main {
    private static String INN;
    private static String KPP;
    private static String Date;

    public static void main(String[] args) {
        checkData(args);

        FNSNDSCAWS2 fnsndscaws2 = new FNSNDSCAWS2();
        FNSNDSCAWS2Port fnsndscaws2Port = fnsndscaws2.getFNSNDSCAWS2Port();
        NdsRequest2.NP ndsRequest2NP = new unisoft.ws.fnsndscaws2.request.ObjectFactory().createNdsRequest2NP();
        ndsRequest2NP.setINN(INN);
        ndsRequest2NP.setKPP(KPP);
        ndsRequest2NP.setDT(Date);

        NdsRequest2 ndsRequest2 = new unisoft.ws.fnsndscaws2.request.ObjectFactory().createNdsRequest2();
        ndsRequest2.getNP().add(ndsRequest2NP);
        NdsResponse2 ndsResponse2 = fnsndscaws2Port.ndsRequest2(ndsRequest2);

        System.out.println(ndsResponse2.getNP().get(0).getState());
    }

    public static void checkData(String args[]) {
        if (args.length == 0) {
            System.out.println("Вы должны ввести данные.");
            System.exit(0);

        }
        if (args.length == 1) {
            INN = args[0];
            return;
        }
        if (args.length == 2) {
            INN = args[0];
            KPP = args[1];
            return;
        }
        if (args.length == 3) {
            INN = args[0];
            KPP = args[1];
            Date = args[2];
            return;
        }
        System.out.println("Пожалуйста введите корректные данные");
        System.exit(0);

    }


}
