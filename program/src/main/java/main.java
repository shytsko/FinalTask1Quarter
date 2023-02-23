import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Hamster;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

    static AnimalNursery nursery;
    static Scanner scanner;

    public static void main(String[] args) throws Exception {
        nursery = new AnimalNursery();
        boolean exit = false;
        scanner = new Scanner(System.in);

        while (!exit) {
            int command = mainMenu();
            switch (command) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("Список питомцев");
                    break;
                case 2:
                    System.out.println("Информация о питомце");
                    break;
                case 3:
                    addAnimal();
                    break;
                case 4:
                    System.out.println("Удалили питомца");
                    break;
                case 5:
                    System.out.println("Обучили питомца");
                    break;
                default:
                    System.out.println("Такая команда не предусмотрена");
            }

        }
    }

    public static int mainMenu() {
        System.out.println("Что будем делать?");
        System.out.println("0 - Выход");
        System.out.println("1 - Показать, кто живет в питомнике");
        System.out.println("2 - Показать информацию о питомце");
        System.out.println("3 - Добавить питомца");
        System.out.println("4 - Удалить питомца");
        System.out.println("5 - Обучить питомца");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            int command;
            try {
                command = Integer.parseInt(input);
            } catch (Exception ex) {
                System.out.println("Нужно ввести целое число");
                continue;
            }
            //scanner.close();
            return command;
        }
    }

    public static void addAnimal() {
        System.out.println("Кого будем добавлять?");
        System.out.println("1 - Собаку");
        System.out.println("2 - Кота");
        System.out.println("3 - Хомяка");
        int animalSpecies = -1;
        while (!(animalSpecies == 1 || animalSpecies == 2 || animalSpecies == 3)) {
            System.out.print("> ");
            String input = scanner.nextLine();
            try {
                animalSpecies = Integer.parseInt(input);
            } catch (Exception ex) {
                System.out.println("Нужно ввести целое число");
            }
            if (!(animalSpecies == 1 || animalSpecies == 2 || animalSpecies == 3))
                System.out.println("Нужно ввести 1, 2 или 3.");
        }
        String name = "";
        while (name.equals("")) {
            System.out.print("Введите имя питомца: ");
            name = scanner.nextLine();
        }

        Date birthDate;
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        while (true) {
            System.out.print("Введите дату рождения питомца питомца (yyyy-MM-dd): ");
            String input = scanner.nextLine();
            try {
                birthDate = dateFormater.parse(input);
                break;
            } catch (Exception ex) {
                System.out.println("Нужно ввести дату");
            }
        }

        try (Counter counter = new Counter()) {
            Animal newAnimal;
            switch (animalSpecies) {
                case 1:
                    newAnimal = new Dog(name, birthDate);
                    break;
                case 2:
                    newAnimal = new Cat(name, birthDate);
                    break;
                case 3:
                    newAnimal = new Hamster(name, birthDate);
                    break;
                default:
                    throw new RuntimeException("Illegal animal species");
            }
            nursery.addAnimal(newAnimal);
            counter.add();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
