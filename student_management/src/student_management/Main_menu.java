package student_management;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import sun.font.FontRunIterator;

import java.util.Scanner;

/**
 * ClassName: main_menu
 * Package: student_management
 * Description:
 *
 * @author 憨八嘎
 * @version 1.0
 */
public class Main_menu {
    // 在属性区域创建Scanner对象避免每一次循环都创建
    Scanner sc = new Scanner(System.in);

    // 学生数组
    Student[] students = new Student[20];

    // 数组有效数据个数
    private int size;

    // 启动
    public void menu() {
        // 循环显示界面
        while (true) {
            System.out.println("********学生信息管理系统********");
            System.out.println("1. 添加学生");
            System.out.println("2. 修改学生");
            System.out.println("3. 删除学生");
            System.out.println("4. 查看学生");
            System.out.println("5. 退出系统");
            System.out.println("********************************");
            System.out.print("请输入选项：");
            // 获取用户输入
            int choice = sc.nextInt();
            // 打印后换行
            System.out.println();
            // 使用switch语句判断输入
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

    // 添加学生
    public void addStudent() {
        // 判断数组是否已满，防止再次添加学生导致越界
        if (size == students.length) {
            System.out.println("班级已满，无法再添加");
            return;
        }


        // 添加学生
        // 获取用户输入
        System.out.print("请输入学生学号：");
        int id = sc.nextInt();
        // 如果已经存在对应学号的学生则停止输入
        int index = StudentUtils.studentIdIndex(students, size, id);
        while (index != -1)
        {
            System.out.println("已经存在该学生学号，请重新输入学生学号");
            System.out.print("请输入学生学号：");
            id = sc.nextInt();
            index = StudentUtils.studentIdIndex(students, size, id);
        }
        System.out.print("请输入学生姓名：");
        String name = sc.next();
        System.out.print("请输入学生性别：");
        String gender = sc.next();
        System.out.print("请输入学生年龄：");
        int age = sc.nextInt();
        // 通过变量创建学生对象
        Student student = new Student(id, name, gender, age);
        // 将学生对象插入到对象数组中，并且改变size大小
        students[size++] = student;

        // 排序学生
        StudentUtils.sort(students, size);
    }

    // 修改学生
    public void updateStudent() {
        // 获取用户输入
        System.out.print("请输入需要修改的学生学号：");
        int id = sc.nextInt();
        // 调用下标查找寻找学生
        int index = StudentUtils.studentIdIndex(students, size, id);
        if (index == -1) {
            // 没找到该学生时退出函数
            System.out.println("未找到该学生");
            return;
        }

        // 找到学生后开始修改
        System.out.print("请输入修改后的姓名：");
        students[index].setName(sc.next());
        System.out.print("请输入修改后的性别：");
        students[index].setGender(sc.next());
        System.out.print("请输入修改后的年龄：");
        students[index].setAge(sc.nextInt());
        System.out.println("修改成功");
    }

    // 删除学生
    public void deleteStudent() {
        // 数组为空不可以执行删除
        if (size == 0) {
            System.out.println("班级为空，删除终止");
            return;
        }

        // 删除学生
        System.out.println("请输入需要删除的学生学号");
        int id = sc.nextInt();
        int index = StudentUtils.studentIdIndex(students, size, id);
        if(index == -1)
        {
            System.out.println("未找到该学生，无法删除");
            return;
        }
        // 挪动数据
        for (int i = index; i < size; i++) {
            students[i] = students[i + 1];
        }

        // 改变size
        size--;
        System.out.println("删除成功");
    }

    // 查看所有学生
    public void showStudent() {
        System.out.println("学号" + "\t" + "姓名" + "\t" + "性别" + "\t" + "年龄");
        for (int i = 0; i < size; i++) {
            System.out.println(students[i].getId() + "\t" +
                            students[i].getName() + "\t" +
                            students[i].getGender() + "\t" +
                            students[i].getAge());
        }
    }
}
