import java.util.ArrayList;

public class Train {
    private final Engine engine;
    private ArrayList<Car> carArrayList;
    
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity);
        this.carArrayList = new ArrayList<Car>(nCars);
        for (int i=0; i<nCars; i++) {
            this.carArrayList.add(new Car(passengerCapacity));
        }
    }

    /**
     * Accessor to get engine
     * @return Engine engine
     */
    public Engine getEngine() {
        return this.engine;
    }

    /**
     * get the car at index of i
     * @return return the ith car
     */
    public Car getCar(int i) {
        if (i >= 0 && i < this.carArrayList.size()) {
            return this.carArrayList.get(i);
        } else {
            throw new RuntimeException("There is no car at index of " + i);
        }
    }

    /**
     * Get max capacity across all cars
     * @return the maximum total capacity across all Cars
     */
    public int getMaxCapacity() {
        int maxCapacity = 0;
        for (Car car : this.carArrayList) {
            maxCapacity += car.getCapacity();
        }
        return maxCapacity;
    }

    /**
     * Get seats remaining 
     * @return the number of remaining open seats across all Cars
     */
    public int seatsRemaining() {
        int seatRemaining = 0;
        for (Car car : this.carArrayList) {
            seatRemaining += car.seatsRemaining();
        }
        return seatRemaining;
    }

    /**
     * print cars and passengers in this train
     */
    public void printManifest() {
        for (Car car: this.carArrayList) {
            int idx = this.carArrayList.indexOf(car);
            int carNum = idx +1;
            System.out.println("Car " + carNum + ":");
            car.printManifest();
        }
    }

    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 100, 2, 5);
        Car car1 = myTrain.getCar(0);
        Passenger p1 = new Passenger("p1");
        p1.boardCar(car1);
        try {
            System.out.println(myTrain.getMaxCapacity());
            System.out.println(myTrain.seatsRemaining());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        myTrain.printManifest();

    }
}
