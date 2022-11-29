package org.example.TicketSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketSearchTest {

    Ticket ticket1 = new Ticket(1,2000,"SVO","LED",120);
    Ticket ticket2 = new Ticket(2,2100,"DME","RHV",150);
    Ticket ticket3 = new Ticket(3,2200,"VKO","KLF",45);
    Ticket ticket4 = new Ticket(4,2300,"VKO","AER",160);
    Ticket ticket5 = new Ticket(5,2700,"VKO","LED",150);
    Ticket ticket6 = new Ticket(6,2600,"VKO","LED",170);
    Ticket ticket7 = new Ticket(7,2500,"VKO","LED",175);
    Ticket ticket8 = new Ticket(8,2400,"VKO","LED",175);


    @Test
    public void addTickets() {
        Repository repo = new Repository();
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        Repository repo = new Repository();
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.removeById(6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTicket() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.addTicket(ticket7);
        repo.addTicket(ticket8);
        Ticket[] expected = {ticket8, ticket7, ticket6, ticket5};
        Ticket[] actual = manager.findTicket("VKO", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }
}
