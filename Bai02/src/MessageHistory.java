import java.util.Stack;

public class MessageHistory {
    // Sử dụng Stack ở đây
    private Stack<Message> stack = new Stack<>();

    // Gõ tin nhắn mới
    public void typeMessage(Message msg) {
        stack.push(msg);
        System.out.println(msg.getContent());
    }

    // Tính năng Undo
    public void undo() {
        // Kiểm tra có tin nhắn để undo không trước
        if (!stack.isEmpty()) {
            Message removedMsg = stack.pop();
            System.out.println("Da thu hoi tin nhan: \"" + removedMsg.getContent() + "\"");
        } else {
            System.out.println("Khong co tin nhan de xoa");
        }
    }

    // Tính năng viewLast
    public void viewLast() {
        if (!stack.isEmpty()) {
            System.out.println("Dong vua go la: \"" + stack.peek().getContent() + "\"");
        }
    }

    // Xóa trắng khung chat để chuẩn bị tiếp khách mới
    public void clearChat() {
        stack.clear();
    }
}
