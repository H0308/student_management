package student_management;

/**
 * ClassName: Student
 * Package: student_management
 * Description:
 *
 * @author 憨八嘎
 * @version 1.0
 */
public class Student {
    // 学生属性
    private int id;
    private String name;
    private String gender;
    private int age;

    // 无参构造
    public Student() {
    }
    // 有参构造
    public Student(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // get/set方法
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
