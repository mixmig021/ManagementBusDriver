package Model;

import java.io.Serializable;

public class Route implements Serializable {

    private int id;
    private int distance;
    private int numBusStops;
    private static  int idAuto = 100;

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", distance=" + distance +
                ", numBusStops=" + numBusStops +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNumBusStops() {
        return numBusStops;
    }

    public void setNumBusStops(int numBusStops) {
        this.numBusStops = numBusStops;
    }

    public static int getIdAuto() {
        return idAuto;
    }

    public static void setIdAuto(int idAuto) {
        Route.idAuto = idAuto;
    }

    public Route(int distance, int numBusStops) {
        this.id=idAuto++;
        this.distance = distance;
        this.numBusStops = numBusStops;
    }
}
