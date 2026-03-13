import java.util.HashMap;
import java.util.Map;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

class InvalidBookingValidator {

    public static void validate(String roomType, int roomsRequested, Map<String, Integer> inventory)
            throws InvalidBookingException {

        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        if (roomsRequested <= 0) {
            throw new InvalidBookingException("Number of rooms must be greater than zero.");
        }

        if (inventory.get(roomType) < roomsRequested) {
            throw new InvalidBookingException("Not enough rooms available.");
        }
    }
}
class BookingService {

    private Map<String, Integer> inventory = new HashMap<>();

    public BookingService() {
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    public void bookRoom(String roomType, int roomsRequested) {
        try {

            InvalidBookingValidator.validate(roomType, roomsRequested, inventory);

            int remaining = inventory.get(roomType) - roomsRequested;
            inventory.put(roomType, remaining);

            System.out.println("Booking successful!");
            System.out.println("Remaining " + roomType + " rooms: " + remaining);

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");
        for (String room : inventory.keySet()) {
            System.out.println(room + " : " + inventory.get(room));
        }
    }
}

public class Main {
    public static void main(String[] args) {

        BookingService bookingService = new BookingService();

        bookingService.displayInventory();

        bookingService.bookRoom("Single", 2);

        bookingService.bookRoom("Deluxe", 1);

        bookingService.bookRoom("Double", -1);

        bookingService.bookRoom("Suite", 5);

        bookingService.displayInventory();
    }
}