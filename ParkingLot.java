import java.util.ArrayList;
import java.util.Scanner;
// ParkingLot class that manages multiple parkings
class ParkingLot {
ArrayList<Vehicle> parkedCars;
private int capacity = 2;
private int numOfCars = 0;

public ParkingLot() {
parkedCars = new ArrayList<Vehicle>();
}

// Add the car to the parking lot
public void checkIn(Vehicle car) {
if (numOfCars >= capacity) {
System.out.println("Sorry, parking lot is full!");
return;
}
Scanner input = new Scanner(System.in);
System.out.println("Please enter the check-in time and date (mm/dd/yyyy hh:mm:ss):");
String checkInTime = input.nextLine();

numOfCars++;
parkedCars.add(car);
System.out.println("Car parked successfully!");
System.out.println("Parking check in time:"+checkInTime);
}

// Remove the car from the parking lot and calculate the cost
public void checkOut(Vehicle car) {
car.checkOut();
parkedCars.remove(car);
numOfCars--;
}

// Show the capacity and number of parked cars
public void showAvailability() {
System.out.println("Capacity: " + capacity);
System.out.println("Number of parked cars: " + numOfCars);
}
}