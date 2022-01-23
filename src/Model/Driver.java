package Model;

import java.io.Serializable;

public class Driver implements Serializable {
    private int id;
    private String name,address;
    private String numberPhone;
    private String level;
    private static int idAuto = 10000;

    public Driver( String name, String address, String numberPhone, String level) {
        this.id =idAuto++;
        this.name = name;
        this.address = address;
        this.numberPhone = numberPhone;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Driver:" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", level='" + level + '\'';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static int getIdAuto() {
        return idAuto;
    }

    public static void setIdAuto(int idAuto) {
        Driver.idAuto = idAuto;
    }



}
