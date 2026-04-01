import java.time.LocalDateTime;
public class Ticket {
    private String id;
    private String content;
    private LocalDateTime timestamp;
    private Customer customer;

    public Ticket(String id, String content, Customer customer) {
        this.id = id;
        this.content = content;
        this.customer = customer;
        this.timestamp = LocalDateTime.now();
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public String getContent() {
        return this.content;
    }
}
