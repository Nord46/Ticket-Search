package org.example.TicketSearch;
import java.util.Arrays;

public class Manager {
    protected Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public Ticket[] findTicket(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            Ticket[] tmp = new Ticket[result.length + 1];
            if (matches(ticket, from, to)) {
                for (int i  = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (!ticket.getFrom().equals(from)) {
            return false;
        }
        if (!ticket.getTo().equals(to)) {
            return  false;
        }
        return true;
    }
}