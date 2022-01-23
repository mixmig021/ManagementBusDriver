package Model;

import java.io.Serializable;

public class DriverManagement implements Serializable {

    private Driver driver;
    private  Route route;
    private  int turn;

    public DriverManagement(Driver driver, Route route, int turn) {
        this.driver = driver;
        this.route = route;
        this.turn = turn;
    }

    public  String getDriverinf(){
        return driver.getId()+ "\t" + driver.getName();
    }

    public int getDistanceofBus(){
        return route.getDistance()*turn;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }


    @Override
    public String toString() {
        return "DriverManagement: " +
                "driver=" + driver +
                ", route=" + route +
                ", turn=" + turn +
                '.';
    }



}
