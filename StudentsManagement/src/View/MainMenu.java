/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Manager;
import Controller.Validation;
import Model.Student;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class MainMenu {
    public static void main(String[] args) {
        ArrayList<Student> st = new ArrayList<>();
        Validation validation = new Validation();
        st.add(new Student("1", "Nguyen Van A", "Spring", "java"));
        st.add(new Student("2", "Nguyen Van B", "Summer", ".net"));
        st.add(new Student("3", "Nguyen Van C", "Spring", "c/c++"));
        int count = 3;
        Menu menu = new Menu();
        menu.showMenu(st, count);
    }
}
