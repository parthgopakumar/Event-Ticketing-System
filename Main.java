import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEVENT TICKETING SYSTEM\n");
            System.out.println("plan all of your events with ease. \n");
            System.out.println("1. Add Event\n");
            System.out.println("2. Issue Ticket\n");
            System.out.println("3. Check-in Ticket\n");
            System.out.println("4. View Event Details\n");
            System.out.println("5. View Ticket Buyers for Event \n");
            System.out.println("6. Exit \n");
            System.out.print("Select an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
                continue;
            }

            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("\n   Enter event name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("\n   Enter total tickets: ");
                    int totalTickets;
                    try {
                        totalTickets = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("   Invalid input. Please enter a number for total tickets.");
                        scanner.next(); 
                        continue;
                    }
                    eventManager.addEvent(eventName, totalTickets);
                    System.out.println("\n   Event added successfully. \n");
                    System.out.println("------------------------------------------------------------------------------------");
                    break;

                case 2:
                    System.out.print("\n   Enter event name: ");
                    eventName = scanner.nextLine();
                    Event event = eventManager.getEvent(eventName);
                    if (event != null) {
                        System.out.print("\n   Enter buyer's name: ");
                        String buyerName = scanner.nextLine();
                        Ticket ticket = new Ticket(buyerName, event);
                        event.addTicket(ticket);
                        System.out.println("\n   Ticket added successfully.\n");
                        System.out.println("------------------------------------------------------------------------------------");
                    } else {
                        System.out.println("\n   Event not found.\n");
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    break;

                case 3:
                    System.out.print("\n   Enter event name: ");
                    eventName = scanner.nextLine();
                    event = eventManager.getEvent(eventName);
                    if (event != null) {
                        System.out.print("\n   Enter buyer's name: ");
                        String buyerName = scanner.nextLine();
                        Ticket ticket = null;
                        for (Ticket t : event.getSoldTickets()) {
                            if (t.getBuyerName().equals(buyerName)) {
                                ticket = t;
                                break;
                            }
                        }
                        if (ticket != null && eventManager.checkInTicket(eventName, ticket)) {
                            System.out.println("\n   Check-in successful.\n");
                            System.out.println("------------------------------------------------------------------------------------");
                        } else {
                            System.out.println("\n   Check-in failed. Ticket may not exist or already checked in.\n");
                            System.out.println("------------------------------------------------------------------------------------");
                        }
                    } else {
                        System.out.println("\n   Event not found. \n");
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    break;

                case 4:
                    System.out.print("\n   Enter event name: ");
                    eventName = scanner.nextLine();
                    event = eventManager.getEvent(eventName);
                    if (event != null) {
                        System.out.println("\n   Event: " + event.getName());
                        System.out.println("\n   Total Tickets: " + event.getTotalTickets());
                        System.out.println("\n   Available Tickets: " + event.getAvailableTickets());
                        System.out.println("------------------------------------------------------------------------------------");
                    } else {
                        System.out.println("\n   Event not found.\n");
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    break;

                case 5:
                System.out.println("\n------------------------------------------------------------------------------------ \n");
                System.out.print("\nEnter event name: ");
                eventName = scanner.nextLine();
                event = eventManager.getEvent(eventName);
                System.out.println("  \n");
                if (event != null) {
                    System.out.println("\nTicket Buyers for Event: \n");
                    
                        for (String buyerName : event.getBuyerNames()) {
                            System.out.println(buyerName);
                        }
                    } else {
                        System.out.println("\nEvent not found.");
                    }
                    break;

                    
                case 6:
                    System.out.println("\n   Exiting system. Goodbye!\n");
                    System.out.println("------------------------------------------------------------------------------------");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("\n   Invalid option. Please try again.\n");
                    System.out.println("------------------------------------------------------------------------------------");
            }
        }
    }
}
