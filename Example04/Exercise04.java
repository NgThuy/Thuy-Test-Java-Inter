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

    public int rand(int min, int max) {
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
        Set<Point> setPointA = new HashSet<Point>();
        Set<Point> setPointB = new HashSet<Point>();
        Set<Point> setPointC = new HashSet<Point>();
        //A(800,800)
        do {
            Point A = new Point(800, 800);
            Point rdPointA = new Point(main.rand(0, 800), main.rand(0, 800));
            double d1 = Math.sqrt(Math.pow(rdPointA.x - A.x, 2) + Math.pow(rdPointA.y - A.y, 2));
            if (d1 < 400 && !setPointA.contains(rdPointA)) {
                setPointA.add(rdPointA);
                setAllPoint.add(rdPointA);
            }
        } while (setPointA.size() < 8000);
        //B(2400,800)
        do {
            Point B = new Point(4000, 800);
            Point rdPointB = new Point(main.rand(2000, 4000), main.rand(0, 800));
            double d2 = Math.sqrt(Math.pow(rdPointB.x - B.x, 2) + Math.pow(rdPointB.y - B.y, 2));
            if (d2 < 500 && !setPointB.contains(rdPointB)) {
                setPointA.add(rdPointB);
                setAllPoint.add(rdPointB);
            }
        } while (setPointA.size() < 10000);
        //C(2400,2400)
        do {
            Point C = new Point(2400, 2400);
            Point rdPointC = new Point(main.rand(500, 2400), main.rand(0, 2400));
            double d3 = Math.sqrt(Math.pow(rdPointC.x - C.x, 2) + Math.pow(rdPointC.y - C.y, 2));
            if (d3 < 600 && !setPointC.contains(rdPointC)) {
                setPointC.add(rdPointC);
                setAllPoint.add(rdPointC);
            }
        } while (setPointC.size() < 12000);

        main.writeFile("output4.txt", setAllPoint);
        System.out.println(setAllPoint.size());
        System.out.println(setPointA.size());
        System.out.println(setPointB.size());
        System.out.println(setPointC.size());
    }

}
