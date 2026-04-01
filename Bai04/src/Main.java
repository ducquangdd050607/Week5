public class Main {
    // Sinh test kiểm tra
    public static void main(String[] args) {
        String data = "Hello world. This is a java program. Hello java, hello world.";
        WordCounter analyzer = new WordCounter();
        analyzer.analyze(data);
        analyzer.displayResult();
    }
}
