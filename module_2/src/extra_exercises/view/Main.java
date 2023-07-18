package extra_exercises.view;

import extra_exercises.controller.PersonController;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PersonController personController = new PersonController();
        personController.showMenu();
    }
}