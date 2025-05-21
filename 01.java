class Classroom {
    private Student[] students;
    private int count;

    public Classroom() {
        students = new Student[10];
        count = 0;
    }

    public void addStudent(Student s) {
        if (count < students.length) {
            students[count++] = s;
        } else {
            System.out.println("Classroom is full.");
        }
    }

    public void updateAttendance(int studentId, int newDaysAttended) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(newDaysAttended);
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    public void displayAllStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();

        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));

        classroom.updateAttendance(102, 16);

        classroom.updateAttendance(104, 12);

        System.out.println("Student Details:");
        classroom.displayAllStudents();
    }
}
