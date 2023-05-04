
public class Passenger {
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Board this passenger on car
     * @param c the car to be boarded
     */
    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * The passenger leaves the car
     * @param c the car to leave
     */
    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Get the name of the passenger
     * @return String name of the passenger
     */
    public String getName () {
        return this.name;
    }

    public static void main(String[] args) {
        Car myCar = new Car(3);
        Passenger p1 = new Passenger("p1");

    }
}
