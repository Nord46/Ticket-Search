package org.example.TicketSearch;
public class Repository {

    protected Ticket[] tickets = new Ticket[0];

    public void addTicket(Ticket product) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = product;
        tickets = tmp;
    }

    public Ticket[] findAll() {

        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket product : tickets) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {

        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets){
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }
}