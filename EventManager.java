import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
    }

    public void addEvent(String name, int totalTickets) {
        events.add(new Event(name, totalTickets));
    }

    public boolean checkInTicket(String eventName, Ticket ticket) {
        Event event = findEventByName(eventName);
        if (event != null) {
            return event.checkInTicket(ticket);
        }
        return false;
    }

    public Event getEvent(String eventName) {
        return findEventByName(eventName);
    }

    private Event findEventByName(String eventName) {
        for (Event event : events) {
            if (event.getName().equals(eventName)) {
                return event;
            }
        }
        return null;
    }
}
