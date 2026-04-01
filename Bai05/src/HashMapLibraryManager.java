// Triển khai với HashMap - O(1)
import java.util.HashMap;
import java.util.Map;

public class HashMapLibraryManager implements LibraryManager {
    private Map<String, Book> bookMap = new HashMap<>();

    @Override
    public void addBook(Book book) {
        bookMap.put(book.getId(), book);
    }

    @Override
    public Book findBookById(String id) {
        return bookMap.get(id);
    }

    @Override
    public boolean deleteBookById(String id) {
        // Nếu remove được id có sẵn thì ok, không sẽ trả về null nên mới có dòng code dưới
        return bookMap.remove(id) != null;
    }

    @Override
    public void printAllBooks() {
        for (Book b : bookMap.values()) System.out.println(b.toString());
    }
}