/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author W10-PRO
 */
public class Exercise02 {

    /**
     * Đề bài Cho một văn bản như trong file “input 2.zip”. Hãy đọc file và đếm
     * số lần xuất hiện của từng từ (mỗi từ phân biệt nhau bằng dấu cách) rồi
     * ghi vào file output.txt.
     *
     * @param args the command line arguments
     */
    private void test() throws FileNotFoundException, IOException {
        File file = new File("01.txt");
        Scanner s = new Scanner(file);
        //dùng hashMap để lưu dữ liệu dưới dạng key,value
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (s.hasNextLine()) {
            String next = s.nextLine();
            next = next.replaceAll("[,-\\=?!'/#$%^().;:~&*@+]", "");//xóa các ký tự đặc biệt
            String[] arr = next.split(" ");//cắt chuỗi khi xuất hiện dấu cách
            //Sử dụng foreach để trả về từ khóa và số lần lặp của từ khóa đó.
            for (String x : arr) {
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }
        }
        //ghi ra file output.txt từ khóa và số lần lặp của từ khóa đó
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Ký tự : " + entry.getKey() + " : lặp " + entry.getValue() + " lần");
            String fileName = "output.txt";
            FileOutputStream fos = new FileOutputStream(fileName, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(" " + entry.getKey() + " : " + entry.getValue() + " ");
            bw.close();
            fos.close();
        }
    }

    public static void main(String[] args) {
        Exercise02 main = new Exercise02();
        try {
            main.test();
        } catch (IOException ex) {
            Logger.getLogger(Exercise02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
