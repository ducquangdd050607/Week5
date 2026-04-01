// Exception tự định nghĩa
public class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        // Truyền câu thông báo lỗi lên cho class cha xử lý
        super(message);
    }
}