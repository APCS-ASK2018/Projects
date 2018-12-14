public class Runner
{
    public static void main(String args[])
    {
        CarGarage Garage = new CarGarage("Your Car Garage");
        //addCars
        Garage.addCar(new Ferrari("Enzo",44400,440));
        Garage.addCar(new Volvo("S80",5555,666));
        Garage.addCar(new BMW("X5",110000,180));
        
        System.out.print(Garage);
    }
}