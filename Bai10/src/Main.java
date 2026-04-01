import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type file config address: ");
        String filePath = scanner.nextLine();

        BufferedReader reader = null;
        Map<String, String> configMap = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                // Bỏ qua các dòng trống nếu có
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    configMap.put(key, value);
                }
            }

            // Kiểm tra dữ liệu: Nếu k có username/timeout thì throw exception ra
            if (!configMap.containsKey("username")) {
                throw new InvalidConfigException("Missing parameter 'username'");
            }

            if (!configMap.containsKey("timeout")) {
                throw new InvalidConfigException("Missing parameter 'timeout'");
            }
            int timeout = Integer.parseInt(configMap.get("timeout"));
            if (timeout <= 0) {
                // Lưu ý timeout lớn hơn 0
                throw new InvalidConfigException("Parameter 'timeout' must be > 0");
            }

            if (configMap.containsKey("maxConnections")) {
                int maxConnections = Integer.parseInt(configMap.get("maxConnections"));
                // Lưu ý maxConnections cũng lớn hơn 0
                if (maxConnections < 1) {
                    throw new InvalidConfigException("Parameter 'maxConnections' must be >= 1");
                }
            }

            System.out.println("\nConfig Data: ");
            for (Map.Entry<String, String> entry : configMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("=> Config loaded successfully");

        } 
        catch (FileNotFoundException e) {
            System.out.println("Error: Config file not found");
        } 
        catch (NumberFormatException e) {
            // Catch ở đoạn parseInt timeout có thể không phải số
            System.out.println("Error: Invalid number format");
        } 
        catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } 
        catch (IOException e) {
            System.out.println("I/O error when reads config");
            e.printStackTrace();
        } 
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("I/O error when closes config");
            }
            scanner.close();
            
            System.out.println("\nProgram finished.");
        }
    }
}