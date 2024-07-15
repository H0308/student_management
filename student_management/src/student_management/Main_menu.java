package student_management;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import sun.font.FontRunIterator;

import java.util.Scanner;

/**
 * ClassName: main_menu
 * Package: student_management
 * Description:
 *
 * @author ���˸�
 * @version 1.0
 */
public class Main_menu {
    // ���������򴴽�Scanner�������ÿһ��ѭ��������
    Scanner sc = new Scanner(System.in);

    // ѧ������
    Student[] students = new Student[20];

    // ������Ч���ݸ���
    private int size;

    // ����
    public void menu() {
        // ѭ����ʾ����
        while (true) {
            System.out.println("********ѧ����Ϣ����ϵͳ********");
            System.out.println("1. ���ѧ��");
            System.out.println("2. �޸�ѧ��");
            System.out.println("3. ɾ��ѧ��");
            System.out.println("4. �鿴ѧ��");
            System.out.println("5. �˳�ϵͳ");
            System.out.println("********************************");
            System.out.print("������ѡ�");
            // ��ȡ�û�����
            int choice = sc.nextInt();
            // ��ӡ����
            System.out.println();
            // ʹ��switch����ж�����
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    showStudent();
                    break;
                case 5:
                    return;
            }
        }
    }

    // ���ѧ��
    public void addStudent() {
        // �ж������Ƿ���������ֹ�ٴ����ѧ������Խ��
        if (size == students.length) {
            System.out.println("�༶�������޷������");
            return;
        }


        // ���ѧ��
        // ��ȡ�û�����
        System.out.print("������ѧ��ѧ�ţ�");
        int id = sc.nextInt();
        // ����Ѿ����ڶ�Ӧѧ�ŵ�ѧ����ֹͣ����
        int index = StudentUtils.studentIdIndex(students, size, id);
        while (index != -1)
        {
            System.out.println("�Ѿ����ڸ�ѧ��ѧ�ţ�����������ѧ��ѧ��");
            System.out.print("������ѧ��ѧ�ţ�");
            id = sc.nextInt();
            index = StudentUtils.studentIdIndex(students, size, id);
        }
        System.out.print("������ѧ��������");
        String name = sc.next();
        System.out.print("������ѧ���Ա�");
        String gender = sc.next();
        System.out.print("������ѧ�����䣺");
        int age = sc.nextInt();
        // ͨ����������ѧ������
        Student student = new Student(id, name, gender, age);
        // ��ѧ��������뵽���������У����Ҹı�size��С
        students[size++] = student;

        // ����ѧ��
        StudentUtils.sort(students, size);
    }

    // �޸�ѧ��
    public void updateStudent() {
        // ��ȡ�û�����
        System.out.print("��������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
        int id = sc.nextInt();
        // �����±����Ѱ��ѧ��
        int index = StudentUtils.studentIdIndex(students, size, id);
        if (index == -1) {
            // û�ҵ���ѧ��ʱ�˳�����
            System.out.println("δ�ҵ���ѧ��");
            return;
        }

        // �ҵ�ѧ����ʼ�޸�
        System.out.print("�������޸ĺ��������");
        students[index].setName(sc.next());
        System.out.print("�������޸ĺ���Ա�");
        students[index].setGender(sc.next());
        System.out.print("�������޸ĺ�����䣺");
        students[index].setAge(sc.nextInt());
        System.out.println("�޸ĳɹ�");
    }

    // ɾ��ѧ��
    public void deleteStudent() {
        // ����Ϊ�ղ�����ִ��ɾ��
        if (size == 0) {
            System.out.println("�༶Ϊ�գ�ɾ����ֹ");
            return;
        }

        // ɾ��ѧ��
        System.out.println("��������Ҫɾ����ѧ��ѧ��");
        int id = sc.nextInt();
        int index = StudentUtils.studentIdIndex(students, size, id);
        if(index == -1)
        {
            System.out.println("δ�ҵ���ѧ�����޷�ɾ��");
            return;
        }
        // Ų������
        for (int i = index; i < size; i++) {
            students[i] = students[i + 1];
        }

        // �ı�size
        size--;
        System.out.println("ɾ���ɹ�");
    }

    // �鿴����ѧ��
    public void showStudent() {
        System.out.println("ѧ��" + "\t" + "����" + "\t" + "�Ա�" + "\t" + "����");
        for (int i = 0; i < size; i++) {
            System.out.println(students[i].getId() + "\t" +
                            students[i].getName() + "\t" +
                            students[i].getGender() + "\t" +
                            students[i].getAge());
        }
    }
}
