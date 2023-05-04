

public class Engine {
    private FuelType fuelType;
    private double currentFuel;
    private double maxFuel;

    public Engine (FuelType f, double max){
        this.fuelType = f;
        this.maxFuel = max;
        this.currentFuel = maxFuel;
    }

    /**
     * Refill currentFuel to the maxFuel
     */
    public void refuel () {
        this.currentFuel = this.maxFuel;
    }

    /**
     * Acticate the engine and reduce 60 units of fuel
     */
    public void go () {
        this.currentFuel -= 60;
        this.checkFuel();
        System.out.println("The engine is working! The current fuel level is: " + this.currentFuel);       
    }

    /**
     * Reture true is the currentFuel is greater than 0. Else return false
     */
    public void checkFuel () {
        if (this.currentFuel < 0) {
            throw new RuntimeException("Out of fuel!");
        }
    }

    /**
     * Accessor to get currentFuel
     * @return double currentFuel
     */
    public double getCurrentFuel() {
        return this.currentFuel;
    }

    /**
     * Accessor to get maxFuel
     * @return double maxFuel
     */
    public double getMaxFuel() {
        return this.maxFuel;
    }

    /**
     * Accessor to get fuelType
     * @return FuelType fuelType
     */
    public FuelType getFuelType() {
        return this.fuelType;
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }






}