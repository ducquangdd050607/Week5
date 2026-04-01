import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    // Sử dụng LinkedList ở đây
    private Queue<Ticket> queue = new LinkedList<>();

    // Thêm khách hàng vào hàng đợi
    public void addRequest(Ticket ticket) {
        queue.offer(ticket);
        System.out.println("Da them yeu cau tu khach:  " + ticket.getCustomer().getName() + " || Noi dung: " + ticket.getContent());
    }

    // Lấy khách hàng ra để xử lý
    public Ticket processNext() {
        if (queue.isEmpty()) {
            System.out.println("Da xu ly tat ca yeu cau");
            return null;
        }
        Ticket ticket = queue.poll();
        System.out.println("\nDang xu li yeu cau cua: " + ticket.getCustomer().getName());
        return ticket;
    }
}
