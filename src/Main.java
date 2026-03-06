
abstract class Room {
    protected String roomType;
    protected int beds;
    protected int size;
    protected double price;

    public Room(String roomType, int beds, int size, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq ft");
        System.out.println("Price per night: ₹" + price);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 200, 2500);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 350, 4000);
    }
}

// Suite Room class
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 600, 7500);
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay - Hotel Booking System");
        System.out.println("Application Version: v2.1\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailability = 10;
        int doubleAvailability = 7;
        int suiteAvailability = 3;

        System.out.println("----- Room Details -----\n");

        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailability + "\n");

        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailability + "\n");

        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailability + "\n");

        System.out.println("Thank you for using Book My Stay!");
    }
}