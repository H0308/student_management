package student_management;

/**
 * ClassName: StudentUtils
 * Package: student_management
 * Description:
 *
 * @author 憨八嘎
 * @version 1.0
 */
public class StudentUtils {
    // 工具类私有构造函数
    private StudentUtils() {

    }

    // 提供返回索引的函数
    public static int studentIdIndex(Student[] students, int size, int id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                // 找到返回下标
                return i;
            }
        }

        // 没找到返回-1
        return -1;
    }

    // 排序学生
    public static void sort(Student[] students, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (students[i].getId() > students[i + 1].getId()) {
                    Student student = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = student;
                }
            }
        }
    }
}
