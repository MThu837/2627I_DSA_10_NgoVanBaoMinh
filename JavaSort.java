package princeton.cs.algs4;

import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

// Lớp so sánh: CGPA giảm dần -> tên tăng dần (A-Z) -> id tăng dần
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        if (x.getCgpa() != y.getCgpa()) {
            return Double.compare(y.getCgpa(), x.getCgpa());
        }
        int byName = x.getFname().compareTo(y.getFname());
        if (byName != 0) {
            return byName;
        }
        return Integer.compare(x.getId(), y.getId());
    }
}

// Solution
public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        // Phần cần viết: sắp xếp danh sách
        Collections.sort(studentList, new StudentComparator());

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
