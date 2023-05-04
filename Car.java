import java.util.ArrayList;

public class Car {
    private ArrayList<Passenger> passengerList;
    private int maxCapacity;

    public Car (int maxPassenger){
        this.maxCapacity = maxPassenger;
        this.passengerList = new ArrayList<Passenger>(maxCapacity);
    }

    /**
     * An accessor to get max capacity of the Car
     * @return an int representing the max capacity
     */
    public int getCapacity() {
        return this.maxCapacity;
    }

    /**
     * Get the number of remaining seats
     * @return an int representing the number of remaining seats
     */
    public int seatsRemaining() {
        int seatTaken = this.passengerList.size();
        return this.maxCapacity - seatTaken;
    }

    /**
     * Add Passenger p to the car's aboarding arrayList
     * @param p instance of Passenger class that aboards car
     */
    public void addPassenger(Passenger p) {
        int seatRemain = this.seatsRemaining();
        if (this.passengerList.contains(p)) {
            throw new RuntimeException("The passenger" + p.getName() + "is already aboard!");
        }
        if (seatRemain >= 1) {
            this.passengerList.add(p);
        } else {
            throw new RuntimeException("The car is at its max capacity!");
        }
    }

    /**
     * Delete Passenger p from the car's aboarding arrayList
     * @param p instance of Passenger class that leaves the car
     */
    public void removePassenger(Passenger p) {
        if (this.passengerList.contains(p)) {
            this.passengerList.remove(p);
        } else {
            throw new RuntimeException("There is no passenger " + p + " in the car");
        }
    }
    
    /**
     * print out the list of passenger
     */
    public void printManifest() {
        if (this.passengerList.isEmpty()) {
            System.out.println("This car is EMPTY. ");
        } else {
            for (Passenger p : this.passengerList) {
                int idx = this.passengerList.indexOf(p);
                int passengerNum = idx +1;
                System.out.println("Passenger" + passengerNum + ": " + p.getName());
            }
        }
    }

    public static void main(String[] args) {
        Passenger p1 = new Passenger("p1");
        Passenger p2 = new Passenger("p2");
        Car myCar = new Car(1);
        System.out.println(myCar.getCapacity());
        System.out.println(myCar.seatsRemaining());
        myCar.addPassenger(p1);
        //myCar.addPassenger(p2);
        System.out.println(myCar.getCapacity());
        System.out.println(myCar.seatsRemaining());
        myCar.printManifest();
    }

}