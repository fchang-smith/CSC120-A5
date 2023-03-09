import java.util.ArrayList;

public class Car {
    ArrayList<String> passengerList;
    int maxCapacity;

    public Car (int maxPassenger){
        this.maxCapacity = maxPassenger;
        this.passengerList = new ArrayList<String>(maxCapacity);
    }



}