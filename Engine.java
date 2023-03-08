public class Engine {

    private FuelType fuelType;
    private double currentFuel;
    private double maxFuel;

    public Engine (FuelType f, double max){
        fuelType = f;
        maxFuel = max;
        currentFuel = maxFuel;
    }

    public void refuel () {
        currentFuel = maxFuel;
    }

    public void go () {
        this.currentFuel -= 60;
        this.checkFuel();
        System.out.println("The engine is working! The current fuel level is: " + this.currentFuel);       
    }

    public void checkFuel () {
        if (this.currentFuel < 0) {
            throw new RuntimeException("Out of fuel!");
        }
    }

    public double getCurrentFuel() {
        return currentFuel;
    }
    public double getMaxFuel() {
        return maxFuel;
    }








}