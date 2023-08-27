import model.Student;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student(110001, "Dave", new Date("11/18/1951"));
        students[1] = new Student(110002, "Anna", new Date("12/07/1990"));
        students[2] = new Student(110003, "Erica", new Date("01/31/1974"));
        students[3] = new Student(110004, "Carlos", new Date("08/22/2009"));
        students[4] = new Student(110005, "Bob", new Date("03/05/1990"));

        System.out.println("= printListOfStudents");
        printListOfStudents(students);

        System.out.println();
        System.out.println("= getListOfPlatinumAlumniStudents");
        List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents(students);

        for (Student student : platinumAlumniStudents) {
            System.out.println(MessageFormat.format("studentId:{0,number,#}, name:{1}, dateOfAdmission:{2,date,MM/dd/yyyy}", student.getStudentId(), student.getName(), student.getDateOfAdmission()));
        }

        System.out.println();
        System.out.print("=== The int array is {275, 157, 204, 103, 243, 244, 5, 60, 46, 6, 25, 3, 280, 275, 275, 282, 259, 189, 287, 132, 37, 195, 88, 222, 40, 293, 246, 166, 235}");
        int[] arrInt = {275, 157, 204, 103, 243, 244, 5, 60, 46, 6, 25, 3, 280, 275, 275, 282, 259, 189, 287, 132, 37, 195, 88, 222, 40, 293, 246, 166, 235};

        System.out.println();
        System.out.println("= printHelloWorld");
        printHelloWorld(arrInt);

        System.out.println();
        System.out.println("= findSecondBiggest");
        int secondBiggest = findSecondBiggest(arrInt);
        System.out.println(MessageFormat.format("Second biggest is {0,number,#}", secondBiggest));
    }

    static void printListOfStudents(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getName));

        for (Student student : students) {
            System.out.println(MessageFormat.format("studentId:{0,number,#}, name:{1}, dateOfAdmission:{2,date,MM/dd/yyyy}", student.getStudentId(), student.getName(), student.getDateOfAdmission()));
        }
    }

    static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        return Arrays.stream(students).filter(Student::isPlatinumAlumni).sorted(Comparator.comparing(Student::getDateOfAdmission).reversed()).collect(Collectors.toList());
    }

    static void printHelloWorld(int[] numbers) {
        for (int number : numbers) {
            boolean hasVal = false;

            if (number % 5 == 0) {
                System.out.print("Hello");
                hasVal = true;
            }

            if (number % 7 == 0) {
                System.out.print("World");
                hasVal = true;
            }

            if (hasVal) {
                System.out.println(MessageFormat.format(" {0,number,#}", number));
            }
        }
    }

    /// This method assumes that numbers has more than or equal 2 elements
    static int findSecondBiggest(int[] numbers) {
        if (numbers.length == 2) {
            return Math.min(numbers[0], numbers[1]);
        } else {
            int secondBiggest = Math.min(numbers[0], numbers[1]);
            int biggest = Math.max(numbers[0], numbers[1]);

            for (int i = 2; i < numbers.length; i++) {
                int number = numbers[i];

                if (number > biggest) {
                    secondBiggest = biggest;
                    biggest = number;
                } else {
                    secondBiggest = Math.max(secondBiggest, number);
                }
            }

            return secondBiggest;
        }
    }
}