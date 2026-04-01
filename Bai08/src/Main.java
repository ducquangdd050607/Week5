import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = scanner.nextInt();

        // Sau try có thể xài luôn resources như trong (), java sẽ tự động close resources khi kết thúc try-catch
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("numbers.bin"))) {
            for (int i = 0; i < n; i++) {
                System.out.print("Nhap so thu " + (i + 1) + ": ");
                int number = scanner.nextInt();
                // Ghi số nguyên thành 4 bytes nhị phân --> Tối ưu bộ nhớ
                dos.writeInt(number);
            }
            System.out.println("Tao file numbers.bin thanh cong");
        } catch (IOException e) {
            // Lệnh message() in ra thông báo lỗi ở đâu
            System.out.println("Loi IO khi tao file: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("numbers.bin"))) {
            System.out.print("Cac so trong file numbers.bin la: ");
            while (true) {
                int readNumber = dis.readInt();
                System.out.print(readNumber + " ");
            }
        // Vòng lặp sẽ thoát khi bắt được EOFException
        } catch (EOFException e) {
            System.out.println();
            System.out.println("Da doc het file");
        } catch (IOException e) {
            System.out.println();
            System.out.println("Loi IO khi doc file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}