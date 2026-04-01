public class Main {
    // Hàm 1: Nối chuỗi bằng String thông thường
    public static void useString() {
        // Trong Java, hàm System.currentTimeMillis() có nhiệm vụ trả về một con số long cực lớn. Con số này chính là số mili-giây (1 giây = 1000 mili-giây) đã trôi qua kể từ nửa đêm ngày 1/1/1970 cho đến ngay khoảnh khắc dòng code đó được thực thi.
        // Lấy mốc thời gian bắt đầu
        long startTime = System.currentTimeMillis();
        
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += "Hello";
        }

        // Lấy mốc thời gian kết thúc
        long endTime = System.currentTimeMillis();

        // Trừ đi 2 mốc thời gian là ra thời gian chạy code
        System.out.println("Thoi gian chay cua String: " + (endTime - startTime) + " ms");
    }

    // Hàm 2: Nối chuỗi bằng StringBuffer
    public static void useStringBuffer() {
        // Tương tự như trên
        long startTime = System.currentTimeMillis();
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Thoi gian chay cua StringBuffer(): " + (endTime - startTime) + " ms");
    }

    // Hàm 3: Phân tích nội dung văn bản
    public static void contentAnalysis(String text) {
        // Dùng split "[.!?]+" để bắt các dấu câu kết thúc
        String[] sentences = text.split("[.!?]+");
        int sentenceCount = (text.isEmpty()) ? 0 : sentences.length;
        System.out.println("So cau: " + sentenceCount + " câu.");

        // Hàm replace thay Java bằng Python
        String replacedText = text.replace("Java", "Python");
        System.out.println("Van ban sau khi replace: ");
        System.out.println(replacedText);
    }

    // Test lại
    public static void main(String[] args) {
        // String copy rồi nối vào bản copy, StringBuffer thêm vào luôn (Mutable)
        useString();
        useStringBuffer();

        System.out.println();

        String sampleText = "Hello there! Are you ready to test your code? Java is an incredibly popular programming language used worldwide. Many enterprise applications rely heavily on Java for their backend systems. Isn't it amazing how fast Java can be when optimized properly? Good luck with your testing!";
        contentAnalysis(sampleText);
    }
}