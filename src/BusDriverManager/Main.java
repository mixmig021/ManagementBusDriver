package BusDriverManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manage manage = new Manage();
        boolean check = true;
        while (check) {
            while (check) {
                System.out.println("0:Thoát");
                System.out.println("1:Nhap lai xe moi.In ra danh sach lai xe");
                System.out.println("2:Nhap danh sach tuyen moi.In ra danh sach tuyen");
                System.out.println("3:Nhap Bang phan cong tai xe xe Bus");
                System.out.println("4:Sap xep theo ten lai xe");
                System.out.println("5:Sap xep theo luot dam nhan theo ngay");
                System.out.println("6:Tinh thong ke khoang cach chay xe cua moi lai xe");
                System.out.println("---------------------------------------------------");
                int chon;
                Scanner in = new Scanner(System.in);
                chon = Integer.parseInt(in.nextLine());
                switch (chon) {
                    case 0:
                        check = false;
                        break;
                    case 1:
                        manage.insertDriver();
                        break;
                    case 2:
                        manage.insertRoute();
                        break;
                    case 3:
                        manage.insertWork();
                        break;
                    case 4:
                        manage.sortDriverbyName();
                        break;
                    case 5:
                        manage.sapXepLuot();
                        break;
                    case 6:
                        manage.thongKeKhoangCachChayXe();
                        break;
                    default:
                        System.out.println("chi chon 0->6");
                        break;

                }
            }
        }
    }
}