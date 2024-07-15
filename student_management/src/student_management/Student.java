package student_management;

/**
 * ClassName: Student
 * Package: student_management
 * Description:
 *
 * @author ���˸�
 * @version 1.0
 */
public class Student {
    // ѧ������
    private int id;
    private String name;
    private String gender;
    private int age;

    // �޲ι���
    public Student() {
    }
    // �вι���
    public Student(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // get/set����
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
