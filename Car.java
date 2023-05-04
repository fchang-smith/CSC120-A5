import java.util.ArrayList;

public class Car {
    ArrayList<Passenger> passengerList;
    int maxCapacity;

    public Car (int maxPassenger){
        this.maxCapacity = maxPassenger;
        this.passengerList = new ArrayList<Passenger>(maxCapacity);
    }

    public int getCapacity() {
        return this.maxCapacity;
    }

    public int seatsRemaining() {
        int seatTaken = this.passengerList.size();
        return this.maxCapacity - seatTaken;
    }

    public void addPassenger(Passenger p) {
        int seatRemain = this.seatsRemaining();
        if (seatRemain >= 1) {
            this.passengerList.add(p);
        } else {
            throw new RuntimeException("The car is at its max capacity!");
        }
    }

    public void removePassenger(Passenger p) {
        if (this.passengerList.contains(p)) {
            this.passengerList.remove(p);
        } else {
            throw new RuntimeException("There is no passenger " + p + " in the car");
        }
    }

    public void printManifest() {
        if (this.passengerList.isEmpty()) {
            System.out.println("This car is EMPTY. ");
        } else {
            for (Passenger p : this.passengerList) {
                System.out.println(this.passengerList.indexOf(p) + ": " + p);
            }
        }
    }

    public static void main(String[] args) {
        
    }

}