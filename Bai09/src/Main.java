import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap danh sach sinh vien (Go \"END\" o muc ID neu da het danh sach: ");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            while (true) {
                System.out.print("Nhap ID: ");
                String id = scanner.nextLine();
                
                // Điều kiện dừng vòng lặp (equalsIgnoreCase là equals của string không tính đến chữ hoa/thường)
                if (id.equalsIgnoreCase("END")) {
                    break;
                }

                System.out.print("Nhap ten: ");
                String name = scanner.nextLine();

                System.out.print("Nhap GPA: ");
                double gpa = Double.parseDouble(scanner.nextLine()); 
                Student s = new Student(id, name, gpa);
                // Hàm ghi vào file của ObjectOutputStream
                oos.writeObject(s);
            }
            System.out.println("Thanh cong");

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay hoac khong the tao file");
        } catch (IOException e) {
            System.out.println("Loi IO khi tao file: " + e.getMessage());
        }

        System.out.println("Doc danh sach tu tep: ");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            while (true) {
                // readObject() đọc file và trả về một đối tượng là Object --> Phải downcasting xuống để dùng toString()
                Student s = (Student) ois.readObject();
                System.out.println(s.toString());
            }

        } catch (EOFException e) {
            System.out.println("Da doc het");
        } catch (ClassNotFoundException e) {
            // Lỗi này xảy ra khi máy tính đọc được file, nhưng không tìm thấy class Student để đẩy dữ liệu vào (buộc phải catch exception này khi dùng hàm readObject())
            System.out.println("Khong tim thay class Student");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (IOException e) {
            System.out.println("Loi IO khi doc file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}