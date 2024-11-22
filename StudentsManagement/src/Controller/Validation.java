/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import Model.Student;
import Model.Report;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {

    private final static Scanner in = new Scanner(System.in);
    
    /**
     * Kiem tra va tra ve mot so nguyen nam trong pham vi cho truoc.
     * min Gia tri nho nhat cho phep.
     * max Gia tri lon nhat cho phep.
     * So nguyen nam trong pham vi cho truoc.
     */
    public static int checkInputIntLimit(int min, int max) {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number in the range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
        return result;
    }
    
    /**
     * Kiem tra va tra ve mot chuoi khong rong tu nguoi dung.
     * return Chuoi khong rong tu nguoi dung.
     */
    public static String checkInputString() {
        String result;
        while (true) {
            result = in.nextLine().trim();
            if (!result.isEmpty()) {
                break;
            }
            System.err.println("Input must not be empty");
            System.out.print("Enter again: ");
        }
        return result;
    }
    
    /**
     * Kiem tra va tra ve true neu nguoi dung nhap Y hoac N, false neu khong.
     * return True neu nguoi dung nhap Y, False neu nguoi dung nhap N.
     */
    public static boolean checkInputYN() {
        String result;
        while (true) {
            result = checkInputString().toUpperCase();
            if (result.equals("Y") || result.equals("N")) {
                break;
            }
            System.err.println("Please input Y/y or N/n.");
            System.out.print("Enter again: ");
        }
        return result.equals("Y");
    }
    
    /**
     * Kiem tra va tra ve true neu nguoi dung nhap U hoac D, false neu khong.
     * return True neu nguoi dung nhap U, False neu nguoi dung nhap D.
     */
    public static boolean checkInputUD() {
        String result;
        while (true) {
            result = checkInputString().toUpperCase();
            if (result.equals("U") || result.equals("D")) {
                break;
            }
            System.err.println("Please input U/u or D/d.");
            System.out.print("Enter again: ");
        }
        return result.equals("U");
    }
    
    /**
     * Kiem tra va tra ve ten khoa hoc hop le tu nguoi dung.
     * return Ten khoa hoc hop le.
     */
    public static String checkInputCourse() {
        String result;
        while (true) {
            result = checkInputString().toLowerCase();
            if (result.equals("java") || result.equals(".net") || result.equals("c/c++")) {
                break;
            }
            System.err.println("Invalid course. Valid options are: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
        return result;
    }
    
    /**
     * Kiem tra xem sinh vien đa ton tai trong danh sach hay chua.
     * Danh sach sinh vien.
     * id ID sinh viên can kiem tra.
     * studentName Ten sinh vien can kiem tra.
     * semester Hoc ky can kiem tra.
     * courseName Ten khoa hoc can kiem tra.
     * True neu sinh vien chua ton tai, False neu đa ton tai.
     */
    public static boolean checkStudentExist(ArrayList<Student> st, String id, String studentName, String semester, String courseName) {
        for (Student student : st) {
            if (id.equalsIgnoreCase(student.getId()) && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester()) && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Kiem tra xem bao cao da ton tai trong danh sach hay chua.
     * rp Danh sach bao cao.
     * name Ten sinh vien can kiem tra.
     * course Ten khoa hoc can kiem tra.
     * total Tong so khoa hoc can kiem tra.
     * return True neu bao cao chua ton tai, False neu da ton tai.
     */
    public static boolean checkReportExist(ArrayList<Report> rp, String name, String course, int total) {
        for (Report report : rp) {
            if (name.equalsIgnoreCase(report.getStudentName()) && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Kiem tra xem ID cua sinh vien da ton tai trong danh sach hay chua.
     * st Danh sach sinh vien.
     * id ID sinh vien can kiem tra.
     * name Ten sinh vien can kiem tra.
     * return True neu ID chua ton tai, False neu da ton tai.
     */
    public static boolean checkIdExist(ArrayList<Student> st, String id, String name) {
        for (Student student : st) {
            if (id.equalsIgnoreCase(student.getId()) && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Kiem tra xem thong tin cua sinh vien da thay doi hay chua.
     * student Sinh vien can kiem tra.
     * id ID sinh vien.
     * name Ten sinh vien.
     * semester Hoc ky.
     * course Ten khoa hoc.
     * return True neu thong tin da thay doi, False neu khong thay doi.
     */
    public static boolean checkChangeInformation(Student student, String id, String name, String semester, String course) {
        return !(id.equalsIgnoreCase(student.getId()) && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester()) && course.equalsIgnoreCase(student.getCourseName()));
    }
}
