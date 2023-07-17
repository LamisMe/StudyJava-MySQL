package extra_exercises.view;

import extra_exercises.controller.PersonController;

public class Main {
    public static void main(String[] args) {
        PersonController personController = new PersonController();
        personController.showMenu();
    }
}