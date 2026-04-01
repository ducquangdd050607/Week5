public class LibraryManagementSystem {
    // Hàm dùng chung để test các chức năng (Do chung interface nên thoải mái xài các phương thức)
    // Dấu "..." sau khi khai báo kiểu dữ liệu cho phép truyền vào mảng bao nhiêu phần tử tùy thích mà không cần phải tự tạo một mảng từ trước --> linh hoạt hơn khi chưa rõ mảng có bao nhiêu phần tử (Java sẽ tự nhận diện và gộp tất cả vào 1 mảng)
    public static void testLibrary(LibraryManager lib, Book... books) {
        for (Book b : books) lib.addBook(b);
        System.out.println("Danh sach ban dau: ");
        lib.printAllBooks();

        System.out.println("Dang tim sach co ID 'B03'...");
        Book found = lib.findBookById("B03");
        System.out.println("Ket qua: " + (found != null ? found.toString() : "Khong tim thay"));

        System.out.println("Dang tim sach co ID 'B09'...");
        found = lib.findBookById("B09");
        System.out.println("Ket qua: " + (found != null ? found.toString() : "Khong tim thay"));

        System.out.println("Dang xoa sach co ID 'B02'...");
        lib.deleteBookById("B02");

        System.out.println("Danh sach sau khi bi xoa: ");
        lib.printAllBooks();
    }

    public static void main(String[] args) {
        // Sinh test chạy thử
        Book b1 = new Book("B03", "Clean Code", "Robert C. Martin", 2008);
        Book b2 = new Book("B01", "Design Patterns", "Gang of Four", 1994);
        Book b3 = new Book("B05", "Effective Java", "Joshua Bloch", 2017);
        Book b4 = new Book("B02", "Goi nho code", "Quang Duong", 2026);
        Book b5 = new Book("B04", "JavaFX in Action", "Someone", 2020);

        // Nhớ downcasting ở đây để lôi hàm override ra xài
        System.out.println("Test ArrayList");
        LibraryManager listLib = new ArrayListLibraryManager();
        testLibrary(listLib, b1, b2, b3, b4, b5);
        System.out.println();

        System.out.println("Test HashMap");
        LibraryManager hashLib = new HashMapLibraryManager();
        testLibrary(hashLib, b1, b2, b3, b4, b5);
        System.out.println();

        System.out.println("Test TreeMap");
        LibraryManager treeLib = new TreeMapLibraryManager();
        testLibrary(treeLib, b1, b2, b3, b4, b5);
    }
}