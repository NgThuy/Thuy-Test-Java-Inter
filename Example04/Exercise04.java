/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author W10-PRO
 */
public class Exercise04 {

    public int randNumber(int min, int max) {
        Random rd = new Random();
        int range = max - min + 1;
        int randomNum = min + rd.nextInt(range);
        return randomNum;
    }

    public void writeFile(String nameFile, Set<Point> list) throws IOException {
        File file = new File(nameFile);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            file.createNewFile();
        }
        for (Point point : list) {
            FileOutputStream fos = new FileOutputStream(nameFile, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(point.x + "," + point.y + "\r\n");
            bw.close();
            fos.close();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Exercise04 main = new Exercise04();
        Set<Point> setAllPoint = new HashSet<Point>();
        Set<Point> setAllPointA = new HashSet<Point>();
        Set<Point> setAllPointB = new HashSet<Point>();
        Set<Point> setAllPointC = new HashSet<Point>();
       
        do {
         //A(800,800)
            if (setAllPointA.size() < 8000) {
                Point A = new Point(800, 800);
                Point rdPointA = new Point(main.randNumber(0, 800), main.randNumber(0, 800));
                double dA = Math.sqrt(Math.pow(rdPointA.x - A.x, 2) + Math.pow(rdPointA.y - A.y, 2));
                if (dA < 400 && !setAllPointA.contains(rdPointA)) {
                    setAllPointA.add(rdPointA);
                    setAllPoint.add(rdPointA);

                }
            }
         //B(4000,800)
            if (setAllPointB.size() < 10000) {
                Point B = new Point(4000, 800);
                Point rdPointB = new Point(main.randNumber(2000, 4000), main.randNumber(0, 800));
                double dB = Math.sqrt(Math.pow(rdPointB.x - B.x, 2) + Math.pow(rdPointV.y - B.y, 2));
                if (dB < 500 && !setAllPointB.contains(rdPointB)) {
                    setAllPointB.add(rdPointB);
                    setAllPoint.add(rdPointB);
                }
            }
        //C(2400,2400)
            if (setAllPointC.size() < 12000) {
                Point C = new Point(2400, 2400);
                Point rdPointC = new Point(main.randNumber(500, 2400), main.randNumber(0, 2400));
                double dC = Math.sqrt(Math.pow(rdPointC.x - C.x, 2) + Math.pow(rdPointC.y - C.y, 2));
                if (dC < 600 && !setAllPointC.contains(rdPointC)) {
                    setAllPointC.add(rdPointC);
                    setAllPoint.add(rdPointC);
                }
            }
        } while (setAllPointA.size() < 8000 || setAllPointB.size() < 10000 || setAllPointC.size() < 12000);

        main.writeFile("output4.txt", setAllPoint);
        System.out.println(setAllPoint.size());
        System.out.println(setAllPointA.size());
        System.out.println(setAllPointB.size());
        System.out.println(setAllPointC.size());
    }

}
