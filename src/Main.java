import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        
        System.out.println("Enter the event ID:");
        String eventID = reader.nextLine();

        System.out.println("Enter the event name:");
        String eventName = reader.nextLine();

        System.out.println("Enter the event venue:");
        String eventVenue = reader.nextLine();

        System.out.println("Enter the event date (yyyy-mm-dd):");
        LocalDate eventDate = null;
        while (eventDate == null) {
            String dateInput = reader.nextLine();
            try {
                eventDate = LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-mm-dd:");
            }
        }
        
        Event event = new Event(eventID, eventName, eventVenue, eventDate);

        System.out.println("Enter the number of attendees:");
        int numberOfAttendees = Integer.parseInt(reader.nextLine());
        for (int i = 0; i < numberOfAttendees; i++) {
            System.out.println("Enter the name of attendee " + (i + 1) + ":");
            String attendee = reader.nextLine();
            event.addAttendee(attendee);
        }
        event.organizeEvent();

        System.out.println(event);


        reader.close();
    }
}

