import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Students> students = new ArrayList<>();

    public static void main(String[] args) {
        StudentManage studentManage = new StudentManage();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Chon tinh nang:");
            System.out.println("1. Thêm Sinh Viên.");
            System.out.println("2. Hiển  thị tất cả.");
            System.out.println("3. Hiển thị theo tên Sinh viên.");
            System.out.println("4. Sửa thông tin sinh viên theo tên.");
            System.out.println("5. Xóa sinh viên theo tên.");
            System.out.println("6. Hiển thị tất cả sinh viên trên 7.5.");
            System.out.println("7. Xuất csv");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        studentManage.addStudent();
                        break;
                    case 2:
                        studentManage.displayAll();
                        break;
                    case 3:
                        //chưa làm mà đòi gọi đến à
                        break;
                    case 4:
                        System.out.println("Nhập tên sinh viên:");
                        String name = scanner.nextLine();
                        studentManage.editStudent(name);
                        break;
                    case 5:
                        System.out.println("Nhập tên sinh viên:");
                        String name1 = scanner.nextLine();
                        studentManage.deleteStudent(name1);
                        break;
                    case 6:
                        studentManage.displayStudentByAVG();
                        break;
                    case 7:
                        // tính hoàn thiện ạ
                        break;
                }
            }catch (Exception e){
                System.out.println("kí tự không hợp lệ !!!!");
            }
        }
    }
}
