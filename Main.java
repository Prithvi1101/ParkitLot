import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Scanner input = new Scanner(System.in);
        String plateNumber;

        while (true) {
            System.out.print("Hello, Welcome to the Parking Lot! Please choose the following options for further choices\n");
            System.out.println("Enter C for check-in, O for check-out, A for available slots and Q for quit:\n");
            String option = input.nextLine();

            if (option.equalsIgnoreCase("C")) {
                System.out.println("Enter plate number:");
                plateNumber = input.nextLine();
                Car car = new Car(plateNumber);
                parkingLot.checkIn(car);
            } else if (option.equalsIgnoreCase("O")) {
                System.out.println("Enter plate number:");
                plateNumber = input.nextLine();

                for (Vehicle car : parkingLot.parkedCars) {
                    if (car.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                        writeToFile(car.getPlateNumber());
                        parkingLot.checkOut(car);
                        break;
                    }  
                 else{
                System.out.println("Invalid Plate Number! Please try again, Thank you!");
                break;
            }
                }
            } else if (option.equalsIgnoreCase("Q")) {
                break;
            }
            else if (option.equalsIgnoreCase("A")) {
                parkingLot.showAvailability();
            }
            else {
                System.out.println("Invalid option! Please try again.");
            }
        }
    }

    public static void writeToFile(String plateNumber) {
        try( FileWriter myWriter = new FileWriter("checkOut.txt", true)){
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the check-out time and date (mm/dd/yyyy hh:mm:ss):");
            String checkOutTime = input.nextLine();
            myWriter.write(checkOutTime + " " + plateNumber + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}