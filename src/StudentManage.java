import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentManage {
    Scanner scanner = new Scanner(System.in);
    List<Students> studentsList = new ArrayList<>();
    Students[] students;
    public void displayAll(){
        for (Students st : studentsList){
            System.out.println(st);
        }
    }
    public void displayStudentByAVG(){
        for (Students st : studentsList){
            if (st.getAverage() >= 7.5){
                System.out.println(String.format(
                        "Name: %s \n Age: %s \n Gender: %s \n Address: %s \n AVG: %s \n",
                        st.getName(), st.getAge(), st.getGender(),st.getAddress(), st.getAverage()));
                break;
            }
        }
    }
    public Students addStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhâp tuổi sinh viên: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập giới tính của sinh viên: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ của sinh viên: ");
        String address = scanner.nextLine();
        System.out.println("Nhập điểm trung bình: ");
        double avg = scanner.nextDouble();
        Students students = new Students(name,age,gender,address,avg);
        System.out.println(students);
        studentsList.add(students);
        return students;
    }
    public Students editStudent(String name){
        Students students = null;
        for (Students st : studentsList){
            if (st.getName().equals(name)){
                students = st;
            }
            if (students != null){
                int index = studentsList.indexOf(students);
                System.out.println("Nhập tên sinh viên mới: ");
                String newName = scanner.next();
                students.setName(newName);

                System.out.println("Nhập tuổi sinh viên mới: ");
                int newAge= scanner.nextInt();
                scanner.nextLine();
                students.setAge(newAge);

                System.out.println("Nhập giới tính sinh viên mới: ");
                String newGender = scanner.next();
                students.setGender(newGender);

                System.out.println("Nhập địa chỉ sinh viên mới: ");
                String newAddress = scanner.next();
                students.setAddress(newAddress);

                System.out.println("Nhập điểm trung bình mới: ");
                double newAvg = scanner.nextDouble();
                students.setAverage(newAvg);

                System.out.println(String.format(
                        "Name: %s \n Age: %s \n Gender: %s \n Address: %s \n AVG: %s \n",
                        st.getName(), st.getAge(), st.getGender(),st.getAddress(), st.getAverage()));
            }
        }
        return students;
    }

    public Students deleteStudent(String name){
        Students students = null;
        for (Students st : studentsList){
            if (st.getName().equals(name)){
                students = st;
            }
        }
        studentsList.remove(students);
        System.out.println(toString());
        return students;
    }

    public static void exportCSV(){
        try (PrintWriter writer = new PrintWriter(String.format("D:/test_%s.csv", new Date().getTime()))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Tên,");
            sb.append("Tuổi,");
            sb.append("Giới tính,");
            sb.append("Địa chỉ,");
            sb.append("Điểm trung bình,");
            sb.append('\n');

            if (Main.students != null && Main.students.size() > 0) {
                sb.append(Main.students.get(0).getName());
                sb.append(',');
                sb.append(Main.students.get(0).getAge());
                sb.append(',');
                sb.append(Main.students.get(0).getGender());
                sb.append(',');
                sb.append(Main.students.get(0).getAddress());
                sb.append(',');
                sb.append(Main.students.get(0).getAverage());
                sb.append('\n');
            }

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
