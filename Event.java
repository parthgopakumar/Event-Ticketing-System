import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private int totalTickets;
    private List<Ticket> soldTickets;

    public Event(String name, int totalTickets) {
        this.name = name;
        this.totalTickets = totalTickets;
        this.soldTickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getAvailableTickets() {
        return totalTickets - soldTickets.size();
    }

    public List<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public void addTicket(Ticket ticket) {
        if (getAvailableTickets() > 0) {
            soldTickets.add(ticket);
        }
    }

    public boolean checkInTicket(Ticket ticket) {
        if (soldTickets.contains(ticket) && !ticket.isCheckedIn()) {
            ticket.setCheckedIn(true);
            return true;
        }
        return false;
    }

    public List<String> getBuyerNames() {
        List<String> buyerNames = new ArrayList<>();
        for (Ticket ticket : soldTickets) {
            buyerNames.add(ticket.getBuyerName());
        }
        return buyerNames;
    }
}
