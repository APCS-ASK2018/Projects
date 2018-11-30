public class Garage
{
    public static void main(String[] args)
    {
        Car plainCar = new Car();
        Car redCar = new Car("VW", "Red", 2012);
        Car blueCar = new Car("Thunderbird", "Blue", 2007, 100000, 18, 2);
        
        Vehicle plainTruck = new Truck();
        Vehicle yellowTruck = new Truck("Mack", "Yellow", 2005);
        Vehicle orangeTruck = new Truck("Peterbuilt", "Orange", 2010, 98765, 200, 100000);
       
        Vehicle[] myVehicles = { plainCar, redCar, blueCar, plainTruck, yellowTruck, orangeTruck };
        
        System.out.println("My Vehicles...");
        for (Vehicle v : myVehicles)
        {
            System.out.println(v.toString());
        }
        
        //calculate MPG
        plainCar.calculateMpg(250, 10);
        redCar.calculateMpg(300, 10);
        blueCar.calculateMpg(200, 10);
        plainTruck.calculateMpg(500, 100);
        yellowTruck.calculateMpg(650, 100);
        orangeTruck.calculateMpg(400, 100);
        
        System.out.println();
        // test methods
        System.out.println("Some basic information about a vehicle...");
        System.out.println("5 gallons added to "+redCar.getModel()+"? " + redCar.addGas(5));
        System.out.println("20 gallons added to "+redCar.getModel()+"? " + redCar.addGas(20));
        double gallons = redCar.fillTank(); //fillTank();
        System.out.println("Price to fill "+redCar.getModel()+": $" + gallons * Vehicle.PRICE_PER_GALLON);
        System.out.println("With a full tank the " +redCar.getModel()+" can drive " + redCar.range() + " miles");
        gallons = redCar.drive(345);
        System.out.println("It will use "+gallons+ " gallons to drive 345 miles");
        System.out.println(redCar.getModel() +" Odometer: " + redCar.getOdometer());
        
        System.out.println();
        // Working with the array of Vehicles
        System.out.println("Some information about all my Vehicles...");
        System.out.println("The total number of passengers the cars can carry is " +
                totalPassengers(myVehicles));
        System.out.println("The total amount of cargo the trucks can carry is " +
                totalCargo(myVehicles) + " pounds.");
        System.out.println("The total amount of gas needed to fill all the vehicles is " +
                fillTanks(myVehicles) + " gallons.");
        System.out.println("If the vehicles were empty, the total cost to fill all of them would be $" +
               costFillTanks(myVehicles));
        System.out.println("The total distance all the vehicles could travel is " +
                totalDistance(myVehicles) + " miles.");
                
        System.out.println();
        System.out.println("Testing the Interfaces...");
        System.out.println("The "+redCar.getModel() + " is " + redCar.compareTo(blueCar) + " years newer than the "+ blueCar.getModel());
        System.out.println("The safety rating of the " + plainCar.getModel() + " is "  +plainCar.calculateSafety());
        System.out.println("The safety rating of the " + redCar.getModel() + " is "  +redCar.calculateSafety());
        System.out.println("The safety rating of the " + blueCar.getModel() + " is "  +blueCar.calculateSafety());
    }
    
    //total distance all the vehicles could travel.
    public static int totalDistance(Vehicle[] arr) {
        int sum = 0;
        for(Vehicle ride : arr)
            sum += ride.range();
        return sum;
    }
  
    //total amount of fuel it would take to fill all the vehicles at the current tank levels.
    public static double fillTanks(Vehicle[] arr) {
        double sum = 0.0;
        for(Vehicle ride : arr)
            sum += ride.getGasRemaining();
        return sum;
    }
    
    // cost of all fuel needed to fill all the vehicles if all the tanks were empty.
    public static double costFillTanks(Vehicle[] arr) {
        double sum = 0.0;
        for(Vehicle ride : arr)
            sum += ride.getGasCapacity();
        return sum * Vehicle.PRICE_PER_GALLON;
    }

    //total passengers all the cars could carry.
    // need to use boolean instanceOf: if (obj instanceOf Object)
    public static int totalPassengers(Vehicle[] arr) {
        int ppl = 0;
        for(Vehicle ride : arr)
            if(ride instanceof Car)
                ppl += ((Car) ride).getPassengers();
        return ppl;
    }
    
    //total cargo all the trucks could carry.
    public static double totalCargo(Vehicle[] arr) {
        double cargo = 0.0;
        for(Vehicle ride : arr)
            if(ride instanceof Truck)
                cargo += ((Truck) ride).getCargo();
        return cargo;
    }
}

/*
My Vehicles...
2017 Car White
2012 VW Red
2007 Thunderbird Blue
2016 Truck Black
2005 Mack Yellow
2010 Peterbuilt Orange

Some basic information about a vehicle...
5 gallons added to VW? true
20 gallons added to VW? false
Price to fill VW: $13.37
With a full tank the VW can drive 360.0 miles
It will use 11.5 gallons to drive 345 miles
VW Odometer: 345

Some information about all my Vehicles...
The total number of passengers the cars can carry is 11
The total amount of cargo the trucks can carry is 277000.0 pounds.
- The total amount of gas needed to fill all the vehicles is 586.0 gallons.
If the vehicles were empty, the total cost to fill all of them would be $1142.18
- The total distance all the vehicles could travel is 3945 miles.

Testing the Interfaces...
The VW is 5 years newer than the Thunderbird
The safety rating of the Car is 20
The safety rating of the VW is 15
The safety rating of the Thunderbird is 0
*/


