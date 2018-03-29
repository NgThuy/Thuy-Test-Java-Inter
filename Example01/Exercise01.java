/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example01;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author W10-PRO
 */
public class Exercise01 {

    /**
     * Đề bài Sử dụng Set trong collection để tìm tập giao và tập hợp giữa 2 tập
     * hợp (tự tạo ra 2 tập hợp, mỗi tập hợp 20.000.000 một số Integer ngẫu
     * nhiên, không giống nhau. 2 tập hợp phải có trên 5% số phần tử giao nhau).
     * Hãy tính tổng thời gian thực hiện tìm cả tập giao và tập hợp và tìm cách
     * tối ưu nhất để thời gian tính toán này nhỏ nhất có thể.
     *
     * @param args the command line arguments
     */
    //Tạo mới 2 HashSet kiểu Integer để chứa các số (lí do sử dụng TreeSet vì TreeSet có thể lưu dữ liệu lớn, có sắp xếp và không chấp nhận phần tử trùng lặp)
    TreeSet<Integer> ts1 = new TreeSet<>();
    TreeSet<Integer> ts2 = new TreeSet<>();
    //Tạo random để random ngẫu nhiên các phần tử của 2 tập hợp số ts1 và ts2
    Random rd = new Random();

    //Viết phương thức creat để tạo ra hai tập hợp số
    private void create() {
        for (int i = 0; i < 20000000; i++) {
            ts1.add(rd.nextInt(20000000));
            ts2.add(rd.nextInt(30000000));
        }
        System.out.println("Tập hợp 20.000.000 số của tập hợp số 1 :" + ts1 + "\n");
        System.out.println("Tập hợp 20.000.000 số của tập hợp số 2 :" + ts2 + "\n");
    }
//Viết phương thức test để tìm ra tập hợp, tập giao của hai tập số
    private void test() {
        //Kiểm tra xem tập hợp số thứ 2 có là tập con của tập số thứ 1 hay không ?
        if (ts1.containsAll(ts2)) {
            System.out.println("Là tập con\n");
        } else {
            System.out.println("Không là tập con\n");
        }
        //dùng addAll để đẩy tất cả các phần tử số của tập hợp số ts02 vào tập hợp số ts01
        ts1.addAll(ts2);
        //in tập hợp số của cả 2 phần tử ra màn console
        System.out.println("Tập hợp phần tử của ts1 và ts2 : " + ts1 + "\n");
        //Dùng retainAll để tìm ra các phần tử có chung của cả 2 tập hợp số
        ts1.retainAll(ts2);
        //In các phần tử trùng lặp của cả 2 tập hợp ra màn console
        System.out.println("Phần tử chung (tập giao) của ts1 và ts2 : " + ts1 + "\n");
    }
//Viết phương thức tính thời gian tìm tập hợp, tập giao của hai tập số
    private void runTime() {
        //Lấy thời gian chạy chương trình.
        long start, end;
        start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
        for (long i = 0; i < 100000000; i++);    //vòng lặp không thực hiện thêm lệnh nào
        end = System.currentTimeMillis();   // start lấy thời gian theo millisecond
        System.out.println("Thời gian chạy lấy theo millisecond: " + (end - start) + " millisecond");
    }

    public static void main(String[] args) {
        Exercise01 m = new Exercise01();
        m.create();
        m.test();
        m.runTime();
    }

}
