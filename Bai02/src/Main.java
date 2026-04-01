public class Main {
    public static void main(String[] args) {
        // Sinh test kiểm tra lại code
        CustomerQueue supportQueue = new CustomerQueue();
        MessageHistory chatSession = new MessageHistory();

        Customer custA = new Customer("C01", "Nguyen Van A");
        Customer custB = new Customer("C02", "Tran Thi B");

        Ticket ticketA = new Ticket("T01", "Hang bi bop meo, xin doi tra", custA);
        Ticket ticketB = new Ticket("T02", "Cho minh hoi bao gio hang ve?", custB);

        supportQueue.addRequest(ticketA);
        supportQueue.addRequest(ticketB);

        Ticket currentTicket = supportQueue.processNext();
        if (currentTicket != null) {
            chatSession.clearChat();
            chatSession.typeMessage(new Message("M1", "Em chao anh A"));
            chatSession.typeMessage(new Message("M2", "Shop rat xin loi ve viec van chuyen sai cach"));
            // Giả sử sai chính tả
            chatSession.typeMessage(new Message("M3", "Anh gui lai cho shopp nhe"));
            
            // Sửa lại
            chatSession.viewLast();
            chatSession.undo();
            
            chatSession.typeMessage(new Message("M4", "Anh vui long chup anh san pham gui em de em lam thu tuc hoan tien nhe"));
        }

        currentTicket = supportQueue.processNext();
        if (currentTicket != null) {
            chatSession.clearChat();
            chatSession.typeMessage(new Message("M5", "Chao chi B, don hang cua chi dang o kho trung chuyen va se ve trong chieu nay nhe"));
        }

        System.out.println();
        supportQueue.processNext();
    }
}