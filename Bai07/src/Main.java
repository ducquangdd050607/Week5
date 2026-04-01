import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Source: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Destination: ");
        String destPath = scanner.nextLine();
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            // Tìm file source và tìm vị trí destination
            reader = new BufferedReader(new FileReader(sourcePath));
            writer = new PrintWriter(new FileWriter(destPath));

            String line;
            int lineCount = 0;
            // readLine() trả về null khi đã đọc đến cuối file
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;
            }
            System.out.println("So dong da sao chep la: " + lineCount);

        } 
        catch (FileNotFoundException e) {
            // Dựa vào trạng thái của reader để biết lỗi do file nào gây ra, nếu reader có giá trị tức là lỗi ở destination
            if (reader == null) {
                System.out.println("Khong tim thay source file");
            } else {
                System.out.println("Khong the khoi tao destination file");
            }
        } 
        catch (IOException e) {
            System.out.println("Loi IO, khong the chay code");
            // Stack trace ở đây là console báo lỗi mà nếu k try-catch sẽ thấy đó
            e.printStackTrace();
        } 
        finally {
            // Lệnh close() của BufferedReader cũng có thể xảy ra exception (vd file bị xóa hay ổ cứng ngắt kết nối)
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Co loi xay ra khi close source file");
            }

            // Hàm close() của PrintWriter không có exception
            if (writer != null) {
                writer.close();
            }
            
            scanner.close();
        }
    }
}