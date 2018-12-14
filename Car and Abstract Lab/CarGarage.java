import java.util.*;
public class CarGarage
{
    private ArrayList<Car> Garage;
    private String name;
    public CarGarage(String name)
    {
        Garage = new ArrayList<Car>();
        this.name = name;
    }
    //write you method(s) to add a car.
    public void addCar(Car c)
    {Garage.add(c);}
    
    public Car getCar(int i) {return Garage.get(i);}
    
    //toString method
    @Override
    public String toString() {
        return "Garage " + name + ": " + Garage;
    }
}