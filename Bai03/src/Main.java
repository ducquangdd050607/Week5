import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Đoạn văn bản mẫu (Tự sinh test)
        String text = "Java is great. Java is fast! Learning Java is fun, isn't it? Python is also great, but Java is Java.";

        // toLowerCase(): Chuyển tất cả thành chữ thường.
        // replaceAll("[^a-z0-9\\s]", ""): Xóa mọi thứ không phải là chữ cái, số hoặc dấu cách. (Hiểu là ngoại trừ các ký tự trong [^ ] ra thì replace thành chuỗi rỗng "")
        String cleanText = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
        // Cắt văn bản thành một mảng các từ dựa trên khoảng trắng
        String[] words = cleanText.split(" ");

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            // Tránh việc có nhiều dấu cách liên tiếp sẽ bị add vào words
            if (word.isEmpty()) continue;

            // Hàm kiểm tra có từ đó trong map chưa
            if (wordMap.containsKey(word)) {
                int count = wordMap.get(word);
                wordMap.put(word, count + 1);
            } else {
                // Chưa có sẽ khởi tạo với value = 1
                wordMap.put(word, 1);
            }
        }

        String mostFrequentWord = "";
        int maxCount = 0;
        List<String> uniqueWords = new ArrayList<>();

        // Hàm entrySet() để duyệt qua toàn bộ key-value trong HashMap
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            String currentWord = entry.getKey();
            int currentCount = entry.getValue();

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentWord = currentWord;
            }

            if (currentCount == 1) {
                uniqueWords.add(currentWord);
            }
        }

        System.out.println("Tu xuat hien nhieu nhat: " + mostFrequentWord + " || (" + maxCount + " lan)");
        System.out.println("Cac tu xuat hien chi 1 lan: " + uniqueWords);
        
        // Note: Cơ chế hoạt động của HashMap giống với cơ chế hàm băm móc nối giá trị liên tục trong 1 ngăn mà ta mới học ở bên toán rời rạc, chỉ khác là việc mã hóa sẽ tùy thuộc vào ngôn ngữ lập trình chứ kphai lúc nào cũng chia đồng dư, miễn là mã hóa ra 1 con số
    }
}