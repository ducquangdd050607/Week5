// Triển khai với ArrayList - O(n)
import java.util.ArrayList;
import java.util.List;

public class ArrayListLibraryManager implements LibraryManager {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book findBookById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        // Không có sách trả về null
        return null;
    }

    @Override
    public boolean deleteBookById(String id) {
        Book b = findBookById(id);
        if (b != null) {
            books.remove(b);
            return true;
        }
        return false;
    }

    @Override
    public void printAllBooks() {
        for (Book b : books) System.out.println(b.toString());
    }
}