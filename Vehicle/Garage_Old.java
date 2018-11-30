
/**
 * Write a description of class Garage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Garage_Old
{
    public static void main(String[] args) {
        Vehicle[] garage = {
            new Car(),
            new Car(),
            new Car(),
            new Truck(),
            new Truck(),
            new Truck()
        };
        
        for(Vehicle ride : garage) {
            // ???
            ride.calculateMpg(1,1);
        }
    }
    
    public static int totalDistance(Vehicle[] arr) {
        int sum = 0;
        for(Vehicle ride : arr)
            sum += ride.range();
        return sum;
    }
    
    public static double fillTanks(Vehicle[] arr) {
        double sum = 0.0;
        for(Vehicle ride : arr)
            sum += ride.getGasRemaining();
        return sum;
    }
    
    public static double costFillTanks(Vehicle[] arr) {
        double sum = 0.0;
        for(Vehicle ride : arr)
            sum += ride.getGasCapacity();
        return sum * Vehicle.PRICE_PER_GALLON;
    }
    
    public static int totalPassengers(Vehicle[] arr) {
        int ppl = 0;
        for(Vehicle ride : arr)
            if(ride instanceof Car)
                ppl += ((Car) ride).getPassengers();
        return ppl;
    }
    
    public static double totalCargo(Vehicle[] arr) {
        double cargo = 0.0;
        for(Vehicle ride : arr)
            if(ride instanceof Truck)
                cargo += ((Truck) ride).getCargo();
        return cargo;
    }
}
