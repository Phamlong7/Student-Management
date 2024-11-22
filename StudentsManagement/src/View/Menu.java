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
public class Menu {
    
   public void showMenu(ArrayList<Student> st, int count) {
        Validation validation = new Validation();
        while (true) {
            // Show menu 
            Controller.Manager.menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    Manager.createStudent(count, st);
                    break;
                case 2:
                    Manager.findAndSort(st);
                    break;
                case 3:
                    Manager.updateOrDelete(count, st);
                    break;
                case 4:
                    Manager.report(st);
                    break;
                case 5:
                    return;
            }
        }
    }
}
