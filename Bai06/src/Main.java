import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhap so nguyen a: ");
            int a = scanner.nextInt();
            System.out.print("Nhap so nguyen b: ");
            int b = scanner.nextInt();
            int result = a / b;
            System.out.println("a / b = " + result);
        } 
        // Exception 1: input chữ thay vì nhập số
        catch (InputMismatchException e) {
            System.out.println("Ban phai nhap vao 1 so nguyen");
        } 
        // Exception 2: chia cho 0
        catch (ArithmeticException e) {
            System.out.println("So chia khong the bang 0");
        }

        finally {
            System.out.println("Program finished.");
            scanner.close();
        }
    }
}