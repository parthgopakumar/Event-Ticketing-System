public class Ticket {
    private String buyerName;
    private Event event;
    private boolean checkedIn;

    public Ticket(String buyerName, Event event) {
        this.buyerName = buyerName;
        this.event = event;
        this.checkedIn = false;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public Event getEvent() {
        return event;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
}
