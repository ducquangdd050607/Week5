import java.io.Serializable;

// Serialization là mã hóa nhị phân data xong ghép liên tiếp lại r đẩy vào ổ cứng (yêu cầu implements interface Serializable)
public class Student implements Serializable {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", GPA=" + gpa + "]";
    }
}