package BusDriverManager;

import Model.Driver;
import Model.DriverManagement;
import Model.Route;


import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Manage{
    private final Scanner sc = new Scanner(System.in);
    private final String flx = "./src/DRIVER.dat";
    private final String ft = "./src/ROUTE.dat";
    private final String fpc = "./src/DRIVERMANAGENMENT.dat";
    private List<Driver> listDriver;
    private List<Route> listRoute;
    private List<DriverManagement> listManagement;

    public void readDriver() {
        File f = new File(flx);
        if (f.exists()) {
            listDriver = ReadandWrite.read(flx);
        } else {
            listDriver = new ArrayList<>();
        }
    }

    public void readRoute() {
        File f = new File(ft);
        if (f.exists()) {
            listRoute = ReadandWrite.read(ft);
        } else {
            listRoute = new ArrayList<>();
        }
    }

    public void readManage() {
        File f = new File(fpc);
        if (f.exists()) {
            listManagement = ReadandWrite.read(fpc);
        } else {
            listManagement = new ArrayList<>();
        }
    }


    public void insertDriver() {
       try {


            System.out.println("Nhap ho ten:");
            String name = sc.nextLine();
            System.out.println("Nhap dia chi:");
            String address = sc.nextLine();
            System.out.println("Nhap so dien thoai");
            String phoneNumber = sc.nextLine();
            System.out.println("Nhap trinh do(Loai A->F)");
            String level = sc.nextLine();

            readDriver();

            if(listDriver.size()>0)
                Driver.setIdAuto(listDriver.get(listDriver.size()-1).getId()+1);

            Driver driver = new Driver(name, address, phoneNumber, level);
            listDriver.add(driver);

            ReadandWrite.write(flx, listDriver);
       } catch (Exception e) {
           System.out.println("Vui long khong de trong");
       }


        for (Driver i : listDriver) {
            System.out.println(i.toString());
        }
    }

    public void insertRoute() {
        try {
            System.out.println("Nhap khoang cach duong:");
            int dis = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap so diem dung trong tuyen:");
            int sbs = Integer.parseInt(sc.nextLine());
            readRoute();
            if(listRoute.size()>0)
                Route.setIdAuto(listRoute.get(listRoute.size()-1).getId()+1);

            Route route = new Route(dis, sbs);
            listRoute.add(route);

            ReadandWrite.write(ft, listRoute);

        } catch (NumberFormatException e) {
            System.out.println("Vui long chi nhap so");
        }

        for (Route i : listRoute) {
            System.out.println(i.toString());
        }
    }

    public Driver getDriverbyID(int ma) {
        readDriver();
        for (Driver i : listDriver)
            if (i.getId() == ma) return i;
        return null;
    }

    public Route getRoutebyID(int ma) {
        readRoute();
        for (Route i : listRoute)
            if (i.getId() == ma) return i;
        return null;
    }

    public boolean match(int idDriver, int idRoute) {
        readManage();
        for (DriverManagement i : listManagement)
            if (i.getDriver().getId() == idDriver && i.getRoute().getId() == idDriver)
                return true;
        return false;
    }

    public int countTurn(int idDriver) {
        readManage();
        int turn = 0;
        for (DriverManagement i : listManagement)
            if (i.getDriver().getId()== idDriver)
                turn += i.getTurn();
        return turn;
    }



    public void insertWork() {
        try {
            System.out.println("Nhap ma Lai Xe:");
            int idDriver = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap ma Tuyen:");
            int idRoute = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap luot:");
            int turn = Integer.parseInt(sc.nextLine());
            if (match(idDriver, idRoute)) {
                System.out.println("Trung mon da day");
                return;
            }
            if (getDriverbyID(idDriver) == null || getRoutebyID(idDriver) == null) {
                System.out.println("Khong tim thay ma lai xe,tuyen da nhhap");
                return;
            }
            if (countTurn(idDriver) + turn > 15) {
                System.out.println("Khong vuot qua 15 luot");
                return;
            }

            readManage();

            DriverManagement dm = new DriverManagement(getDriverbyID(idDriver), getRoutebyID(idRoute), turn);
            listManagement.add(dm);

            ReadandWrite.write(fpc, listManagement);

        } catch (NumberFormatException e) {
            System.out.println("Chi nhap so");
        }

        for (DriverManagement i : listManagement)
            System.out.println(i.toString());
    }


    public void sortDriverbyName() {
        readManage();
        listManagement.sort((o1, o2) -> {
            String[] name1 = o1.getDriver().getName().split("\\s+");
            String[] name2 = o2.getDriver().getName().split("\\s+");
            if (name1[name1.length - 1].equalsIgnoreCase(name2[name2.length - 1])) {
                return o1.getDriver().getName().compareToIgnoreCase(o2.getDriver().getName());
            } else {
                return name1[name1.length - 1].compareToIgnoreCase(name2[name2.length - 1]);
            }
        });
        for (DriverManagement i : listManagement)
            System.out.println(i.toString());
    }


    public void sapXepLuot() {
        readRoute();
        listManagement.sort(Comparator.comparingInt(DriverManagement::getTurn));
        for (DriverManagement i : listManagement)
            System.out.println(i.toString());
    }

    public void thongKeKhoangCachChayXe() {
        readManage();
        Map<String, Integer> o = listManagement.stream().collect(Collectors.
                groupingBy(DriverManagement::getDriverinf, Collectors.summingInt(DriverManagement::getDistanceofBus)));
        System.out.println("Ma lai xe-Lai xe\tTong so khoang cach");
        o.forEach((K, V) -> System.out.println(K + "\t" + V));
    }
}