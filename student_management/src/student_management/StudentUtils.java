package student_management;

/**
 * ClassName: StudentUtils
 * Package: student_management
 * Description:
 *
 * @author ���˸�
 * @version 1.0
 */
public class StudentUtils {
    // ������˽�й��캯��
    private StudentUtils() {

    }

    // �ṩ���������ĺ���
    public static int studentIdIndex(Student[] students, int size, int id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                // �ҵ������±�
                return i;
            }
        }

        // û�ҵ�����-1
        return -1;
    }

    // ����ѧ��
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
