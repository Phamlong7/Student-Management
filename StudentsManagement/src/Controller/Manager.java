/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Report;
import Model.Student;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author ACER
 */
public class Manager {
    // Show menu
    public static void menu() {
        System.out.println(" 1. Create");
        System.out.println(" 2. Find and Sort");
        System.out.println(" 3. Update/Delete");
        System.out.println(" 4. Report");
        System.out.println(" 5. Exit");
        System.out.print(" Enter your choice: ");
    }

    /**
     * Phuong thuc cho phep nguoi dung tao moi 1 sinh vien.
     * count So luong sinh vien hien tai trong danh sach.
     * st Danh sach sinh vien.
     */
    public static void createStudent(int count, ArrayList<Student> st) {
        // Kiem tra neu danh sách đay
        if (count > 10) {
            System.out.print("Do you want to continue (Y/N): ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        // Them sinh vien moi
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.print("Enter name student: ");
            String name = Validation.checkInputString();
            // Kiem tra xem ID đa ton tai cho sinh vien khac chua
            if (!Validation.checkIdExist(st, id, name)) {
                System.err.println("Id already exists for a student. Please re-enter.");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = Validation.checkInputString();
            System.out.print("Enter course name: ");
            String course = Validation.checkInputCourse();
            // Kiem tra xem thong tin sinh vien đa ton tai hay chua
            if (Validation.checkStudentExist(st, id, name, semester, course)) {
                st.add(new Student(id, name, semester, course));
                count++;
                System.out.println("Student added successfully.");
                return;
            }
            System.err.println("Duplicate entry.");
        }
    }

     /**
     * Phuong thuc cho phep nguoi dung tim kiem và sap xep sinh vien theo ten. 
     * st Danh sach sinh vien.
     */
    public static void findAndSort(ArrayList<Student> st) {
        // Kiem tra danh sach rong
        if (st.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }
         // Tim kiem và sap xep sinh vien theo ten
        ArrayList<Student> listStudentFindByName = listStudentFindByName(st);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("No students found.");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "Semester", "Course Name");
            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }

    /**
     * Phuong thuc cho phep nguoi dung tim kiem name.
     * st Danh sach sinh vien.
     */
    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> st) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = Validation.checkInputString();
        for (Student student : st) {
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    // cho phep nguoi dung cap nhat hoac xoa
    public static void updateOrDelete(int count, ArrayList<Student> st) {
        if (st.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }
        // Nhap ID đe cap nhat hoac xoa sinh vien
        System.out.print("Enter id: ");
        String id = Validation.checkInputString();
        ArrayList<Student> listStudentFindByName = getListStudentById(st, id);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Student not found.");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            // Hoi nguoi dung
            System.out.print("Do you want to update (U) or delete (D) student: ");
            if (Validation.checkInputUD()) {
                System.out.print("Enter id: ");
                String idStudent = Validation.checkInputString();
                System.out.print("Enter name student: ");
                String name = Validation.checkInputString();
                System.out.print("Enter semester: ");
                String semester = Validation.checkInputString();
                System.out.print("Enter course name: ");
                String course = Validation.checkInputCourse();
                // Kiem tra xem thong tin đa thay đoi hay khong
                if (!Validation.checkChangeInformation(student, id, name, semester, course)) {
                    System.err.println("No changes made.");
                }
                // Kiem tra xem thong tin moi da ton tai hay chua
                if (Validation.checkStudentExist(st, id, name, semester, course)) {
                    student.setId(idStudent);
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(course);
                    System.err.println("Update successful.");
                }
                return;
            } else {
                 // Xoa sinh vien khoi danh sach
                st.remove(student);
                count--;
                System.err.println("Delete successful.");
                return;
            }
        }
    }

    // lay sinh vien muon cap nhat hoac xoa trong list
    public static Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("List of students found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "Semester", "Course Name");
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = Validation.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

    // lay list hoc sinh tim bang ID
    public static ArrayList<Student> getListStudentById(ArrayList<Student> st, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : st) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }
    // viet report
    public static void report(ArrayList<Student> st) {
        if (st.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }

        System.out.println("Report:");
        System.out.println("Student name\tCourse\tTotal of Course");
        for (Student student : st) {
            String studentName = student.getStudentName();
            String courseName = student.getCourseName();
            int totalCourses = getTotalCourses(st, studentName, courseName);
            System.out.printf("%s\t%s\t%d\n", studentName, courseName, totalCourses);
        }
    }

    // lay total course trong list
    public static int getTotalCourses(ArrayList<Student> st, String studentName, String courseName) {
        int totalCourses = 0;
        for (Student student : st) {
            if (student.getStudentName().equals(studentName) && student.getCourseName().equals(courseName)) {
                totalCourses++;
            }
        }
        return totalCourses;
    }

}
