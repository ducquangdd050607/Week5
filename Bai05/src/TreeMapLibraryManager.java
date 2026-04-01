// Triển khai với TreeMap - Cách hoạt động giống như cây nhị phấn (hiểu như binary search vậy) - O(log n)
import java.util.Map;
import java.util.TreeMap;

public class TreeMapLibraryManager implements LibraryManager {
    private Map<String, Book> bookTree = new TreeMap<>();

    @Override
    public void addBook(Book book) {
        bookTree.put(book.getId(), book);
    }

    @Override
    public Book findBookById(String id) {
        return bookTree.get(id);
    }

    @Override
    public boolean deleteBookById(String id) {
        return bookTree.remove(id) != null;
    }

    @Override
    public void printAllBooks() {
        for (Book b : bookTree.values()) System.out.println(b.toString());
    }
}