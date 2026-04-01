// Lí do ở đây xài interface mà không xài abstract class để khái quát hóa là vì các class con có cùng hành vi nhưng cách triển khai lại khác nhau hết
public interface LibraryManager {
    void addBook(Book book);
    Book findBookById(String id);
    boolean deleteBookById(String id);
    void printAllBooks();
}