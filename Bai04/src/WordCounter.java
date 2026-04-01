import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordMap;

    // Có class WordEntry để input cho ArrayList riêng
    /* List<WordEntry> wordList = new ArrayList<>(); */

    public WordCounter() {
        this.wordMap = new HashMap<>();
    }

    
    public void analyze(String text) {
        String cleanText = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
        
        String[] words = cleanText.split(" ");

        for (String word : words) {
            if (word.isEmpty()) continue;

            if (wordMap.containsKey(word)) {
                int count = wordMap.get(word);
                wordMap.put(word, count + 1);
            }
            else wordMap.put(word, 1);
        }
    }

    public void displayResult() {
        System.out.println("Danh sach tan suat tu: ");
        
        String mostFrequentWord = "";
        int maxCount = 0;

        // Thử với ArrayList
        /* for (String w : words) {
            if (w.isEmpty()) continue;

            boolean isFound = false;

            for (WordEntry entry : wordList) {
                if (entry.word.equals(w)) {
                    // Nếu tìm thấy từ đã có trong danh sách -> Tăng biến đếm
                    entry.count++;
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                wordList.add(new WordEntry(w, 1));
            }
        } */

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            String currentWord = entry.getKey();
            int currentCount = entry.getValue();
            System.out.println(currentWord + " || " + currentCount);

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentWord = currentWord;
            }
        }

        // Khác biệt thì như cơ chế hàm băm thôi

        System.out.println();
        System.out.println("Tu xuat hien nhieu nhat la: " + mostFrequentWord + " || " + maxCount + " lan");
    }
}
