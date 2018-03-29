/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example07;

import java.util.ArrayList;

/**
 *
 * @author W10-PRO
 */
public class Exercise07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        XeTai xt1 = new XeTai();
        XeTai xt2 = new XeTai();
        XeTai xt3 = new XeTai();
        XeDap xd1 = new XeDap();
        XeDap xd2 = new XeDap();
        XeDap xd3 = new XeDap();
        Oto oto1 = new Oto();
        Oto oto2 = new Oto();
        Oto oto3 = new Oto();
        ArrayList<VanTai> mangXe = new ArrayList<>();
        mangXe.add(xt1);
        mangXe.add(xt2);
        mangXe.add(xt3);
        mangXe.add(xd1);
        mangXe.add(xd2);
        mangXe.add(xd3);
        mangXe.add(oto1);
        mangXe.add(oto2);
        mangXe.add(oto3);
        for (VanTai vt : mangXe) {
            vt.diChuyen();
        }
    }

}
