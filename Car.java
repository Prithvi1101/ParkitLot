
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// Car Class that implements Vehicle
class Car implements Vehicle {
private int rate = 50; 
private int cost;
private String plateNumber;

public Car(String plateNumber) {
this.plateNumber = plateNumber;
}

@Override
public String getPlateNumber() {
return plateNumber;
}

// Calculate the cost based on the hours parked
private void calculateCost() {
cost = rate;
}

// Display the cost and check-out message
@Override
public void checkOut() {
calculateCost();
System.out.println("Your total cost is: Tk." + cost);
System.out.println("Thank you for visiting!");
}

// Get the check-in time and date, and set the plate number
@Override
public void checkIn() {
Scanner input = new Scanner(System.in);
System.out.println("Please enter the check-in time and date (mm/dd/yyyy hh:mm:ss):");
String checkInTime = input.nextLine();
System.out.println("Please enter the plate number:");
this.plateNumber = input.nextLine();
System.out.println("You have checked in at " + checkInTime);

try {
FileWriter myWriter = new FileWriter("checkIn.txt", true);
myWriter.write(checkInTime + " " + this.plateNumber + "\n");
myWriter.close();
} catch (IOException e) {
System.out.println("An error occurred");
}
}
}